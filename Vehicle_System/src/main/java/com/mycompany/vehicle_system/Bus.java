package com.mycompany.vehicle_system;


public class Bus extends Vehicle {
    private int capacity;

    public Bus(String id, String model, double price, int cap) {
        super(id, model, price);
        this.capacity = cap;
    }

    @Override
    public double calculatePrice(int days) {
        return getBasePrice() * days * 1.5;
    }

    @Override
    public String toString() {
        return super.toString() + " | Capacity: " + capacity;
    }
}

