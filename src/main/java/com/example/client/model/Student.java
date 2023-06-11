package com.example.client.model;

public class Student {

    private long studentId;
    private String firstName;
    private String lastName;
    // @JsonProperty("CIN")

    private String cin;

    public Student(String firstName, String lastName, String cin, String mdp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.mdp = mdp;
    }

    private String mdp;

    public String getCIN() {
        return cin;
    }

    public void setCIN(String cin) {
        this.cin = cin;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    // Add additional properties as needed

    // Constructors, getters, and setters

    public Student() {
    }

    public Student(long studentId, String firstName, String lastName, String cin, String mdp) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.mdp = mdp;
    }
// Getters and setters for the properties

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

