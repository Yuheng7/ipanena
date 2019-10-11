package com.yuphanie.ipanena.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
    private String username;
    private String email_address;
    private String password;
    private Integer enabled;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private String id;

    public Account() {
    }
    public Account(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public Account setId(String id) {
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

    public String getEmail_address() {
        return email_address;
    }

    public Account setEmail_address(String email_address) {
        this.email_address = email_address;
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
