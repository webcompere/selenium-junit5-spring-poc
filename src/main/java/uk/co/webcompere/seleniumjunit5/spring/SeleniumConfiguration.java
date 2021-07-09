package uk.co.webcompere.seleniumjunit5.spring;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.*;
import uk.co.webcompere.seleniumjunit5.config.ConfigurationLoader;
import uk.co.webcompere.seleniumjunit5.pool.DriverPool;

import javax.annotation.PreDestroy;

@SpringBootConfiguration
@ComponentScan("uk.co.webcompere.seleniumjunit5")
public class SeleniumConfiguration {

    /**
     * Close all browsers when the test is done
     * @throws Exception on error
     */
    @PreDestroy
    public void preDestroy() throws Exception {
        DriverPool.INSTANCE.clear();
    }

    @Bean
    @Scope("prototype")
    public WebDriver webDriver() throws Exception {
        return DriverPool.INSTANCE.allocate();
    }

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new ThreadLocalScopePostProcessor();
    }

    @Bean
    public uk.co.webcompere.seleniumjunit5.config.Configuration configuration() {
        return ConfigurationLoader.getConfiguration();
    }
}
