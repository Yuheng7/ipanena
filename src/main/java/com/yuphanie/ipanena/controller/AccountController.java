package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.yuphanie.ipanena.model.CreateAccountValidator.verifyInputs;

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

    @GetMapping("/createFailure")
    public ModelAndView showCreateAccountFailure() {
        return new ModelAndView("createFailure");
    }

    @GetMapping("/createSuccess")
    public ModelAndView showCreateAccountSuccess() {
        return new ModelAndView("createSuccess");
    }

    //Get the form field vaues which are populated using the backing bean and store it in db
    @PostMapping("/create")
    public ModelAndView sendCreateAccountForm(HttpServletRequest request) {
        Account account = new Account(request.getParameter("user_name"))
                .setEmail_address(request.getParameter("user_email"))
                .setPassword("{noop}" + request.getParameter("user_password"))
                .setEnabled(1);

        HashMap errors = verifyInputs(account);
        if(!errors.isEmpty()) {
            return showErrors(errors);
        }
        try {
            return showSuccess(accountService.create(account));
        } catch (Exception e) {
            return showError();
        }
    }

    private ModelAndView showErrors(Map errors) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("errors", errors);
        return new ModelAndView("createFailure", "validationMessage", modelMap);
    }

    private ModelAndView showError() {
        return new ModelAndView("createFailure");
    }

    private ModelAndView showSuccess(Account account) {
        ModelMap modelMap = new ModelMap();
        modelMap.put("name", account.getUsername());
        return new ModelAndView("createSuccess", "postedValues", modelMap);
    }


}
