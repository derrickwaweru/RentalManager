package com.example.derrick.rentalmanager.models;


public class AddVacancy {
    private String vacancyId;
    private String name;
    private String phone;
    private String propertyName;
    private String address;
    private String vacancies;
    private String rent;

    public AddVacancy() { }

    public AddVacancy(String vacancyId, String name, String phone, String propertyName, String address, String vacancies, String rent) {
        this.vacancyId = vacancyId;
        this.name = name;
        this.phone = phone;
        this.propertyName = propertyName;
        this.address = address;
        this.vacancies = vacancies;
        this.rent = rent;
    }

    public String getVacancyId() {
        return vacancyId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getAddress() {
        return address;
    }

    public String getVacancies() {
        return vacancies;
    }

    public String getRent() {
        return rent;
    }
}
