package uk.co.webcompere.seleniumjunit5.junit;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import uk.co.webcompere.seleniumjunit5.pool.DriverPool;
import uk.co.webcompere.seleniumjunit5.spring.ThreadLocalScope;

import java.io.File;

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
                DriverPool.INSTANCE.get().ifPresent(driver -> {
                    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    System.out.println("Error screenshot at " + file.getAbsolutePath());
                });
            }
        } finally {
            ThreadLocalScope.releaseThisThreadsBeans();
            DriverPool.INSTANCE.release();
        }
    }
}
