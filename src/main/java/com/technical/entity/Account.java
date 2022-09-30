package com.technical.entity;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "RoleId")
    private Integer roleId;
    @ManyToOne
    @JoinColumn(name = "RoleId", insertable = false, updatable = false)
    private Role role;

    public Account() {
    }

    public Account(String username, String password, Integer roleId) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
