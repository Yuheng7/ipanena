package com.yuphanie.ipanena.services;

import com.yuphanie.ipanena.model.CreditCard;
import com.yuphanie.ipanena.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class CreditCardService {
    private CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCard> getCreditCards(){
        return creditCardRepository.findAll();
    }
}
