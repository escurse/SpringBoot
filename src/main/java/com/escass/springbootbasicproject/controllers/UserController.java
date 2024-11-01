package com.escass.springbootbasicproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    // 기본적으로 url에 적는 경로와 html파일 경로 같으면
    // 반환 안해도 알아서 url 경로와 같은 html 찾아감
    @GetMapping("/login")
    public void get_login() {
    }

    @PostMapping("/login")
    String post_login(
            @RequestParam("id") String userID,
            @RequestParam("pw") String userPW
    ) {
        if(userID.equals("korea") && userPW.equals("123")) {
            // redirect: 재 요청을 보낸다 (GET)
            // url 적는 곳의 경로를 적어야 함!
            // '/' 를 작성하면 localhost:8080 이 기준
            // '/' 를 작성하지 않으면 현재 내 경로가 기준
            // => localhost:8080/main/login/board 가 되버린다
            return "redirect:/board";
        }
        return "redirect:/user/login";
    }

    @GetMapping("/register")
    public void get_register() {}

}
