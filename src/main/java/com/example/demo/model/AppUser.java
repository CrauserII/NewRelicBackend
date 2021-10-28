package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AppUser {
    private Integer user_id;
    private String firstName;
    private String lastName;
    private Integer company_id;
    private String company_name;

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer userId) {
        this.user_id = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public AppUser(){
        super();
    }
    public AppUser(Integer user_id, String firstName, String lastName, Integer company_id, String company_name) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company_id = company_id;
        this.company_name = company_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId='" + user_id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
