package com.mycompany.vehicle_system;

public abstract class Vehicle implements Rentable {
    private final String vehicleID;
    private final String modelName;
    private final double basePrice;
    private boolean rented = false;
    private Customer rentedBy = null;

    public Vehicle(String id, String model, double price) {
        this.vehicleID = id;
        this.modelName = model;
        this.basePrice = price;
    }

    public String getVehicleID() { return vehicleID; }
    public String getModelName() { return modelName; }
    public double getBasePrice() { return basePrice; }
    public boolean isRented() { return rented; }
    public Customer getRentedBy() { return rentedBy; }

    public void setRented(boolean r) { rented = r; }
    public void setRentedBy(Customer c) { rentedBy = c; }

    public abstract double calculatePrice(int days);

    @Override
    public double rent(int days, Customer c) {
        if (rented) return -1;

        rented = true;
        rentedBy = c;

        return calculatePrice(days);
    }

    @Override
    public void returnVehicle() {
        rented = false;
        rentedBy = null;
    }

    @Override
    public String toString() {
        return "ID: " + vehicleID +
               " | Model: " + modelName +
               " | Price/Day: " + basePrice +
               " | Rented: " + rented;
    }

}
