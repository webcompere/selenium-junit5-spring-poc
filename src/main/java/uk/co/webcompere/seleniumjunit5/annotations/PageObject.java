package uk.co.webcompere.seleniumjunit5.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

import static uk.co.webcompere.seleniumjunit5.spring.TestCaseScope.TESTCASE_SCOPE;

/**
 * Used to describe an injectable page object - this should be used to ensure
 * it has the right scope within the test - once per test class instance, rather than
 * a singleton bean
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Component
@Scope(TESTCASE_SCOPE)
public @interface PageObject {
}
