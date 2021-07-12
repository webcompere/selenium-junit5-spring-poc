package uk.co.webcompere.seleniumjunit5.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import static uk.co.webcompere.seleniumjunit5.spring.TestCaseScope.TESTCASE_SCOPE;

/**
 * Wires the custom scope into Spring
 */
public class TestCaseScopePostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        factory.registerScope(TESTCASE_SCOPE, new TestCaseScope());
    }
}
