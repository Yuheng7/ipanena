package com.yuphanie.ipanena.model;

import java.util.HashMap;

public class CreateAccountValidator {

    public static HashMap verifyInputs(Account account) {
        HashMap errors = new HashMap();

        if (!account.getEmail_address().contains("@")) {
            errors.put("email", "Must enter a valid email!");
        }

        if(account.getPassword().isEmpty()) {
            errors.put("password", "Must enter a password!");
        }

        if(account.getUsername().isEmpty()) {
            errors.put("name", "Must enter a name!");
        }

        return errors;
    }

}
