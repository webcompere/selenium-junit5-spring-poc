package uk.co.webcompere.seleniumjunit5sprintpoc.pool;

import java.io.Closeable;
import java.util.UUID;

public class PretendWebDriver implements Closeable {
    private String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    @Override
    public void close() {

    }
}
