package com.escass.springbootbasicproject.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Controller
public class SessionController {
    // 쿠키를 생성하는 경로
    @RequestMapping("/create_cookie")
    public String create_cookie(
            // Spring 이전의 Servlet에서 사용하는 응답객체
            HttpServletResponse response
    ) {
        String encodedValue = URLEncoder.encode("스프링에서만듦", StandardCharsets.UTF_8);
        // URLDecoder.decode(encodedValue, StandardCharsets.UTF_8);
        // 쿠키의 생성 (정의) => 영어,숫자는 그냥 넣으면 되는데 다른 글자는 URL Encoding 해야 함
        Cookie cookie = new Cookie("myCookie", encodedValue);
        // setMaxAge를 정해주면 Persistence 쿠키가 된다 (생명선이 존재함, 브라우저 껐다 켜도 있음)
        // 정하지 않으면 Session 쿠키가 된다 (브라우저 끄면 사라짐)
        cookie.setMaxAge(10); // 생성한 후로 10초만 살고 있음
        // 생성된 쿠키를 응답에 추가
        response.addCookie(cookie);
        // 화면 보여주기 (응답)
        return "cookie/cookie";
    }

    @RequestMapping("/cookie")
    public String cookie(HttpServletRequest request) {
        // 모든 쿠키 값을 가져온다
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("cookie name:" + cookie.getName());
            System.out.println("cookie value:" + cookie.getValue());
        }
        return "cookie/cookie";
    }

    @RequestMapping("/create_session")
    public String create_session(HttpServletRequest request) {
        // 세션을 가져온다
        // 원래 있었으면 기존 세션 가져오고 없었으면 생성해서 가져온다
        HttpSession session = request.getSession();
        System.out.println("session id: " + session.getId());
        // 방금 생성되었으면 true
        System.out.println("is New? => " + session.isNew());
        // cookie폴더에 있는 session.html을 보여준다
        return "cookie/session";
    }

    // Request 객체 뛰어넘고 바로 session 객체 가져오기
    @RequestMapping("/session")
    public String session(HttpSession session) {
        System.out.println("id: " + session.getId());
        // 데이터를 binding (바인딩)
        session.setAttribute("sNumber", 1000);
        session.setAttribute("sDate", new Date());

        Date date = (Date) session.getAttribute("sDate");


        return "cookie/session";
    }
}
