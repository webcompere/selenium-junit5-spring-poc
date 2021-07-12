package uk.co.webcompere.seleniumjunit5.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Reimplements {@link SimpleThreadScope} with hooks for destruction per test. This allows beans to be
 * isolated on a per-test basis. It's the equivalent of request scope.
 */
public class TestCaseScope implements Scope {
    public static final String TESTCASE_SCOPE = "testCaseScope";

    private static final Log LOGGER = LogFactory.getLog(TestCaseScope.class);

    private static final ThreadLocal<Map<String, Object>> SCOPES =
            new NamedThreadLocal<>("TestCaseScope") {
                @Override
                protected Map<String, Object> initialValue() {
                    return new HashMap<>();
                }
            };


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> scope = SCOPES.get();
        // NOTE: Do NOT modify the following to use Map::computeIfAbsent. For details,
        // see https://github.com/spring-projects/spring-framework/issues/25801.
        Object scopedObject = scope.get(name);
        if (scopedObject == null) {
            scopedObject = objectFactory.getObject();
            scope.put(name, scopedObject);
        }
        return scopedObject;
    }

    @Override
    @Nullable
    public Object remove(String name) {
        Map<String, Object> scope = this.SCOPES.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        LOGGER.warn("SimpleThreadScope does not support destruction callbacks. " +
                "Consider using RequestScope in a web environment.");
    }

    @Override
    @Nullable
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }

    /**
     * Release the scoped beans of the current thread
     */
    public static void releaseThisThreadsBeans() {
        SCOPES.remove();
    }
}
