package com.example.demo.dao;

import com.example.demo.model.AppCompany;
import com.example.demo.model.AppUser;

import java.util.List;

public interface AppCompanyDAO {
    List<AppCompany> getAllCompanies();
    void insertAppCompany(AppCompany appCompany);
}
