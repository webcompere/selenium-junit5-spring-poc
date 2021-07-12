package uk.co.webcompere.seleniumjunit5.junit;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import uk.co.webcompere.seleniumjunit5.config.Configuration;
import uk.co.webcompere.seleniumjunit5.config.ConfigurationLoader;
import uk.co.webcompere.seleniumjunit5.pool.DriverPool;
import uk.co.webcompere.seleniumjunit5.spring.TestCaseScope;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Adds AfterEach behaviour to release resources and to take a screenshot
 * for any test that's just failed.
 */
public class TestCaseCleanupExtension implements AfterEachCallback {

    private static final Configuration CONFIGURATION = ConfigurationLoader.getConfiguration();

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        try {
            if (context.getExecutionException().isPresent()) {
                Optional<WebDriver> driver = DriverPool.INSTANCE.get();
                if (driver.isPresent()) {
                    takeScreenShot(driver.get(), context);
                }
            }
        } finally {
            TestCaseScope.releaseThisThreadsBeans();
            DriverPool.INSTANCE.release();
        }
    }

    private void takeScreenShot(WebDriver driver, ExtensionContext context) throws IOException {
        if (!(driver instanceof TakesScreenshot)) {
            return;
        }
        TakesScreenshot screenshotter = (TakesScreenshot)driver;
        File file = screenshotter.getScreenshotAs(OutputType.FILE);

        Path targetScreenShotDirectory = Path.of(CONFIGURATION.getScreenshotPath())
                .resolve(context.getTestInstance().get().getClass().getCanonicalName());
        Files.createDirectories(targetScreenShotDirectory);
        Path targetPath = targetScreenShotDirectory.resolve(sanitiseFilename(context.getDisplayName()) + ".png");
        Files.copy(file.toPath(), targetPath, REPLACE_EXISTING);

        System.err.println(context.getDisplayName() + ": error screenshot at " + targetPath.toAbsolutePath());
    }

    private static String sanitiseFilename(String name) {
        // remove trailing () and then sanitise non filename characters
        return name.replaceAll("\\(\\)$", "")
                .replaceAll("[\\\\/:*?\"<>|]", "_");
    }
}
