package com.epam.edu.command;

import java.sql.Connection;

import javax.sql.DataSource;

/**
 *
 * @author tmp
 */
public interface ExecutionContext {
    public void log(String message);
    public Object getSystemState();
    public void restoreSystemState(Object state);
    public void deleteEntity(Class entityType, Long id);
    public DataSource getDataSource();
    public Connection getConnection();
}
