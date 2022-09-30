package com.technical.token;

public class RequestTokenDTO {

    private String username;
    private String password;
    private String subject;

    public RequestTokenDTO() {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "RequestTokenDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
