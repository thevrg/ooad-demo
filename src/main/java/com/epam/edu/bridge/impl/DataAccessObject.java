package com.epam.edu.bridge.impl;

import javax.transaction.Transactional;

/**
 *
 * @author tmp
 */
public interface DataAccessObject {
    @Transactional
    public <E extends Entity >void persist(E entity);
    public <E extends Entity> E find(Class<E>type, Object id);
    public <E extends Entity> E update(E entity);
    public boolean remove(Class<? extends Entity>type, Object id);
    public <E extends Entity> boolean remove(E entity);
}
