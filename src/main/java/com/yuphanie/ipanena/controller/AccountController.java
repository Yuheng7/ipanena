package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/create")
    public ModelAndView showCreateAccountForm() {
        return new ModelAndView("create");
    }

    //Get the form field vaues which are populated using the backing bean and store it in db
    @PostMapping("/create")
    public ModelAndView sendCreateAccountForm(HttpServletRequest request) {
        Account account = new Account(request.getParameter("user_name"))
                .setEmail_address(request.getParameter("user_email"))
                .setPassword("{noop}" + request.getParameter("user_password"))
                .setEnabled(1);
        accountService.create(account);
        ModelAndView model = new ModelAndView("account");
        model.addObject("acc", account);
        return model;
    }
}
