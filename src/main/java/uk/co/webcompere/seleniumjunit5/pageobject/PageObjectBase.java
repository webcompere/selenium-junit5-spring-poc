package uk.co.webcompere.seleniumjunit5.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class PageObjectBase {

    @Autowired
    protected WebDriver webDriver;

    @PostConstruct
    public void postConstruct() {
        // init the page object members
        PageFactory.initElements(webDriver, this);
    }
}
