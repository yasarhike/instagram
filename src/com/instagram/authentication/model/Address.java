package com.instagram.authentication.model;

/**
 * <p>
 * Hold the address details of the user.
 * </p>
 *
 * @author Mohamed Yasar
 * @version 1.0 6 Feb 2024
 */
public class Address {

    private String country;
    private String countryCode;
    private String state;
    private String doorNumber;
    private String streetName;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(final String streetName) {
        this.streetName = streetName;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(final String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(final String code) {
        this.countryCode = code;
    }
}

