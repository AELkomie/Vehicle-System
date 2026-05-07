package com.mycompany.vehicle_system;

public interface Rentable {
    
    double rent(int days, Customer c);
    void returnVehicle();
}

