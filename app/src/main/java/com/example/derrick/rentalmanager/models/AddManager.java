package com.example.derrick.rentalmanager.models;


public class AddManager {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String propertyManaged;
    private String propertyOwner;
    private String propertyAddress;

    public AddManager() { }

    public AddManager(String firstName, String lastName, String email, String phone, String propertyManaged,
                      String propertyOwner, String propertyAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.propertyManaged = propertyManaged;
        this.propertyOwner = propertyOwner;
        this.propertyAddress = propertyAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPropertyManaged() {
        return propertyManaged;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }
}
