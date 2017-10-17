package com.example.derrick.rentalmanager.models;

/**
 * Created by root on 10/13/17.
 */

public class AddTenant {
    private String tenantId;
    private String firstName;
    private String lastName;
    private String roomNumber;
    private String email;
    private String phone;


    public AddTenant() {
    }

    public AddTenant(String tenantId, String firstName, String lastName, String roomNumber, String email, String phone) {
        this.tenantId = tenantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
        this.email = email;
        this.phone = phone;

    }

    public String getTenantId() {
        return tenantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


}
