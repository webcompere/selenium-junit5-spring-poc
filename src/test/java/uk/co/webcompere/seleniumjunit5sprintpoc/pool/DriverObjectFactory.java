package uk.co.webcompere.seleniumjunit5sprintpoc.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.io.Closeable;
import java.util.function.Supplier;

public class DriverObjectFactory<T extends Closeable> extends BasePooledObjectFactory<T> {
    private Supplier<T> creator;

    public DriverObjectFactory(Supplier<T> creator) {
        this.creator = creator;
    }

    @Override
    public T create() throws Exception {
        return creator.get();
    }

    @Override
    public void destroyObject(PooledObject<T> p) throws Exception {
        p.getObject().close();
    }

    @Override
    public PooledObject<T> wrap(T obj) {
        return new DefaultPooledObject<>(obj);
    }
}
