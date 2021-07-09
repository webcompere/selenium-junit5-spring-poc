package uk.co.webcompere.seleniumjunit5.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import uk.co.webcompere.seleniumjunit5.config.Configuration;
import uk.co.webcompere.seleniumjunit5.config.ConfigurationLoader;

import java.util.Optional;

/**
 * Keeps web drivers in a pool for tests to use. They are safely reset in between uses.
 */
public class DriverPool {
    public static DriverPool INSTANCE = new DriverPool();
    private static final ThreadLocal<PretendWebDriver> PER_THREAD_INSTANCE = new ThreadLocal<>();

    private GenericObjectPool<PretendWebDriver> objectPool =
            new GenericObjectPool<>(new DriverObjectFactory<>(PretendWebDriver::new));

    // private constructor access via INSTANCE
    private DriverPool() {
        Configuration configuration = ConfigurationLoader.getConfiguration();
        objectPool.setMaxTotal(Optional.ofNullable(configuration.getPoolMax()).orElse(10));
        objectPool.setMaxIdle(Optional.ofNullable(configuration.getPoolMaxIdleTime()).orElse(2000));
    }

    /**
     * Clear all drivers from the pool - when the test finishes
     * @throws Exception on error
     */
    public void clear() throws Exception {
        objectPool.evict();
    }

    /**
     * Allocate a driver to a test that needs one
     * @return a driver from the pool
     * @throws Exception on error
     */
    public PretendWebDriver allocate() throws Exception {
        if (PER_THREAD_INSTANCE.get() == null) {
            PER_THREAD_INSTANCE.set(objectPool.borrowObject());
        }
        return PER_THREAD_INSTANCE.get();
    }

    /**
     * Get the current driver, without allocating one - can be empty
     * @return the driver or {@link Optional#empty()}
     */
    public Optional<PretendWebDriver> get() {
        return Optional.ofNullable(PER_THREAD_INSTANCE.get());
    }

    /**
     * Release a driver that's no longer needed
     */
    public void release() {
        if (PER_THREAD_INSTANCE.get() != null) {
            objectPool.returnObject(PER_THREAD_INSTANCE.get());
            PER_THREAD_INSTANCE.remove();
        }
    }
}
