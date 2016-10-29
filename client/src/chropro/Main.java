package chropro;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.allOf;

public class Main {
    public static void main(String args[]) throws ExecutionException, InterruptedException, IOException {
        //WebSocketImpl.DEBUG = true;

        long start = System.currentTimeMillis();

        URI uri = URI.create("ws://127.0.0.1:9292/devtools/browser");
        String targetId;
        try (Chropro chrome = new Chropro(uri)) {
            String contextId = chrome.target.createBrowserContext().get().browserContextId;
            try {

                targetId = chrome.target.createTarget("about:blank", 800, 600, contextId).get().targetId;

                // Chrome is buggy and won't let us connect unless we've refreshed the json endpoint
                jsonEndpoint(uri).toURL().openStream().close();

                try (Chropro tab = new Chropro(URI.create("ws://127.0.0.1:9292/devtools/page/" + targetId))) {
                    tab.target.getTargetInfo(targetId).get();
                    tab.page.enable().get();
                    CompletableFuture<PageDomain.LoadEventFired> loaded = tab.page.onLoadEventFired();

                    tab.page.navigate("http://www.nla.gov.au/");

                    System.out.println(loaded.get());
                    System.out.println(System.currentTimeMillis() - start);

                    allOf(
                            tab.emulation.setDeviceMetricsOverride(1280, 800, 1.0, false, true, 1.0, 0.0, 0.0, 1280, 800, 0, 0, null),
                            tab.emulation.setVisibleSize(256, 160),
                            tab.emulation.forceViewport(0.0, 0.0, 1.0)
                    ).get();
                    String data = tab.page.captureScreenshot().get().data;
                    Files.write(Paths.get("/tmp/screenshot.png"), Base64.getDecoder().decode(data), StandardOpenOption.CREATE);


                } finally {
                    chrome.target.closeTarget(targetId);
                }
            } finally {
                chrome.target.disposeBrowserContext(contextId).get();
            }
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
}
