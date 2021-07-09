package uk.co.webcompere.seleniumjunit5.config;

public class Configuration {
    private Integer poolMax;
    private Integer poolMaxIdleTime;

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
}
