package uk.co.yourorg.yourpackage.page;

import uk.co.webcompere.seleniumjunit5.annotations.PageObject;
import uk.co.webcompere.seleniumjunit5.pageobject.PageObjectBase;

@PageObject
public class ExamplePageObject extends PageObjectBase {

    public String getFoo() {
        return Integer.toString(webDriver.hashCode());
    }
}
