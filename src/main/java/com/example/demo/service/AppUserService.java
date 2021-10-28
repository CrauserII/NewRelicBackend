package com.example.demo.service;

import com.example.demo.model.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAllUsers(Integer offset, String search,String company, String order);
    void insertUser(AppUser user);
}
