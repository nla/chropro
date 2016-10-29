package chropro;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String args[]) throws ExecutionException, InterruptedException, IOException {
        try (Chropro chrome = new Chropro(9292)) {
            System.out.println(chrome.systemInfo.getInfo());
        }
    }
}
