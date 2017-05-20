package com.jcsanchez.designpatterns.structural.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jsssn on 19-May-17.
 */
public class JdbcFaceade {

    private DbSingleton instance = null;

    public JdbcFaceade() {
        instance = DbSingleton.getInstance();
    }

    public int createTable() {
        int count = 0;
        try {
            Connection conn = instance.getConnection();
            Statement stmnt = conn.createStatement();
            count = stmnt.executeUpdate("CREATE TABLE Address (ID INTEGER, StreetName " + "VARCHAR(20), City VARCHAR(20))");
            stmnt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int insertIntoTable() {
        int count = 0;
        try {
            Connection conn = instance.getConnection();
            Statement stmnt = conn.createStatement();
            count = stmnt.executeUpdate("INSERT INTO Address (ID, StreetName, City) " + "values (1, '1234 Some street', 'Layton')");
            stmnt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Address> getAddresses() {
        List<Address> addresses = new ArrayList<>();
        try {
            Connection conn = instance.getConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Address");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                Address address = new Address();
                address.setId(rs.getString(1));
                address.setStreetName(rs.getString(2));
                address.setCity(rs.getString(3));

                addresses.add(address);
            }

            rs.close();
            stmnt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses;
    }
}

class Address {
    private String id;
    private String streetName;
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}