package com.yuphanie.ipanena.services;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(Account account){
        accountRepository.saveAndFlush(account);
        return account;
    }

    public Account get(String username) {
        return accountRepository.findByUsername(username);
    }
}
