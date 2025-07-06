package com.ntu.flightclientservice.model;

public class User {
    private String email;
    private String name;
    private String role;
    private String phoneNo;
    private String password;

    public User() {
    }

    public User(String email, String name, String role, String phoneNo, String password) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}