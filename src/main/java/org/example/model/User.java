package org.example.model;

/**
 * User class stores user's information input by user.
 */
public class User {
    private String name;
    private String surname;
    private String emailAddress;
    private int passengerNum;

    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }

    @Override
    public String toString() {
        return "\nName:'" + name + '\'' +
                "\nEmail address:'" + emailAddress + '\'';
    }
}
