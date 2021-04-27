package uk.co.webcompere.seleniumjunit5sprintpoc.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class DriverPool {
    public static DriverPool INSTANCE = new DriverPool();
    private static final ThreadLocal<PretendWebDriver> PER_THREAD_INSTANCE = new ThreadLocal<>();

    private GenericObjectPool<PretendWebDriver> objectPool = new GenericObjectPool<>(new DriverObjectFactory<>(PretendWebDriver::new));

    private DriverPool() {
        objectPool.setMaxTotal(10);
        objectPool.setMaxIdle(2000);
    }

    public void clear() throws Exception {
        objectPool.evict();
    }

    public PretendWebDriver allocate() throws Exception {
        if (PER_THREAD_INSTANCE.get() == null) {
            PER_THREAD_INSTANCE.set(objectPool.borrowObject());
        }
        return PER_THREAD_INSTANCE.get();
    }

    public void release() {
        if (PER_THREAD_INSTANCE.get() != null) {
            objectPool.returnObject(PER_THREAD_INSTANCE.get());
            PER_THREAD_INSTANCE.set(null);
        }
    }
}
