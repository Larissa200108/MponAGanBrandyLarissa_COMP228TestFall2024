package com.example.models;

// Student's personal and address details
public class Student {
    private final String studentID;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String province;
    private final String postalCode;

    // A constructor that initializes a Student object with the given details
    public Student(String studentID, String firstName, String lastName, String address, String city, String province, String postalCode) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        // Use String.format to format the string with the student's details
        return String.format("%-20s %-20s %-20s %-30s %-30s %-20s %-10s%n",
                studentID, firstName, lastName, address, city, province, postalCode);
    }
}
