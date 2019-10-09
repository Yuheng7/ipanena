package com.yuphanie.ipanena.repository;

import com.yuphanie.ipanena.model.Account;
import com.yuphanie.ipanena.services.AccountService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}
