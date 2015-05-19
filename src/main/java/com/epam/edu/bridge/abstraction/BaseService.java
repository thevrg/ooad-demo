/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.edu.bridge.abstraction;

import com.epam.edu.bridge.impl.DataAccessObject;
import com.epam.edu.bridge.impl.Entity;

/**
 *
 * @author tmp
 */
public abstract class BaseService<E extends Entity> {
    protected final DataAccessObject dao;

    public BaseService(DataAccessObject dao) {
        this.dao = dao;
    }
    
    public void persist(E entity) {
        dao.persist(entity);
    }
    
    public void update(E entity) {
        dao.update(entity);
    }
    public void remove(E entity) {
        dao.update(entity);
    }
}
