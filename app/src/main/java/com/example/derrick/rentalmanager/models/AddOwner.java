package com.example.derrick.rentalmanager.models;


public class AddOwner {
    private String ownerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public AddOwner() { }

    public AddOwner(String ownerId, String firstName, String lastName, String email, String phone) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getOwnerId() {
        return ownerId;
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
}
