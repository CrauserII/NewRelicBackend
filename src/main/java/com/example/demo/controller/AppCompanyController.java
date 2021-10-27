package com.example.demo.controller;

import com.example.demo.model.AppCompany;
import com.example.demo.model.AppUser;
import com.example.demo.service.AppCompanyService;
import com.example.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppCompanyController {
    @Autowired
    AppCompanyService appCompanyService;

        @RequestMapping(value = "/appCompanies", method = RequestMethod.GET)
    public List<AppCompany> getCompanies() {

        return appCompanyService.getAllCompanies();

    }

    @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
    public void addComapany(@RequestBody AppCompany company) {

        appCompanyService.insertCompany(company);

    }


}
