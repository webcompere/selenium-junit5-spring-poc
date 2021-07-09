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

	@Inject
	private ExamplePageObject pageObjectConcept;

	@Inject
	private WebDriver pretendWebDriver;

	@Inject
	private LoginAction loginAction;

	@Inject
	private TestState state;

	@Test
	void test1() {
		assertThat(state.isLoggedIn()).isFalse();
		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
	}

	@Test
	void test2() {
		assertThat(state.isLoggedIn()).isFalse();
		System.out.println(Thread.currentThread().getName());
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());

	}

	@Test
	void loginTest() {
		assertThat(state.isLoggedIn()).isFalse();
//		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
//		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
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
