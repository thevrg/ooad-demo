package com.epam.edu;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author tmp
 */
public class MyDriver implements Driver {

    public MyDriver() {
        System.out.println("MyDriver constructed...");
    }

    public Connection connect(String url, Properties info) throws SQLException {
        System.out.println("connect");
        return null;
    }

    public boolean acceptsURL(String url) throws SQLException {
        System.out.println("acceptsURL called: " + url);
        return false;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        System.out.println("getPropertyInfo");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMajorVersion() {
        System.out.println("getMajor");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMinorVersion() {
        System.out.println("getMinor");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean jdbcCompliant() {
        return true;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        System.out.println("getParentLogger");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
