package com.mycompany.vehicle_system;

public class Car extends Vehicle {
    private int seats;

    public Car(String id, String model, double price, int seats) {
        super(id, model, price);
        this.seats = seats;
    }

    @Override
    public double calculatePrice(int days) {
        return getBasePrice() * days;
    }

    @Override
    public String toString() {
        return super.toString() + " | Seats: " + seats;
    }
}

