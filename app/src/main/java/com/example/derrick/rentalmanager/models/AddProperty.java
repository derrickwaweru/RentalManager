package com.example.derrick.rentalmanager.models;

/**
 * Created by root on 10/16/17.
 */

public class AddProperty {
    private String propertyId;
    private String name;
    private String location;
    private String category;
    private String income;

    public AddProperty() {
    }

    public AddProperty(String propertyId, String name, String location, String category, String income) {
        this.propertyId = propertyId;
        this.name = name;
        this.location = location;
        this.category = category;
        this.income = income;
    }

    public String getPropertyId() {
        return propertyId;
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

    public String getIncome() {
        return income;
    }
}
