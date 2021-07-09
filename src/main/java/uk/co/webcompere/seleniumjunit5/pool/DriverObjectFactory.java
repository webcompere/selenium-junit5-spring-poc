package uk.co.webcompere.seleniumjunit5.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.io.Closeable;
import java.util.function.Supplier;

/**
 * Plugs into the {@link DriverPool}'s <code>GenericObjectPool</code> to build web drivers according
 * to the settings.
 * @param <T> the type of the driver, which must be closeable and resettable
 */
public class DriverObjectFactory<T extends Closeable & Resettable> extends BasePooledObjectFactory<T> {
    private Supplier<T> creator;

    public DriverObjectFactory(Supplier<T> creator) {
        this.creator = creator;
    }

    @Override
    public T create() {
        return creator.get();
    }

    @Override
    public void destroyObject(PooledObject<T> p) throws Exception {
        p.getObject().close();
    }

    @Override
    public void passivateObject(PooledObject<T> p) throws Exception {
        p.getObject().reset();
    }

    @Override
    public PooledObject<T> wrap(T obj) {
        return new DefaultPooledObject<>(obj);
    }
}
