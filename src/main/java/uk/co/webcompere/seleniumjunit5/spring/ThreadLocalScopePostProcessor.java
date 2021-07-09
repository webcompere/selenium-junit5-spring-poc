package uk.co.webcompere.seleniumjunit5.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import static uk.co.webcompere.seleniumjunit5.spring.ThreadLocalScope.THREADLOCAL_SCOPE;

public class ThreadLocalScopePostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        factory.registerScope(THREADLOCAL_SCOPE, new ThreadLocalScope());
    }
}
