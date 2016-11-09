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
    public static void main(String args[]) throws ExecutionException, InterruptedException, IOException {
        Renderer renderer = new Renderer();

        if (System.getenv("PORT") != null) {
            Spark.port(Integer.parseInt(System.getenv("PORT")));
        }
        
        Spark.get("/image", (request, response) -> {
            String url = request.queryParams("url");
            Integer size = or(request.queryMap("size").integerValue(), 256);
            Integer w = request.queryMap("w").integerValue();
            Integer h = request.queryMap("h").integerValue();
            Integer vpw = or(request.queryMap("vpw").integerValue(), 1280);
            Integer vph = or(request.queryMap("vph").integerValue(), 800);
            String format = or(request.queryParams("format"), "jpeg");
            Integer timeout = or(request.queryMap("timeout").integerValue(), 10000);

            if (url == null) {
                response.status(400);
                response.type("text/plain");
                return "url is mandatory";
            }

            response.type("image/" + format);
            try {
                byte[] data = renderer.render(url, vpw, vph, timeout);
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
