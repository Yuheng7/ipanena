package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import com.yuphanie.ipanena.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void shouldLoadAccountPage() throws Exception{
        mockMvc.perform(get("/account").accept(MediaType.ALL))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldLoadCreatePageAndCreateAccount() throws Exception{
        when(accountService.create("username")).thenReturn(new Account("username"));
        mockMvc.perform(post("/account/create").accept(MediaType.ALL))
                .andExpect(status().isOk());

        verify(accountService,times(1)).create("username");
    }
}
