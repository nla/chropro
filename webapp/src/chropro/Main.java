package chropro;

import org.imgscalr.Scalr;
import spark.Spark;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String args[]) throws ExecutionException, InterruptedException, IOException, TimeoutException {
        String chromeHost = "127.0.0.1";
        int chromePort = 9292;

        if (System.getenv("PORT") != null) {
            Spark.port(Integer.parseInt(System.getenv("PORT")));
        }

        if (System.getenv("CHROME_HOST") != null) {
            chromeHost = System.getenv("CHROME_HOST");
        }

        if (System.getenv("CHROME_PORT") != null) {
            chromePort = Integer.parseInt(System.getenv("CHROME_PORT"));
        }

        Renderer renderer = new Renderer(chromeHost, chromePort);

        Spark.get("/",(request, response) -> "<!doctype html><form action='/image'>" +
                        "<input name=url placeholder=url required><br>" +
                        "<input name=size placeholder=size value=256><br>" +
                        "<input type=submit value='Get Thumbnail'></form>");

        Spark.get("/image", (request, response) -> {
            String url = request.queryParams("url");
            Integer size = or(request.queryMap("size").integerValue(), 256);
            Integer w = request.queryMap("w").integerValue();
            Integer h = request.queryMap("h").integerValue();
            Integer vpw = or(request.queryMap("vpw").integerValue(), 1280);
            Integer vph = or(request.queryMap("vph").integerValue(), 800);
            String format = or(request.queryParams("format"), "jpeg");
            Integer timeout = or(request.queryMap("timeout").integerValue(), 10000);
            Integer sleep = or(request.queryMap("sleep").integerValue(), 100);

            if (url == null) {
                response.status(400);
                response.type("text/plain");
                return "url is mandatory";
            }

            response.type("image/" + format);
            try {
                byte[] data = renderer.render(url, vpw, vph, timeout, sleep);
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
                if (w == null || h == null) {
                    image = Scalr.resize(image, size);
                } else {
                    image = Scalr.resize(image, w, h);
                }
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, format, baos);
                return baos.toByteArray();
            } catch (TimeoutException e) {
                response.status(500);
                response.type("text/plain");
                return "timed out";
            }
        });
    }

    private static <T> T or(T a, T b) {
        return a == null ? b : a;
    }

}
