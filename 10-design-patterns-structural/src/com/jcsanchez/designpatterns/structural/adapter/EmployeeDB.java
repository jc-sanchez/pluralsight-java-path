package com.jcsanchez.designpatterns.structural.adapter;

/**
 * Created by jsssn on 18-May-17.
 */
public class EmployeeDB implements Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeeDB(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "{" +
                "ID: " + id +
                ", First name: " + firstName +
                ", Last name: " + lastName +
                ", Email: " + email +
                '}';
    }
}
