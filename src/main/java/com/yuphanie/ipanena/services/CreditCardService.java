package com.yuphanie.ipanena.services;

import com.yuphanie.ipanena.model.CreditCard;
import com.yuphanie.ipanena.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard addCreditCard(CreditCard creditCard){
        creditCardRepository.save(creditCard);
        return creditCard;
    }
}
