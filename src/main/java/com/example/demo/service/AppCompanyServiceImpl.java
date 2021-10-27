package com.example.demo.service;

import com.example.demo.dao.AppCompanyDAO;
import com.example.demo.dao.AppUserDAO;
import com.example.demo.model.AppCompany;
import com.example.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppCompanyServiceImpl implements AppCompanyService{
    @Autowired
    AppCompanyDAO companyDao;

    @Override
    public List<AppCompany> getAllCompanies() {
        List<AppCompany> result = companyDao.getAllCompanies();
        return result;
    }

    @Override
    public void insertCompany(AppCompany appCompany) {
        companyDao.insertAppCompany(appCompany);
    }
}
