package com.yuphanie.ipanena.model;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
    private String username;

    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    private String password;
    private Integer enabled;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    public Account() {
    }
    public Account(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Account setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public Account setEnabled(Integer enabled) {
        this.enabled = enabled;
        return this;
    }
}
