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

    @GetMapping("/users")
    String get_users(){
        int data = userMapper.select1();
        Date now = userMapper.selectNow();
        List<User> users = userMapper.selectUsers();
        System.out.println(data);
        System.out.println(now);
        System.out.println(users);
        return "index";
    }

    @GetMapping("/user_id")
        // GET 요청을 받을 때 유저의 id를 파라미터로 받아주고
    String get_user(String id){
        // 해당 파라미터를 사용해서 DB에서 데이터를 조회하자
        User user = userMapper.selectUserById(id);
        System.out.println("조회된 유저: " + user);
        return "index";
    }

}
