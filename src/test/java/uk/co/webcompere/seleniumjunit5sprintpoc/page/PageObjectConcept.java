package uk.co.webcompere.seleniumjunit5sprintpoc.page;

import uk.co.webcompere.seleniumjunit5sprintpoc.annotations.PageObject;
import uk.co.webcompere.seleniumjunit5sprintpoc.pool.PretendWebDriver;

@PageObject
public class PageObjectConcept {
    private PretendWebDriver pretendWebDriver;

    public PageObjectConcept(PretendWebDriver pretendWebDriver) {
        this.pretendWebDriver = pretendWebDriver;
    }

    public String getFoo() {
        return pretendWebDriver.getId();
    }
}
