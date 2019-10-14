package com.yuphanie.ipanena.controller;

import com.yuphanie.ipanena.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cards")
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
}
