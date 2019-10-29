package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@Controller
@RestController
@RequestMapping("/api")
public class LoginController {

    //    @GetMapping("/login")
//    public String login(Model model) {
//
//        return "login";
//    }
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/login")
    public ModelAndView loginPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        System.out.println("hello i am login controller");
//    System.out.println("--->"+SecurityContextHolder.getContext().getAuthentication().getName());
        return model;
    }


    @GetMapping("/login-error")
    public String loginerror(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "logout";

    }

    @GetMapping("/index")
    public String login2(Model model) {
        return "index";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(Model model) {
        return "accessDenied";
    }

}
