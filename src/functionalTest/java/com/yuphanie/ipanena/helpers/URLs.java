package com.yuphanie.ipanena.helpers;

public class URLs{

    public static final String BASE = "http://localhost:8080";

    public static String home() {
        return BASE + "/";
    }

    public static String login() {
        return BASE + "/login";
    }

    public static String logout() {
        return BASE + "/logout";
    }

    public static String about() {
        return BASE + "/about";
    }

    public static String loginError() {
        return BASE + "/login-error";
    }

    public static String createAccount() {
        return BASE + "/account/create";
    }

    public static String createAccountFailure() {
        return BASE + "/account/createFailure";
    }

    public static String creditCards() {
        return BASE + "/cards";
    }
}
