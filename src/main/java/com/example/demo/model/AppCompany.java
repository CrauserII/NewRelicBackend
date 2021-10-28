package com.example.demo.model;


public class AppCompany {
    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public AppCompany(Integer company_id, String companyName) {
        this.company_id = company_id;
        this.companyName = companyName;
    }

    private Integer company_id;
    private String companyName;

}
