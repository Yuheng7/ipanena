package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.model.CreditCard;
import com.yuphanie.ipanena.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {
    private final CreditCardService creditCardService;

    @Autowired
    public CardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public ModelAndView showCreditCards(){
        ModelAndView model = new ModelAndView("cards");
        model.addObject("creditCards", creditCardService.getCreditCards());
        return model;
    }

    @GetMapping("/cards")
    List<CreditCard> cards(){
        return creditCardService.getCreditCards();
    }

//    @DeleteMapping
//    @PutMapping
//    @PostMapping
}
