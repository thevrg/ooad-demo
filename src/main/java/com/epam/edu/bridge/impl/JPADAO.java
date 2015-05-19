package com.epam.edu.bridge.impl;

import javax.persistence.EntityManager;

/**
 *
 * @author tmp
 */
public class JPADAO implements DataAccessObject {

    private EntityManager em;

    public JPADAO(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public <E extends Entity> void persist(E entity) {
        em.persist(entity);
    }

    @Override
    public <E extends Entity> E find(Class<E> type, Object id) {
        return em.find(type, id);
    }

    @Override
    public <E extends Entity> E update(E entity) {
        return em.merge(entity);
    }

    @Override
    public boolean remove(Class<? extends Entity> type, Object id) {
        if (type == null) {
            throw new IllegalArgumentException("type must not be null");
        }
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        Object entity = em.getReference(type, id);
        if (entity != null) {
            em.remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public <E extends Entity> boolean remove(E entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }
        return remove(entity.getClass(), entity);
    }
    
}
