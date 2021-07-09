package uk.co.webcompere.seleniumjunit5.pool;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import uk.co.webcompere.seleniumjunit5.config.Configuration;

/**
 * Plugs into the {@link DriverPool}'s <code>GenericObjectPool</code> to build web drivers according
 * to the settings.
 */
public class DriverObjectFactory extends BasePooledObjectFactory<WebDriver> {
    private Configuration configuation;

    public DriverObjectFactory(Configuration configuation) {
        this.configuation = configuation;
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public WebDriver create() {
        return new ChromeDriver();
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
