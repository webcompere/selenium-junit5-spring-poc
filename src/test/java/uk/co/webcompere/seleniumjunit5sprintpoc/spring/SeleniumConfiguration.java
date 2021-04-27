package uk.co.webcompere.seleniumjunit5sprintpoc.spring;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.*;
import uk.co.webcompere.seleniumjunit5sprintpoc.pool.PretendWebDriver;
import uk.co.webcompere.seleniumjunit5sprintpoc.pool.DriverPool;

import javax.annotation.PreDestroy;

@SpringBootConfiguration
@ComponentScan("uk.co.webcompere.seleniumjunit5sprintpoc")
public class SeleniumConfiguration {

    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println("predestroy");
        DriverPool.INSTANCE.clear();
    }

    @Bean
    @Scope("prototype")
    public PretendWebDriver foo() throws Exception {
        return DriverPool.INSTANCE.allocate();
    }
}
