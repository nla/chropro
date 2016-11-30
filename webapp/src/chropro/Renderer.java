package chropro;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Renderer implements AutoCloseable {


    private final Chropro chrome;
    private final String chromeHost;
    private final int chromePort;

    public Renderer(String chromeHost, int chromePort) throws IOException {
        this.chromeHost = chromeHost;
        this.chromePort = chromePort;
        this.chrome = new Chropro("ws://" + this.chromeHost + ":" + this.chromePort + "/devtools/browser");

    }

    public byte[] render(String url, int w, int h, int timeout, int sleep) throws ExecutionException, InterruptedException, IOException, TimeoutException {
        String contextId;

        try {
            contextId = chrome.target.createBrowserContext().get(timeout, MILLISECONDS).browserContextId;
        } catch (ExecutionException e) {
            contextId = null; // browser contexts are only supported on headless chrome
        }

        String targetId = null;
        try {
            targetId = chrome.target.createTarget("about:blank", w, h, contextId).get(timeout, MILLISECONDS).targetId;

            // Chrome is buggy and won't let us connect unless we've refreshed the json endpoint
            new URL("http://" + chromeHost + ":" + chromePort + "/json").openStream().close();

            try (Chropro tab = new Chropro("ws://" + chromeHost + ":" + chromePort + "/devtools/page/" + targetId)) {
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
            if (contextId != null) {
                chrome.target.disposeBrowserContext(contextId).get(timeout, MILLISECONDS);
            }
        }
    }
    @Override
    public void close() throws Exception {
        chrome.close();
    }
}
