package com.example.derrick.rentalmanager.models;


public class AddWorkers {
    private String workersId;
    private String firstName;
    private String lastName;
    private String profession;
    private String phone;
    private String salary;
    private String worksAt;

    public AddWorkers() { }

    public AddWorkers(String workersId, String firstName, String lastName, String profession, String phone, String salary, String worksAt) {
        this.workersId = workersId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.phone = phone;
        this.salary = salary;
        this.worksAt = worksAt;
    }

    public String getWorkersId() {
        return workersId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfession() {
        return profession;
    }

    public String getPhone() {
        return phone;
    }

    public String getSalary() {
        return salary;
    }

    public String getWorksAt() {
        return worksAt;
    }
}
