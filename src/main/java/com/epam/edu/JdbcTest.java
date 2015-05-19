package com.epam.edu;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;

/**
 *
 * @author tmp
 */
public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers) {
            System.out.println("diver: " + driver);
        }
        
        Connection conn = DriverManager.getConnection("jdbc:xderby://localhost:1527/sample", "app", "app");
        
        System.out.println("conn: " + conn);
    }
}
