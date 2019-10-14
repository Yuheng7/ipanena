package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.repository.AccountRepository;
import com.yuphanie.ipanena.repository.CreditCardRepository;
import com.yuphanie.ipanena.services.CreditCardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.smartcardio.Card;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
public class CardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private CardController cardController;

    @MockBean
    private CreditCardService creditCardService;

    @MockBean
    private CreditCardRepository creditCardRepository;

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp(){
        cardController = new CardController(creditCardService);
    }

    @Test
    public void shouldLoadCardPage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/cards")
                .accept(MediaType.ALL)).andExpect(status().isOk());
    }

    @Test
    public void shouldShowCreditCards(){
        cardController.showCreditCards();
        verify(creditCardService,times(1)).getCreditCards();
    }
}
