package uk.co.yourorg.yourpackage;

import org.junit.jupiter.api.Test;
import uk.co.webcompere.seleniumjunit5.annotations.Inject;
import uk.co.yourorg.yourpackage.action.LoginAction;
import uk.co.yourorg.yourpackage.junit.SeleniumTest;
import uk.co.yourorg.yourpackage.page.ExamplePageObject;
import uk.co.webcompere.seleniumjunit5.pool.PretendWebDriver;
import uk.co.yourorg.yourpackage.state.TestState;

import static org.assertj.core.api.Assertions.assertThat;

@SeleniumTest
class SeleniumJunit5SprintPocApplicationTests {

	@Inject
	private ExamplePageObject pageObjectConcept;

	@Inject
	private PretendWebDriver pretendWebDriver;

	@Inject
	private LoginAction loginAction;

	@Inject
	private TestState state;

	@Test
	void test1() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
	}

	@Test
	void test2() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());

	}

	@Test
	void loginTest() {
		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
		loginAction.doAction();
	}

	@Test
	void loginTest2() {
		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
		loginAction.doAction();

		assertThat(state.isLoggedIn()).isTrue();
	}

	@Test
	void loginTest3() {
		System.out.println(Thread.currentThread().getName() + " Driver ID " + pretendWebDriver.getId());
		System.out.println(Thread.currentThread().getName() + " Page Driver ID " + pageObjectConcept.getFoo());
		loginAction.doAction();
	}
}
