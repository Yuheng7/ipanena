package com.yuphanie.ipanena.services;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private static final String USER = "ROLE_USER";
    private static final String ADMIN = "ROLE_ADMIN";

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //This should actually be all done in accountrepository --> there should be a find by role or something like that thing
    public Account create(Account account){
        accountRepository.saveAndFlush(account);
        accountRepository.insertIntoAuthoritiesTable(account.getUsername(), USER);
        return account;
    }

    public Account get(String username) {
        return accountRepository.findByUsername(username);
    }


}
