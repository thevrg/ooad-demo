package com.epam.edu.proxy;

import com.epam.edu.bridge.impl.DataAccessObject;
import com.epam.edu.bridge.impl.Entity;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tmp
 */
public class LazyInitializerDAOProxy implements DataAccessObject {

    private final Class<? extends DataAccessObject> originalType;

    private volatile DataAccessObject original;

    /**
     *
     * @param originalType Must be a concrete class with a public parameterless
     * constructor
     * @throws IllegalArgumentException If originalType is an interface or does
     * not have a public, parameterless constructor.
     */
    public LazyInitializerDAOProxy(Class<? extends DataAccessObject> originalType) throws IllegalArgumentException {
        if ((originalType.getModifiers() & Modifier.ABSTRACT) != 0) {
            throw new IllegalArgumentException("Given type must be a concrete class.");
        }
        try {
            originalType.getConstructor(new Class[]{});
        } catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException(String.format(
                    "Given class (%s) does not have a public, parameterless constructor.", 
                    originalType.getName()));
        }
        System.out.println("DAOProxy created.");
        this.originalType = originalType;
    }

    @Override
    public <E extends Entity> E find(Class<E> type, Object id) {
        createIfDoesNotExist();
        return original.find(type, id);
    }

    private void createIfDoesNotExist() {
        if (original == null) {
            synchronized (this) {
                if (original == null) {
                    try {
                        System.out.println("Real subject created dynamically: " + originalType.getName());
                        original = originalType.newInstance();
                    } catch (InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(LazyInitializerDAOProxy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public <E extends Entity> E update(E entity) {
        createIfDoesNotExist();
        return original.update(entity);
    }

    @Override
    public boolean remove(Class<? extends Entity> type, Object id) {
        createIfDoesNotExist();
        return original.remove(type, id);
    }

    @Override
    public <E extends Entity> void persist(E entity) {
        createIfDoesNotExist();
        original.persist(entity);
    }

    @Override
    public <E extends Entity> boolean remove(E entity) {
        createIfDoesNotExist();
        return original.remove(entity);
    }

}
