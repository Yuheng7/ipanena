package com.yuphanie.ipanena.service;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import com.yuphanie.ipanena.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;


import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Before
    public void setUp() throws Exception{
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void shouldCallSaveAccount() {
        when(accountRepository.save(getDefaultAccount())).thenReturn(getDefaultAccount());
        assertThat(refEq(accountService.create("username")), is(getDefaultAccount()));
        verify(accountRepository,times(1)).save(new Account("username"));

    }

    public Account getDefaultAccount() {
        Account account = new Account("username");
        return account;
    }
}
