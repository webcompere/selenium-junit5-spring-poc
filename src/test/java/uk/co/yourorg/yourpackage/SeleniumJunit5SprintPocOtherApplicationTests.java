package uk.co.yourorg.yourpackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import uk.co.webcompere.seleniumjunit5.annotations.Inject;
import uk.co.yourorg.yourpackage.junit.SeleniumTest;
import uk.co.yourorg.yourpackage.page.ExamplePageObject;

import static org.junit.jupiter.api.Assertions.fail;

@SeleniumTest
class SeleniumJunit5SprintPocOtherApplicationTests {

	@Inject
	private WebDriver webDriver;

	@Inject
	private ExamplePageObject pageObjectConcept;

	@Test
	void test1() {
		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
		fail();
	}

	@Test
	void test2() {
		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());

	}
}
