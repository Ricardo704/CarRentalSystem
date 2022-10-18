package org.example.utils;
import org.example.model.Vehicle;
import org.junit.Test;
import java.util.ArrayList;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

/**
 * Test csv file reading function in InputReader class.
 */
public class InputReaderTest {

    @Test
    public void csvRead() {
        ArrayList<Vehicle> vehicles = InputReader.csvRead("C:\\Users\\lenovo\\Desktop\\Advanced_Programming\\Assignment 1\\Assignment1_s3933329\\src\\main\\resources\\Fleet.csv");
        assertNotNull(vehicles);
        assertEquals(vehicles.size(), 9);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleID("C001");
        vehicle.setBrand("Toyota");
        vehicle.setModel("Yaris");
        vehicle.setType("Sedan");
        vehicle.setManufactureYear(2012);
        vehicle.setSeat(4);
        vehicle.setColor("Blue");
        vehicle.setRentalPerDay(50);
        vehicle.setInsurancePerDay(15);
        vehicle.setServiceFee(10);
        vehicle.setDiscount(10);
        assertEquals(vehicles.get(0), vehicle);
    }
}