package com.yuphanie.ipanena.tests;

import static com.yuphanie.ipanena.helpers.SyntaxSugar.*;

import org.junit.Test;


public class UserJourneyTest extends UserJourneySetUp {

    @Test
    public void userJourneyHappyPathWithCreatedUser() {

        user
                .visits_home_page();
        screen
                .shows_home_page();
        user
                .visits_login_page();
        screen
                .shows_login_page();
        user
                .logs_in_with(SOME_NAME, SOME_PASSWORD);
        user
                .visits_about_page();
        screen
                .shows_about_page();
        user
                .visits_home_page();
        screen
                .shows_home_logged_in();
//        user
//                .logs_out();
//        screen
//                .shows_home_logged_out();
    }
}
