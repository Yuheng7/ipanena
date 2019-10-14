package com.yuphanie.ipanena.repository;

import com.yuphanie.ipanena.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO authorities (username, authority) VALUES (?,?)", nativeQuery = true)
    void insertIntoAuthoritiesTable(String username, String role);
}
