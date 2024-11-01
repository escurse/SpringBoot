package com.escass.springbootbasicproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="main")
public class MainController {
    @RequestMapping(value="board", method= RequestMethod.GET)
    public ModelAndView getBoard() {
        ModelAndView modelAndView = new ModelAndView();
        // prefix: 앞에 붙는 단어 => /templates/
        // suffix: 뒤에 붙는 단어 => .html
        // 실제 경로 => /templates/ main/board .html
        modelAndView.setViewName("main/board");
        modelAndView.addObject("data", 100);
        return modelAndView;
    }

    @RequestMapping(value="write", method= RequestMethod.GET)
    public ModelAndView getWrite() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main/write");
        return modelAndView;
    }
}
