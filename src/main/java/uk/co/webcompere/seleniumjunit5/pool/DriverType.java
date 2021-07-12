package uk.co.webcompere.seleniumjunit5.pool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;

public enum DriverType {
    CHROME(ChromeDriver::new, ChromeOptions::new, WebDriverManager::chromedriver),
    FIREFOX(FirefoxDriver::new, FirefoxOptions::new, WebDriverManager::firefoxdriver);

    private Supplier<WebDriver> newInstance;
    private Supplier<Capabilities> newOptions;
    private Supplier<WebDriverManager> driverManager;
    private boolean hasSetUp = false;

    DriverType(Supplier<WebDriver> newInstance,
               Supplier<Capabilities> newOptions,
               Supplier<WebDriverManager> driverManager) {
        this.newInstance = newInstance;
        this.newOptions = newOptions;
        this.driverManager = driverManager;
    }

    public WebDriver create() {
        ensureDriverPresent();
        return newInstance.get();
    }

    public WebDriver createRemote(String url) throws MalformedURLException {
        ensureDriverPresent();
        return new RemoteWebDriver(new URL(url), createOptions());
    }

    private synchronized void ensureDriverPresent() {
        if (hasSetUp) {
            return;
        }
        driverManager.get().setup();
        hasSetUp = true;
    }

    private Capabilities createOptions() {
        return newOptions.get();
    }
}
