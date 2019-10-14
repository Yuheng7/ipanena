package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import com.yuphanie.ipanena.repository.CreditCardRepository;
import com.yuphanie.ipanena.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private AccountController accountController;

    @MockBean
    private AccountService accountService;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void shouldLoadAccountPage() throws Exception{

        mockMvc.perform(get("/account")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Before
    public void setUp(){
        accountController = new AccountController(accountService);
    }

    @Test
    public void shouldLoadCreatePageAndCreateAccount() throws Exception{
        HttpServletRequest requestWithoutError = getValidHttpServletRequest();

        mockMvc.perform(post("/account/create")
                .accept(MediaType.ALL))
                .andExpect(status().isOk());

        accountController.sendCreateAccountForm(requestWithoutError);

        verify(accountService,times(1))
                .create(refEq(getDefaultAccountWithoutError()));
    }

    public Account getDefaultAccountWithoutError() {
        return new Account("username")
                .setEmail_address("email@.com")
                .setPassword("{noop}password")
                .setEnabled(1);
    }

    private HttpServletRequest getValidHttpServletRequest() {
        //basically you're mocking this entire servlet
        HttpServletRequest request = mock(HttpServletRequest.class);

        //what this does is WHENEVER ANYTHING uses this request and calls request.get..., it will return these things
        when(request.getParameter("user_email")).thenReturn("email@.com");
        when(request.getParameter("user_password")).thenReturn("password");
        when(request.getParameter("user_name")).thenReturn("username");

        return request;
    }
}

