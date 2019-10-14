package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/")
    public String getHomePage(Model model, Principal principal){
        model.addAttribute("NotLoggedIn", principal == null);
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "home";
    }

    @RequestMapping("/clearAllAccounts")
    public String clearAccounts() {
        accountRepository.deleteAll();
        accountRepository.flush();
        return "home";
    }
}
