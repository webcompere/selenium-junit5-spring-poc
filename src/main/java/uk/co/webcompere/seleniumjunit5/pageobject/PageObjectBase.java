package uk.co.webcompere.seleniumjunit5.pageobject;

import org.springframework.beans.factory.annotation.Autowired;
import uk.co.webcompere.seleniumjunit5.pool.PretendWebDriver;

import javax.annotation.PostConstruct;

public abstract class PageObjectBase {

    @Autowired
    protected PretendWebDriver pretendWebDriver;

    @PostConstruct
    public void postConstruct() {
        // init the page object members
    }
}
