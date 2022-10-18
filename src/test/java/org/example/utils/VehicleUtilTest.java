package org.example.utils;
import org.example.model.User;
import org.example.model.Vehicle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test methods in VehicleUtil class.
 */
public class VehicleUtilTest {

    List<Vehicle> vehicles;
    Vehicle vehicle;
    User user;

    @Before
    public void setVehicle() {
        vehicle = new Vehicle();
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
    }

    @Before
    public void setVehicles() {
        vehicles = InputReader.csvRead("C:\\Users\\lenovo\\Desktop\\Advanced_Programming\\Assignment 1\\Assignment1_s3933329\\src\\main\\resources\\Fleet.csv");
    }

    @Before
    public void setUser() {
        user = new User();
        user.setName("test");
        user.setSurname("test");
        user.setEmailAddress("cardo@123456.com");
        user.setPassengerNum(5);
    }

    @Test
    public void searchByBrand() {
        assertEquals(VehicleUtil.searchByBrand("Toyota", vehicles).size(), 3);
        assertEquals(VehicleUtil.searchByBrand("", vehicles).size(), 0);
    }

    @Test
    public void searchByType() {
        assertEquals(VehicleUtil.searchByType("Sedan", vehicles).size(), 4);
        assertEquals(VehicleUtil.searchByType("", vehicles).size(), 0);
    }

    @Test
    public void searchByPassengers() {
        assertEquals(VehicleUtil.searchByPassengers(4, vehicles).size(), 9);
        assertEquals(VehicleUtil.searchByPassengers(-1, vehicles).size(), 9);

    }

    @Test
    public void searchByID() {
        assertEquals(VehicleUtil.searchByID("C001", vehicles), vehicle);
        assertEquals(VehicleUtil.searchByID("asdfadsf", vehicles), null);
        assertEquals(VehicleUtil.searchByID("", vehicles), null);
    }

    @Test
    public void calculateTotalFee() {
        assertEquals(VehicleUtil.calculateTotalFee(vehicle, 1), 75.0, 0.000000000001);
    }

    @Test
    public void printDetails() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        VehicleUtil.printDetails(user, vehicle, new Date[]{simpleDateFormat.parse("08/08/2022"),
                simpleDateFormat.parse("18/08/2022")});
    }

    @After
    public void tearDown(){
        vehicles = null;
        vehicle = null;
        user = null;
    }
}