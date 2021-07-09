package uk.co.webcompere.seleniumjunit5.junit;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import uk.co.webcompere.seleniumjunit5.pool.DriverPool;
import uk.co.webcompere.seleniumjunit5.spring.ThreadLocalScope;

/**
 * Adds AfterEach behaviour to release a web driver and to take a screenshot
 * for any test that's just failed.
 */
public class ReleaseResourcesExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        try {
            System.out.println("After each: " + Thread.currentThread().getName());
            if (context.getExecutionException().isPresent()) {
                DriverPool.INSTANCE.get().ifPresent(driver -> driver.takeScreenShot());
            }
        } finally {
            ThreadLocalScope.releaseThisThreadsBeans();
            DriverPool.INSTANCE.release();
        }
    }
}
