package org.example.model;
import java.util.Objects;

/**
 * Vehicle class stores all vehicle information read from csv file.
 */
public class Vehicle {
    private String vehicleID;
    private String brand;
    private String model;
    private String type;
    private int manufactureYear;
    private int seat;
    private String color;
    private int rentalPerDay;
    private int insurancePerDay;
    private int serviceFee;
    private double discount;

    /**
     * Getters and setters
     */
    public String getVehicleID(){
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getManufactureYear(){
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear){
        this.manufactureYear = manufactureYear;
    }

    public int getSeat(){
        return seat;
    }

    public void setSeat(int seat){
        this.seat = seat;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getRentalPerDay(){
        return rentalPerDay;
    }

    public void setRentalPerDay(int rentalPerDay){
        this.rentalPerDay = rentalPerDay;
    }

    public int getInsurancePerDay(){
        return insurancePerDay;
    }

    public void setInsurancePerDay(int insurancePerDay){
        this.insurancePerDay = insurancePerDay;
    }

    public int getServiceFee(){
        return serviceFee;
    }

    public void setServiceFee(int serviceFee){
        this.serviceFee = serviceFee;
    }

    public double getDiscount(){
        return discount;
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }


    /**
    * Returns the vehicle details into a well-structured string.
    */
    @Override
    public String toString() {
        return vehicleID + " - " + brand + " " + model + " " + type + " with " + seat + " seats";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return manufactureYear == vehicle.manufactureYear && seat == vehicle.seat
                && rentalPerDay == vehicle.rentalPerDay && insurancePerDay == vehicle.insurancePerDay
                && serviceFee == vehicle.serviceFee && Double.compare(vehicle.discount, discount) == 0
                && vehicleID.equals(vehicle.vehicleID) && brand.equals(vehicle.brand)
                && model.equals(vehicle.model) && type.equals(vehicle.type)
                && color.equals(vehicle.color);
    }
}
