package com.escass.springbootbasicproject.controllers;

import com.escass.springbootbasicproject.dto.User;
import com.escass.springbootbasicproject.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    // 기본적으로 url에 적는 경로와 html파일 경로 같으면
    // 반환 안해도 알아서 url 경로와 같은 html 찾아감
    @GetMapping("/login")
    public String get_login(HttpSession session) {
        System.out.println("get_login이 실행됨");
        // 로그인을 하고 왔으면 loginData가 null이 아닐것이다
        Object loginData = session.getAttribute("login");
        // 로그인이 안 된 상태라면 로그인 페이지를 보여준다
        if(loginData == null) {
            return "user/login";
        }
        // 로그인이 된 상태라면 다시 board로 GET요청한다
        return "redirect:/board";
    }

    @PostMapping("/login")
    String post_login(
            @RequestParam("id") String userID, // 파라미터
            @RequestParam("pw") String userPW, // 파라미터
            HttpSession session // 현재 어플리케이션에서 사용하는 세션
    ) {
        // id: korea / pw: 123
        System.out.println("post_login이 실행됨");
        System.out.println("받은id: " + userID);
        System.out.println("받은pw: " + userPW);

        // 파라미터로 받은 id와 pw를 사용해서 해당 유저의 정보를 DB에서 조회한다
        User user = userMapper.selectUser(userID, userPW);

        // 로그인 성공이다!!
        if(user != null) {
            session.setAttribute("login", true);
            // 조회된 유저를 세션에 등록한다(바인딩)
            session.setAttribute("user", user);

            // redirect: 재 요청을 보낸다 (GET)
            // url 적는 곳의 경로를 적어야 함!
            // '/' 를 작성하면 localhost:8080 이 기준
            // '/' 를 작성하지 않으면 현재 내 경로가 기준
            // => localhost:8080/main/login/board 가 되버린다
            return "redirect:/board";
        }
        return "redirect:/user/login";
    }
    /***********************************************************/
    @GetMapping("/logout")
    public String get_logout(HttpSession session){
        // 현재 존재하는 세션을 제거한다(삭제)
        session.invalidate();
        // 다시 로그인 페이지로 보낸다 (GET요청)
        return "redirect:/user/login";
    }



    /***********************************************************/
    @GetMapping("/register")
    public void get_register() {}

    // 핸들러 메서드에서는 파라미터 명과 필드 변수명이 같은 객체를 자동으로 매핑해준다
    @PostMapping("/register")
    public String post_register(User user){
        userMapper.insertUser(user);
        return "redirect:/user/login";
    }





}
