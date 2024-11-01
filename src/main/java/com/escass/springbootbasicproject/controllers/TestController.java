package com.escass.springbootbasicproject.controllers;

import com.escass.springbootbasicproject.dto.User;
import com.escass.springbootbasicproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user_id")
    String get_user(){
        int data = userMapper.select1();
        Date now = userMapper.selectNow();
        List<User> users = userMapper.selectUsers();
        System.out.println(data);
        System.out.println(now);
        System.out.println(users);
        return "index";
    }




}
