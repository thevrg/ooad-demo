package com.epam.edu.bridge.impl;

import com.epam.edu.bridge.impl.DataAccessObject;
import java.sql.Connection;

/**
 *
 * @author tmp
 */
public class JdbcDAO implements DataAccessObject {

    private Connection conn;

    @Override
    public <E extends Entity> void persist(E entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <E extends Entity> E find(Class<E> type, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <E extends Entity> E update(E entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Class<? extends Entity> type, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <E extends Entity> boolean remove(E entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
