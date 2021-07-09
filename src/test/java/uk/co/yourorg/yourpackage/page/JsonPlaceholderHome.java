package uk.co.yourorg.yourpackage.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.co.webcompere.seleniumjunit5.annotations.PageObject;
import uk.co.webcompere.seleniumjunit5.pageobject.PageObjectBase;

@PageObject
public class JsonPlaceholderHome extends PageObjectBase {

    @FindBy(id="run-button")
    private WebElement runButton;

    @FindBy(id="result")
    private WebElement result;

    public void waitUntilLoaded() {
        new WebDriverWait(webDriver, 30).until(ExpectedConditions.visibilityOf(runButton));
    }

    public void navigateTo() {
        webDriver.navigate().to(getBaseUrl());
        waitUntilLoaded();
    }

    public void runScript() {
        runButton.click();
    }

    public String getResultText() {
        return result.getText();
    }

}
