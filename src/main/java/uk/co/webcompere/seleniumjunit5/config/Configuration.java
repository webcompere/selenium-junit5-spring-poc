package uk.co.webcompere.seleniumjunit5.config;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Integer poolMax;
    private Integer poolMaxIdleTime;
    private String baseUrl;
    private Map<String, String> additionalAttributes = new HashMap<>();

    public Integer getPoolMax() {
        return poolMax;
    }

    public void setPoolMax(Integer poolMax) {
        this.poolMax = poolMax;
    }

    public Integer getPoolMaxIdleTime() {
        return poolMaxIdleTime;
    }

    public void setPoolMaxIdleTime(Integer poolMaxIdleTime) {
        this.poolMaxIdleTime = poolMaxIdleTime;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Map<String, String> getAdditionalAttributes() {
        return additionalAttributes;
    }

    public void setAdditionalAttributes(Map<String, String> additionalAttributes) {
        this.additionalAttributes = additionalAttributes;
    }
}
