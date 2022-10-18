package org.example.utils;
import org.example.model.User;
import org.example.model.Vehicle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * VehicleUtil class provides methods to search vehicles by different elements and return vehicle info.
 */
public class VehicleUtil {

    /**
     * The functional method to search vehicles by brand.
     */
    public static List<Vehicle> searchByBrand(String brand, List<Vehicle> vehicles) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getBrand().equals(brand)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * The method to search vehicle by type.
     */
    public static List<Vehicle> searchByType(String type, List<Vehicle> vehicles) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * The method to search vehicle by passenger number.
     */
    public static List<Vehicle> searchByPassengers(int seatNum, List<Vehicle> vehicles) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getSeat() >= seatNum) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * The method to search vehicle by vehicle ID.
     */
    public static Vehicle searchByID(String vehicleID, List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleID().equals(vehicleID)) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * The method to display information of the vehicle chosen by user.
     */
    public static String getVehicleInfo(int rentDay, Vehicle vehicle) {
        StringBuilder builder = new StringBuilder();
        builder.append("===============Vehicle Information===============\nID: ").append(vehicle.getVehicleID())
                .append("\nBrand: ").append(vehicle.getBrand())
                .append("\nModel: ").append(vehicle.getModel())
                .append("\nType: ").append(vehicle.getType())
                .append("\nManufacture year: ").append(vehicle.getManufactureYear())
                .append("\nNo. of seats: ").append(vehicle.getSeat())
                .append("\nColor: ").append(vehicle.getColor())
                .append("\nTotal rental price (without discount): ").append(vehicle.getRentalPerDay() * rentDay)
                .append("\nTotal rental price (with discount): ")
                .append((vehicle.getRentalPerDay() * (100 - getDiscount(vehicle, rentDay)) / 100) * rentDay)
                .append("\nTotal insurance: ").append(vehicle.getInsurancePerDay() * rentDay)
                .append("\nTotal service fee: ").append(vehicle.getServiceFee())
                .append("\nTotal payment: ").append(calculateTotalFee(vehicle, rentDay));
        return builder.toString();
    }

    /**
     * The method to determine if rent days are more than 7 days.
     */
    private static double getDiscount(Vehicle vehicle, int rentDays) {
        return rentDays < 7 ? 0 : vehicle.getDiscount();
    }

    /**
     * The method to calculate total fee of order.
     */
    public static double calculateTotalFee(Vehicle vehicle, int rentDays) {
        double discount = 0;
        double totalFee = 0;
        if (rentDays >= 7) {
            discount = vehicle.getDiscount();
        }
        totalFee = totalFee + (vehicle.getRentalPerDay() * (100 - discount) / 100 + vehicle.getInsurancePerDay())
                * rentDays;
        totalFee += vehicle.getServiceFee();
        return totalFee;
    }

    /**
     * The method to display order information.
     */
    public static void printDetails(User user, Vehicle vehicle, Date[] dates) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("> Congratulations! Your vehicle is booked. A receipt has been sent to your email.\n  We will soon be in touch " +
                "before your pick-up date.");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("===============Order Information===============" + user);
        System.out.println("Vehicle information: " + vehicle);
        System.out.println("Number of passengers: " + user.getPassengerNum());
        System.out.println("Pick-up date: " + simpleDateFormat.format(dates[0]));
        System.out.println("Return date: "+ simpleDateFormat.format(dates[1]));
        System.out.println("Total payment: " + calculateTotalFee(vehicle, InputUtil.getRentDay(dates)));
        System.out.println();
    }

}
