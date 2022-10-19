package org.example;
import org.example.controller.Controller;
import org.example.model.Vehicle;
import org.example.utils.InputReader;
import org.example.utils.InputUtil;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author - Ruoqian Zhang s3933329
 * Date - 26/08/2022
 *
 * Online Booking System for Vehicle Rentals - Demonstrating OOP in Java Programming language
 * For Assignment1 of COSC1295 - Advanced Programming
 */


/**
 * The Main class is the entry point of this system.
 */
public class Main {

    public static void welcomeMenu() {
        System.out.println("\nWelcome to MyCar!");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("> Select from main menu");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void mainMenu() {
        System.out.println("  1) Search by brand");
        System.out.println("  2) Browse by vehicle type");
        System.out.println("  3) Filter by number of passengers");
        System.out.println("  4) Exit");
    }

    /**
     * The method to operate the main menu.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Controller controller = new Controller(in);
        ArrayList<Vehicle> vehicles = InputReader.csvRead("C:\\Users\\lenovo\\Desktop\\Advanced_Programming\\Assignment 1\\Assignment1_s3933329\\src\\main\\resources\\Fleet.csv");
        controller.setVehicles(vehicles);
        welcomeMenu();
        int input;
        do {
            mainMenu();
            input = InputUtil.getInteger("Please select: ", in);
            switch (input) {
                case 1:
                    controller.searchByBrand();
                    break;
                case 2:
                    controller.browseByType();
                    break;
                case 3:
                    controller.filterByPassenger();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Thank you for using MyCar Rental System!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Option... Please select a valid operation from the menu!");
                    System.out.println();
            }
        } while(input != 4);
    }

}
