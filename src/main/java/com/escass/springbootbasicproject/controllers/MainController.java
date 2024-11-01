package com.escass.springbootbasicproject.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @RequestMapping("/board") // 주소창에 적는 경로
    ModelAndView get_board(HttpSession session){
        System.out.println("get_board가 실행됨");
        Object loginData = session.getAttribute("login");
        if(loginData == null){
            System.out.println("로그인 안하고 왔네?");
            // 다시 /user/login으로 GET요청한다
            return new ModelAndView("redirect:/user/login");
        }

        ModelAndView mav = new ModelAndView();
        // prefix: 앞에 붙는 단어 => /templates/
        // suffix: 뒤에 붙는 단어 => .html
        // 실제로 화면에 보여줄 html 파일의 경로 (templates를 기본으로 함)
        // 실제 만들어지는 경로명 => /templates/main/board .html
        mav.setViewName("main/board");
        mav.addObject("data", 100);
        return mav;
    }

    // /write라고 했을 때 write 페이지로 이동할 수 있는 메서드
    // => /write에 대해 GET 요청을 받고 main/write를 보여주는 메서드
    @RequestMapping("/write") // 주소창에 적는 경로
    String get_write(Model model){
        // ModelAndView에서 addObject와 같다
        model.addAttribute("data", 100);
        // String 형태를 반환하면 해당 이름의 html을 찾아간다!
        return "main/write";
    }
}
