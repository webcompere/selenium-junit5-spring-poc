package uk.co.webcompere.seleniumjunit5sprintpoc.annotations;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import uk.co.webcompere.seleniumjunit5sprintpoc.junit.ReleaseDriversExtension;
import uk.co.webcompere.seleniumjunit5sprintpoc.spring.SeleniumConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = SeleniumConfiguration.class)
@ExtendWith(ReleaseDriversExtension.class)
public @interface SeleniumTest {
}
