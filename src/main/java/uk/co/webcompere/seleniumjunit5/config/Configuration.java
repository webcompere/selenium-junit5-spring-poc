package uk.co.webcompere.seleniumjunit5.config;

import uk.co.webcompere.seleniumjunit5.pool.DriverType;

import java.util.HashMap;
import java.util.Map;

import static uk.co.webcompere.seleniumjunit5.pool.DriverType.CHROME;

public class Configuration {
    private Integer poolMax;
    private Integer poolMaxIdleTime;
    private String baseUrl;
    private Map<String, String> additionalAttributes = new HashMap<>();
    private DriverType driver = CHROME;
    private String remoteDriverUrl;
    private String screenshotPath = "build/test-results/screenshots";

    /**
     * Maximum number of browsers to hold in the pool - also constrains maximum users
     * using the system
     * @return the maximum concurrency at browser level
     */
    public Integer getPoolMax() {
        return poolMax;
    }

    public void setPoolMax(Integer poolMax) {
        this.poolMax = poolMax;
    }

    /**
     * Maximum time a browser can be idle in the bool before being evicted
     * @return the maximum time in milliseconds
     */
    public Integer getPoolMaxIdleTime() {
        return poolMaxIdleTime;
    }

    public void setPoolMaxIdleTime(Integer poolMaxIdleTime) {
        this.poolMaxIdleTime = poolMaxIdleTime;
    }

    /**
     * Base url of the system under test
     * @return the system under test's address
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Useful additional attributes to save producing another config mechanism
     * @return attributes
     */
    public Map<String, String> getAdditionalAttributes() {
        return additionalAttributes;
    }

    public void setAdditionalAttributes(Map<String, String> additionalAttributes) {
        this.additionalAttributes = additionalAttributes;
    }

    /**
     * Which driver is being used
     * @return the driver type
     */
    public DriverType getDriver() {
        return driver;
    }

    public void setDriver(DriverType driver) {
        this.driver = driver;
    }

    /**
     * Get the address of the remote version of the browser
     * @return the url or blank for none
     */
    public String getRemoteDriverUrl() {
        return remoteDriverUrl;
    }

    public void setRemoteDriverUrl(String remoteDriverUrl) {
        this.remoteDriverUrl = remoteDriverUrl;
    }

    /**
     * Where to write the screenshots on the file system
     * @return the path to the screenshot
     */
    public String getScreenshotPath() {
        return screenshotPath;
    }

    public void setScreenshotPath(String screenshotPath) {
        this.screenshotPath = screenshotPath;
    }
}
