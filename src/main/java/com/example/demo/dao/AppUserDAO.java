package com.example.demo.dao;

import com.example.demo.model.AppUser;

import java.util.List;

public interface AppUserDAO {
    List<AppUser> getAllEmployees(Integer offset, String search,Integer company, String order);
    void insertAppUser(AppUser appUser);
}
