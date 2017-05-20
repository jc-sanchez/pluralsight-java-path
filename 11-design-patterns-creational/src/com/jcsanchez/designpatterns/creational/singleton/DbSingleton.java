package com.jcsanchez.designpatterns.creational.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jsssn on 20-May-17.
 */
public class DbSingleton {

    private static DbSingleton instance = null;

    private Connection conn = null;

    private DbSingleton() {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized (DbSingleton.class) {
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }
        }

        return instance;
    }

    public Connection getConnection() {
        if (conn == null) {
            synchronized (DbSingleton.class) {
                if (conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejave/webdb;create=true";

                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return conn;
    }
}
