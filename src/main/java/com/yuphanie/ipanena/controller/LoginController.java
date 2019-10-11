package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("login-error")
    public String loginerror(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "logout";

    }

    @RequestMapping(value = "/403")
    public String accessDenied(Model model) {
        return "accessDenied";
    }

}
