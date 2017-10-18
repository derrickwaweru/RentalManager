package com.example.derrick.rentalmanager.models;


public class AddReports {

    private String from;
    private String to;
    private String reportType;
    private String reportDescription;
    private String propertyName;
    private String roomNumber;
    private String reportId;


    public AddReports() {}

    public AddReports(String from, String to, String reportType, String reportDescription, String propertyName, String roomNumber, String reportId) {

        this.from = from;
        this.to = to;
        this.reportType = reportType;
        this.reportDescription = reportDescription;
        this.propertyName = propertyName;
        this.roomNumber = roomNumber;
        this.reportId = reportId;
    }



    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getReportId () {
        return reportId;
    }
}
