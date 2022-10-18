package org.example.controller;

import org.example.model.User;
import org.example.model.Vehicle;
import org.example.utils.InputUtil;
import org.example.utils.VehicleUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Controller class provides part of menu operations and calls methods to search vehicles.
 */
public class Controller {

    private List<Vehicle> vehicles;
    private List<Vehicle> availableVehicles;
    private Scanner scanner;
    private User user;
    private Date[] dates;

    // Controller's constructor
    public Controller(Scanner scanner) {
        vehicles = new ArrayList<>();
        availableVehicles = new ArrayList<Vehicle>();
        this.scanner = scanner;
        this.user = new User();
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * The method to print all available vehicles in selection menu.
     */
    private void printAvailableVehicle() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("> Select from matching list");
        System.out.println("--------------------------------------------------------------------------------");
        for (Vehicle availableVehicle : availableVehicles) {
            System.out.println(availableVehicle);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    /**
     * The method to operate searchByBrand method.
     */
    public void searchByBrand() {
        String brand;
        System.out.print("> Please input the brand: ");
        brand = scanner.nextLine();
        availableVehicles = VehicleUtil.searchByBrand(brand, vehicles);
        if (availableVehicles.size() == 0) {
            System.out.println();
            System.out.println("Sorry there is no car available with brand: " + brand);
        } else {
            selectVehicle();
        }
    }

    /**
     * The method to operate searchByPassengers method.
     */
    public void filterByPassenger() {
        int seat;
        int count = 0;
        seat = InputUtil.getInteger("> Please input the number of passengers: ", scanner);
        availableVehicles = VehicleUtil.searchByPassengers(seat, vehicles);
        if (availableVehicles.size() == 0) {
            System.out.println();
            System.out.println("Sorry there is no suitable vehicle for " + seat + " passengers.");
            return;
        }
        selectVehicle();
    }

    /**
     * Browse menu
     */
    private void browseMenu() {
        System.out.println("  1) Sedan");
        System.out.println("  2) Hatch");
        System.out.println("  3) SUV");
        System.out.println("  4) Back to main menu");
    }

    /**
     * The method to operate searchByType method.
     */
    public void browseByType() {
        boolean exitToMenu = false;
        int input;
        String type = null;
        do {
            browseMenu();
            input = InputUtil.getInteger("> Please select: ", scanner);
            switch (input) {
                case 1:
                    type = "Sedan";
                    break;
                case 2:
                    type = "Hatch";
                    break;
                case 3:
                    type = "SUV";
                    break;
                case 4:
                    exitToMenu = true;
                    break;
                default:
                    System.out.println("> Please select a valid menu option.");
                    break;
            }
        } while (type == null && !exitToMenu);
        if (exitToMenu) {
            return;
        }
        availableVehicles = VehicleUtil.searchByType(type, vehicles);
        if (availableVehicles.size() == 0) {
            System.out.println();
            System.out.println("Sorry there is no suitable vehicle for type: " + type);
            return;
        }
        selectVehicle();
    }

    /**
     * The method to let user select one of available vehicles, then input pick-up and return dates.
     */
    public void selectVehicle() {
        // select vehicle
        Vehicle vehicle = null;
        while (vehicle == null) {
            printAvailableVehicle();
            String vehicleID = InputUtil.getString("> Please input Vehicle ID (q to quit): ", scanner);
            if (vehicleID.equals("q")) {
                return;
            }
            vehicle = VehicleUtil.searchByID(vehicleID, availableVehicles);
            if (vehicle == null) {
                System.out.println();
                System.out.println("Invalid option!");
            }
        }

        // get rent days
        dates = InputUtil.getRentDay("> Please provide pick-up and return dates " +
                "(separated by space, date format is dd/mm/yyyy): ", scanner);

        // print information
        int rentDay = InputUtil.getRentDay(dates);
        System.out.println(VehicleUtil.getVehicleInfo(rentDay, vehicle));

        // choose whether to reserve
        reserve(vehicle);
    }

    /**
     * The method to get user's information and make order.
     */
    private void reserve(Vehicle vehicle) {
        boolean confirm = InputUtil.confirm("> Would you like to reserve the vehicle? (Y or N): ", scanner);
        if (!confirm) {
            return;
        }
        String name = InputUtil.getString("> Please provide your firstname: ", scanner);
        String surname = InputUtil.getString("> Please provide your surname: ", scanner);
        String emailAddress = null;
        int passengerNum = 0;
        while (true) {
            emailAddress = InputUtil.getString("> Please provide your email address: ", scanner);
            if (InputUtil.checkEmail(emailAddress)) {
                break;
            }
            System.out.println();
            System.out.println("Invalid format for email!");
        }

        while (true) {
            passengerNum = InputUtil.getInteger("> Please input number of passengers: ", scanner);
            if (passengerNum <= vehicle.getSeat()) {
                break;
            }
            System.out.println("Your passenger number should be lower or equal than the seats of vehicle!");
        }

        user.setName(name);
        user.setSurname(surname);
        user.setEmailAddress(emailAddress);
        user.setPassengerNum(passengerNum);

        // Confirm and pay
        confirm = InputUtil.confirm("> Confirm and pay? (Y or N): ", scanner);
        if (!confirm) {
            return;
        }
        // Print details
        VehicleUtil.printDetails(user, vehicle, dates);

    }
}