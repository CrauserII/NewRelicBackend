package com.example.demo.service;

import com.example.demo.dao.AppUserDAO;
import com.example.demo.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{
    @Autowired
    AppUserDAO userDao;

    @Override
    public List<AppUser> getAllUsers(Integer offset, String search,String company, String order) {
        List<AppUser> result = userDao.getAllEmployees(offset, search,company,order);
        return result;
    }

    @Override
    public void insertUser(AppUser user) {
        userDao.insertAppUser(user);
    }
}
