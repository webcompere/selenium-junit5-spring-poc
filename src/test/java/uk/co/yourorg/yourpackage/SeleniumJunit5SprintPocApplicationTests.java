package uk.co.yourorg.yourpackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import uk.co.webcompere.seleniumjunit5.annotations.Inject;
import uk.co.yourorg.yourpackage.action.LoginAction;
import uk.co.yourorg.yourpackage.junit.SeleniumTest;
import uk.co.yourorg.yourpackage.page.ExamplePageObject;
import uk.co.yourorg.yourpackage.state.TestState;

import static org.assertj.core.api.Assertions.assertThat;

@SeleniumTest
class SeleniumJunit5SprintPocApplicationTests {

	// Can inject a page object
	@Inject
	private ExamplePageObject pageObjectConcept;

	// Can inject the web driver
	@Inject
	private WebDriver pretendWebDriver;

	// Inject an action class
	@Inject
	private LoginAction loginAction;

	// Inject the test state
	@Inject
	private TestState state;

	@Test
	void test1() {
		assertThat(state.isLoggedIn()).isFalse();
		System.out.println(Thread.currentThread().getName());
	}

	@Test
	void test2() {
		assertThat(state.isLoggedIn()).isFalse();

	}

	@Test
	void loginTest() {
		assertThat(state.isLoggedIn()).isFalse();
		loginAction.doAction();
	}

	@Test
	void loginTest2() {
		assertThat(state.isLoggedIn()).isFalse();
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
		loginAction.doAction();

		assertThat(state.isLoggedIn()).isTrue();
	}

	@Test
	void loginTest22() {
		assertThat(state.isLoggedIn()).isFalse();
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
		loginAction.doAction();

		assertThat(state.isLoggedIn()).isTrue();
	}

	@Test
	void loginTest3() {
		assertThat(state.isLoggedIn()).isFalse();
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
		loginAction.doAction();
	}
}
