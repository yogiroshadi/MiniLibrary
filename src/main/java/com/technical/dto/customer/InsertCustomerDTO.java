package com.technical.dto.customer;

import javax.persistence.Column;

public class InsertCustomerDTO {

    private String username;

    private String name;

    private String email;

    private String password;

    private String passwordConfirmation;

    public InsertCustomerDTO() {
    }

    public InsertCustomerDTO(String username, String name, String email, String password, String passwordConfirmation) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
