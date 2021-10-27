package com.example.demo.service;

import com.example.demo.model.AppCompany;
import com.example.demo.model.AppUser;

import java.util.List;

public interface AppCompanyService {
    List<AppCompany> getAllCompanies();
    void insertCompany(AppCompany user);
}
