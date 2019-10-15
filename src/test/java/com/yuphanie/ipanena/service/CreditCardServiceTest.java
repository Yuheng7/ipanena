package com.yuphanie.ipanena.service;

import com.yuphanie.ipanena.model.SignOnBonus;
import com.yuphanie.ipanena.repository.AccountRepository;
import com.yuphanie.ipanena.repository.CreditCardRepository;
import com.yuphanie.ipanena.repository.RewardRepository;
import com.yuphanie.ipanena.repository.SignOnBonusRepository;
import com.yuphanie.ipanena.services.CreditCardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class CreditCardServiceTest {

    private CreditCardService creditCardService;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @MockBean
    private RewardRepository rewardRepository;

    @MockBean
    private SignOnBonusRepository signOnBonusRepository;

    @Before
    public void setUp() throws Exception{
        creditCardService = new CreditCardService(creditCardRepository);
    }

    @Test
    public void shouldCallGetCreditCards(){
        creditCardService.getCreditCards();
        verify(creditCardRepository, times(1)).findAll();
    }
}
