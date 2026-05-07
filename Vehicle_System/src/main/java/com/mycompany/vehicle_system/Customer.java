package com.mycompany.vehicle_system;

public class Customer {
    private String id;
    private String name;
    private String phone;

    public Customer(String id, String n, String p) {
        this.id = id;
        this.name = n;
        this.phone = p;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Phone: " + phone;
    }
}

