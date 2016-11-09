package chropro;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Renderer implements AutoCloseable {


    private final Chropro chrome;
    private final URI uri;

    public Renderer() throws IOException {
        this.uri = URI.create("ws://127.0.0.1:9292/devtools/browser");
        this.chrome = new Chropro(uri);

    }

    public byte[] render(String url, int w, int h, int timeout, int sleep) throws ExecutionException, InterruptedException, IOException, TimeoutException {
        String contextId = chrome.target.createBrowserContext().get(timeout, MILLISECONDS).browserContextId;
        String targetId = null;
        try {
            targetId = chrome.target.createTarget("about:blank", w, h, contextId).get(timeout, MILLISECONDS).targetId;

            // Chrome is buggy and won't let us connect unless we've refreshed the json endpoint
            jsonEndpoint(uri).toURL().openStream().close();

            try (Chropro tab = new Chropro(uri.resolve("/devtools/page/" + targetId))) {
                tab.target.getTargetInfo(targetId).get(timeout, MILLISECONDS);
                tab.page.enable().get(timeout, MILLISECONDS);
                CompletableFuture<PageDomain.LoadEventFired> loaded = tab.page.onLoadEventFired();

                System.out.println("navigating");
                tab.page.navigate(url).get(timeout, MILLISECONDS);

                loaded.get(timeout, MILLISECONDS);

                // disable scrollbars
                tab.runtime.evaluate("document.getElementsByTagName('body')[0].style.overflow='hidden'", null, null, null, null, null, null, null, null).get(timeout, MILLISECONDS);

                // wait a little for any onload javascript to fire
                Thread.sleep(sleep);

                String data = tab.page.captureScreenshot().get(timeout, MILLISECONDS).data;
                return Base64.getDecoder().decode(data);
            }
        } finally {
            if (targetId != null) {
                chrome.target.closeTarget(targetId).get(timeout, MILLISECONDS);
            }
            chrome.target.disposeBrowserContext(contextId).get(timeout, MILLISECONDS);
        }
    }

    /**
     * "ws://127.0.0.1:9292/devtools/browser" => "http://127.0.0.1:9292/json"
     */
    static URI jsonEndpoint(URI uri) {
        try {
            return new URI("http",
                    uri.getUserInfo(), uri.getHost(), uri.getPort(),
                    "/json", null, null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void close() throws Exception {
        chrome.close();
    }
}
