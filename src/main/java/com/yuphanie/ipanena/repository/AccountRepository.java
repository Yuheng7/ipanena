package com.yuphanie.ipanena.repository;

import com.yuphanie.ipanena.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Account findByEmailAddress(String email_address);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO authorities (username, authority) VALUES (?,?)", nativeQuery = true)
    void insertIntoAuthoritiesTable(String username, String role);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM authorities a WHERE a.username =:username", nativeQuery = true)
    void deleteFromAuthoritiesTable(@Param("username") String username);
}
