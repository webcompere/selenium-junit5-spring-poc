package uk.co.yourorg.yourpackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import uk.co.webcompere.seleniumjunit5.annotations.Inject;
import uk.co.yourorg.yourpackage.junit.SeleniumTest;
import uk.co.yourorg.yourpackage.page.ExamplePageObject;

import static org.junit.jupiter.api.Assertions.fail;

@SeleniumTest
class SeleniumJunit5SprintPocOtherApplicationTests {

	// can inject a web driver if you need
	@Inject
	private WebDriver webDriver;

	// can inject a web driver
	@Inject
	private ExamplePageObject pageObjectConcept;

	@Test
	void test1() {
		// this failure will make a screen shot happen
		fail();
	}

	@Test
	void test2() {
	}
}
