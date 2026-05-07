package com.mycompany.vehicle_system;

public class Bike extends Vehicle {
    public Bike(String id, String model, double price) {
        super(id, model, price);
    }

    @Override
    public double calculatePrice(int days) {
        return getBasePrice() * days * 0.5;
    }
}

