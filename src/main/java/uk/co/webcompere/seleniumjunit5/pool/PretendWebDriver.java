package uk.co.webcompere.seleniumjunit5.pool;

import java.io.Closeable;
import java.util.UUID;

public class PretendWebDriver implements Closeable, Resettable {
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    @Override
    public void close() {

    }

    public void takeScreenShot() {
        System.out.println("Click");
    }

    @Override
    public void reset() {

    }
}
