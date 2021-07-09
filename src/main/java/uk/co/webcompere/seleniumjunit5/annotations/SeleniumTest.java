package uk.co.webcompere.seleniumjunit5.annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.boot.test.context.SpringBootTest;
import uk.co.webcompere.seleniumjunit5.junit.ReleaseResourcesExtension;
import uk.co.webcompere.seleniumjunit5.spring.SeleniumConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotate a test class with this to turn on the selenium test framework
 * configuration
 */
@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = SeleniumConfiguration.class)
@ExtendWith(ReleaseResourcesExtension.class)
@Execution(ExecutionMode.CONCURRENT)
public @interface SeleniumTest {
}
