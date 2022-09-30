package com.technical.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;

    @Column(name = "Username")
    private String username;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "Username", insertable = false, updatable = false)
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<LentTransaction> lentTransactions;

    public Customer() {
    }

    public Customer(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<LentTransaction> getLentTransactions() {
        return lentTransactions;
    }

    public void addLentTransaction(LentTransaction lentTransaction) {
        if (this.lentTransactions.isEmpty()) {
            this.lentTransactions = new ArrayList<>();
        }

        this.lentTransactions.add(lentTransaction);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
