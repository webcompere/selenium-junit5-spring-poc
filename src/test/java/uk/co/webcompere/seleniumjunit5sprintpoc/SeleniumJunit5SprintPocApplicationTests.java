package uk.co.webcompere.seleniumjunit5sprintpoc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import uk.co.webcompere.seleniumjunit5sprintpoc.annotations.InjectPageObject;
import uk.co.webcompere.seleniumjunit5sprintpoc.annotations.SeleniumTest;
import uk.co.webcompere.seleniumjunit5sprintpoc.page.PageObjectConcept;
import uk.co.webcompere.seleniumjunit5sprintpoc.pool.PretendWebDriver;

@SeleniumTest
@Execution(ExecutionMode.CONCURRENT)
class SeleniumJunit5SprintPocApplicationTests {
	@InjectPageObject
	private PretendWebDriver pretendWebDriver;

	@InjectPageObject
	private PageObjectConcept pageObjectConcept;

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
}
