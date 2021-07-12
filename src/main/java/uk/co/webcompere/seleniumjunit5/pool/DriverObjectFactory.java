package uk.co.webcompere.seleniumjunit5.pool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.webcompere.seleniumjunit5.config.Configuration;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Plugs into the {@link DriverPool}'s <code>GenericObjectPool</code> to build web drivers according
 * to the settings.
 */
public class DriverObjectFactory extends BasePooledObjectFactory<WebDriver> {
    private Configuration configuration;

    public DriverObjectFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public WebDriver create() throws Exception {
        if (!isBlank(configuration.getRemoteDriverUrl())) {
            return configuration.getDriver().createRemote(configuration.getRemoteDriverUrl());
        }
        return configuration.getDriver().create();
    }

    @Override
    public void destroyObject(PooledObject<WebDriver> pooled) throws Exception {
        pooled.getObject().quit();
    }

    @Override
    public void passivateObject(PooledObject<WebDriver> pooled) throws Exception {
        WebDriver driver = pooled.getObject();
        driver.manage().deleteAllCookies();
        driver.navigate().to("about:blank");
    }

    @Override
    public PooledObject<WebDriver> wrap(WebDriver obj) {
        return new DefaultPooledObject<>(obj);
    }
}
