package org.example.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.model.Vehicle;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * InputReader class includes the method to read the csv file and put data into the ArrayList.
 *
 * CSV reading method used in this class was learnt from an online blog.
 * Available at: https://www.onlinetutorialspoint.com/java/java-how-to-read-csv-file-and-map-to-java-object.html
 *
 */
public class InputReader {
    public static ArrayList<Vehicle> csvRead(String filepath){
        try {
            CSVReader reader =
                    new CSVReaderBuilder(new FileReader(filepath)).withSkipLines(1).build();
            List<Vehicle> vehicleList = reader.readAll().stream().map(data -> {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleID(data[0]);
                vehicle.setBrand(data[1]);
                vehicle.setModel(data[2]);
                vehicle.setType(data[3]);
                vehicle.setManufactureYear(Integer.parseInt(data[4]));
                vehicle.setSeat(Integer.parseInt(data[5]));
                vehicle.setColor(data[6]);
                vehicle.setRentalPerDay(Integer.parseInt(data[7]));
                vehicle.setInsurancePerDay(Integer.parseInt(data[8]));
                vehicle.setServiceFee(Integer.parseInt(data[9]));
                try {
                    vehicle.setDiscount(Double.parseDouble(data[10]));
                } catch (NumberFormatException e) {
                    vehicle.setDiscount(0);
                }
                return vehicle;
            }).toList();
            return new ArrayList<>(vehicleList);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
