package uk.co.webcompere.seleniumjunit5.pool;

import org.openqa.selenium.WebDriver;
import uk.co.webcompere.seleniumjunit5.config.Configuration;

import java.util.function.Function;

/**
 * How to create a web driver for this browser type
 */
public interface DriverCreator extends Function<Configuration, WebDriver> {
}
