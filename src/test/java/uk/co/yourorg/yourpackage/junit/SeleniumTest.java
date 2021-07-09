package uk.co.yourorg.yourpackage.junit;

import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@uk.co.webcompere.seleniumjunit5.annotations.SeleniumTest
@ContextConfiguration(classes = Config.class)
public @interface SeleniumTest {
}
