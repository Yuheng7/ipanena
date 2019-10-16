package com.yuphanie.ipanena.model;

import com.yuphanie.ipanena.services.AccountService;

import java.util.HashMap;

public class CreateAccountValidator {

    public static HashMap verifyInputs(Account account, AccountService accountService) {
        HashMap errors = new HashMap();

        if (!account.getEmailAddress().contains("@")) {
            errors.put("email", "Must enter a valid email!");
        }

        if (accountService.getByEmail(account.getEmailAddress()) != null) {
            errors.put("email", "email is already taken");
        }

        if(account.getPassword().length() < 7) {
            errors.put("password", "Must enter a password!");
        }

        if(account.getUsername().length() < 1) {
            errors.put("name", "Must enter a name!");
        }

        if(accountService.getByUsername(account.getUsername()) != null) {
            errors.put("name_taken", "username already taken");
        }

        return errors;
    }

}
