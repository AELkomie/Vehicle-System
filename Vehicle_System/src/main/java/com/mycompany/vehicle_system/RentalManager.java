package com.mycompany.vehicle_system;

public class RentalManager {
    public static Vehicle[] vehicles = new Vehicle[100];
    public static Customer[] customers = new Customer[100];

    public static int vehicleCount = 0;
    public static int customerCount = 0;

    public static void addVehicle(Vehicle v) {
        vehicles[vehicleCount++] = v;
    }

    public static void addCustomer(Customer c) {
        customers[customerCount++] = c;
    }

    public static Vehicle searchVehicle(String id) {
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getVehicleID().equals(id)) return vehicles[i];
        }
        return null;
    }

    public static Customer searchCustomer(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getId().equals(id)) return customers[i];
        }
        return null;
    }

    public static void listVehicles() {
        for (int i = 0; i < vehicleCount; i++)
            System.out.println(vehicles[i]);
    }

    public static void listCustomers() {
        for (int i = 0; i < customerCount; i++)
            System.out.println(customers[i]);
    }
}
