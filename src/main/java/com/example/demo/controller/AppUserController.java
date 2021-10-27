package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class   AppUserController {
    @Autowired
    AppUserService userService;

        @RequestMapping(value = "/appUsers", method = RequestMethod.GET)
    public List<AppUser> getEmployees(@RequestParam(required = false) Integer offset,
                                      @RequestParam(required = false) String search,
                                      @RequestParam(required = false) Integer company,
                                      @RequestParam(required = false) String order) {

        return userService.getAllUsers(offset,search, company,order);

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody AppUser user) {

        userService.insertUser(user);

    }


}
