package com.escass.springbootbasicproject.controllers;

import com.escass.springbootbasicproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        System.out.println("get");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView postLogin(@RequestParam(value = "id", required = false) String username,
                            @RequestParam(value = "pw", required = false) String password) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(username);
        System.out.println(password);
        boolean result = this.userService.LoginCheck(username, password);
        if (result) {
            modelAndView.setViewName("user/register");
        } else {
            modelAndView.setViewName("user/login");
        }
        return modelAndView;
    }
}
