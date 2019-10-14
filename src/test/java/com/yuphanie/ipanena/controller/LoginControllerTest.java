package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(LoginController.class)
//public class LoginControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void canLoadLoginPage() throws Exception{
//
//        mockMvc.perform(get("/login")
//                .accept(MediaType.ALL))
//                .andExpect(status().isOk());
//    }
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    private LoginController loginController;
//
//    @Before
//    public void setUp() {
//        loginController = new LoginController();
//    }
//
//    @Test
//    public void canLoginValidUser() {
//        String id = createValidUser();
//
//        clearValidUser(id);
//    }
//
//    public String createValidUser() {
//        Account account = new Account("TestUser")
//                .setPassword("password")
//                .setEmail_address("TestUser@gmail.com");
//        accountRepository.saveAndFlush(account);
//    }
//
//    public void clearValidUser(String id) {
//        accountRepository.deleteById(id);
//    }
//

//}
