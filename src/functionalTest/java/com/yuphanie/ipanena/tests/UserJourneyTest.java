package com.yuphanie.ipanena.tests;

import static com.yuphanie.ipanena.helpers.SyntaxSugar.*;

import com.yuphanie.ipanena.repository.AccountRepository;
import com.yuphanie.ipanena.services.AccountService;
import org.junit.Test;

import java.util.EmptyStackException;


public class UserJourneyTest extends UserJourneySetUp {

    @Test
    public void userJourney() {

        clean_start_up();
        visitAllNonLoginPages();

        user
                .logs_in_with(EMPTY_STRING, EMPTY_STRING);
        screen
                .shows_login_page_error();
        user
                .clicks_create_account();
        screen
                .shows_create_account_page();

        errorCheckingCreateAccount();

        user
                .creates_account(SOME_NAME, SOME_PASSWORD, SOME_EMAIL);
        screen
                .shows_create_account_success();
        user
                .logs_in_with(SOME_NAME, SOME_PASSWORD);
        screen
                .shows_home_logged_in();
        user
                .logs_out();
        screen
                .shows_home_logged_out();
        clean_start_up();
    }

    private void visitAllNonLoginPages() {
        user
                .visits_home_page();
        screen
                .shows_home_page();
        user
                .visits_login_page();
        screen
                .shows_login_page();
        user
                .visits_credit_card_page();
        screen
                .shows_credit_card_page();
        user
                .visits_about_page();
        screen
                .shows_about_page();
    }

    public void errorCheckingCreateAccount() {
        user
                .creates_account(EMPTY_STRING, SOME_PASSWORD, SOME_EMAIL);
        //this later needs to be just the regular account create page, with error messages individualized for specific mistakes
        //but this is just easier right now
        //also don't know why it goes to account/create and not account/createFailure
        screen
                .shows_create_account_error_page();
        user
                .creates_account(SOME_NAME, EMPTY_STRING, SOME_EMAIL);
        screen
                .shows_create_account_error_page();
        user
                .creates_account(SOME_NAME, SOME_PASSWORD, EMPTY_STRING);
        screen
                .shows_create_account_error_page();
        user
                .creates_account(EXISTING_NAME, SOME_PASSWORD, SOME_EMAIL);
        screen
                .shows_create_account_error_page();
        user
                .creates_account(SOME_NAME, SOME_PASSWORD, EXISTING_EMAIL);
        screen
                .shows_create_account_error_page();
    }

    private void clean_start_up() {
        user
                .deletes_made_account(SOME_NAME);
    }
}
