package com.example.derrick.rentalmanager.models;

/**
 * Created by root on 10/16/17.
 */

public class AddProperty {

    private String name;
    private String location;
    private String category;
    private String email;
    private String propertyId;

    public AddProperty() {
    }

    public AddProperty(String name, String location, String category, String email, String propertyId) {

        this.name = name;
        this.location = location;
        this.category = category;
        this.email = email;
        this.propertyId = propertyId;
    }



    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getEmail() {
        return email;
    }

    public String getPropertyId () {
        return propertyId;
    }
}
