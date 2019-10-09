package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String getAccount(){
        return "account";
    }

    @PostMapping("/create")
    public String postCreateAccount(){
        accountService.create("username");
        return "create";
    }
}
