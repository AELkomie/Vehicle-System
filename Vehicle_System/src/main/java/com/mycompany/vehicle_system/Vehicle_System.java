package com.mycompany.vehicle_system;

import java.util.Scanner;

public class Vehicle_System {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("=========== Vehicle Rental System ===========");
            System.out.println("1. Add new Car");
            System.out.println("2. Add new Bike");
            System.out.println("3. Add new Bus");
            System.out.println("4. Add new Customer");
            System.out.println("5. List all vehicles");
            System.out.println("6. List all customers");
            System.out.println("7. Rent a vehicle");
            System.out.println("8. Return a vehicle");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            int choice = in.nextInt();
            in.nextLine();

            if (choice == 0) {
                System.out.println("Exiting system... Goodbye!");
                break;
            }

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter Car ID: ");
                    String cid = in.nextLine();
                    System.out.print("Enter Model: ");
                    String cmod = in.nextLine();
                    System.out.print("Enter Base Price per Day: ");
                    double cp = in.nextDouble();
                    System.out.print("Enter Number of Seats: ");
                    int seats = in.nextInt();
                    RentalManager.addVehicle(new Car(cid, cmod, cp, seats));
                    System.out.println("Car added successfully!");
                }

                case 2 -> {
                    System.out.print("Enter Bike ID: ");
                    String bid = in.nextLine();
                    System.out.print("Enter Model: ");
                    String bmod = in.nextLine();
                    System.out.print("Enter Base Price per Day: ");
                    double bp = in.nextDouble();
                    RentalManager.addVehicle(new Bike(bid, bmod, bp));
                    System.out.println("Bike added successfully!");
                }

                case 3 -> {
                    System.out.print("Enter Bus ID: ");
                    String busid = in.nextLine();
                    System.out.print("Enter Model: ");
                    String busmod = in.nextLine();
                    System.out.print("Enter Base Price per Day: ");
                    double busp = in.nextDouble();
                    System.out.print("Enter Capacity: ");
                    int cap = in.nextInt();
                    RentalManager.addVehicle(new Bus(busid, busmod, busp, cap));
                    System.out.println("Bus added successfully!");
                }

                case 4 -> {
                    System.out.print("Enter Customer ID: ");
                    String cid2 = in.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String cname = in.nextLine();
                    System.out.print("Enter Customer Phone: ");
                    String phone = in.nextLine();
                    RentalManager.addCustomer(new Customer(cid2, cname, phone));
                    System.out.println("Customer added successfully!");
                }

                case 5 -> {
                    System.out.println("--- Vehicle List ---");
                    RentalManager.listVehicles();
                }

                case 6 -> {
                    System.out.println("--- Customer List ---");
                    RentalManager.listCustomers();
                }

                case 7 -> {
                    System.out.print("Enter Vehicle ID to rent: ");
                    String rid = in.nextLine();

                    Vehicle v = RentalManager.searchVehicle(rid);
                    if (v == null) { System.out.println("Vehicle not found!"); break; }

                    if (v.isRented()) {
                        System.out.println("Error: Vehicle " + rid +
                                " is already rented by customer " +
                                v.getRentedBy().getId());
                        break;
                    }

                    System.out.print("Enter Customer ID: ");
                    String rcid = in.nextLine();
                    Customer cus = RentalManager.searchCustomer(rcid);
                    if (cus == null) { System.out.println("Customer not found!"); break; }

                    System.out.print("Enter number of days: ");
                    int days = in.nextInt();

                    double price = v.rent(days, cus);
                    System.out.println("Vehicle " + rid + " rented successfully to " + cus.getName());
                    System.out.println("Total Price = " + price);
                }

                case 8 -> {
                    System.out.print("Enter Vehicle ID to return: ");
                    String retid = in.nextLine();

                    Vehicle rv = RentalManager.searchVehicle(retid);
                    if (rv == null) { System.out.println("Vehicle not found!"); break; }

                    rv.returnVehicle();
                    System.out.println("Vehicle " + retid + " returned successfully.");
                }
            }

            System.out.println("---------------------------------------------");
        }

        in.close();
    }
}