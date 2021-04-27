package uk.co.webcompere.seleniumjunit5sprintpoc.junit;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import uk.co.webcompere.seleniumjunit5sprintpoc.pool.DriverPool;

public class ReleaseDriversExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("After each: " + Thread.currentThread().getName());
        DriverPool.INSTANCE.release();
    }
}
