package com.yuphanie.ipanena.service;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import com.yuphanie.ipanena.repository.CreditCardRepository;
import com.yuphanie.ipanena.repository.RewardRepository;
import com.yuphanie.ipanena.repository.SignOnBonusRepository;
import com.yuphanie.ipanena.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AccountServiceTest {

    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @MockBean
    private SignOnBonusRepository signOnBonusRepository;

    @MockBean
    private RewardRepository rewardRepository;

    @Before
    public void setUp() throws Exception{
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void shouldCallSaveAccount() {
        accountService.create(getDefaultAccountWithoutError());
        verify(accountRepository,times(1)).saveAndFlush(refEq(getDefaultAccountWithoutError()));
        verify(accountRepository,times(1)).insertIntoAuthoritiesTable("username", "ROLE_USER");
    }

    @Test
    public void shouldCallGetAccount() {
        accountService.getByUsername("username");
        verify(accountRepository,times(1)).findByUsername("username");
    }

    public Account getDefaultAccountWithoutError() {
        return new Account("username")
                .setEmailAddress("email@.com")
                .setPassword("password");
    }
}
