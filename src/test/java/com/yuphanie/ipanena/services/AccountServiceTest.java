package com.yuphanie.ipanena.services;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void shouldCallInsertAccount() {
        when(accountRepository.save(new Account("username"))).thenReturn(new Account("username"));
        assertThat(refEq(accountService.create("username")), is(new Account("username")));
        verify(accountRepository,times(1)).save(new Account("username"));

    }
}
