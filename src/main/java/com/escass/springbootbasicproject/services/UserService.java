package com.escass.springbootbasicproject.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean LoginCheck(String username, String password) {
        System.out.println("hi");
        return username.equals("admin") && password.equals("admin");
    }
}
