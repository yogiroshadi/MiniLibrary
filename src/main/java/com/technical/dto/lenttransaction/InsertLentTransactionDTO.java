package com.technical.dto.lenttransaction;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

public class InsertLentTransactionDTO {

    private String usernameCustomer;
    private String bookName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    public InsertLentTransactionDTO(String bookName, LocalDate startDate, LocalDate dueDate) {
        this.bookName = bookName;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public String getUsernameCustomer() {
        return usernameCustomer;
    }

    public void setUsernameCustomer(String usernameCustomer) {
        this.usernameCustomer = usernameCustomer;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "InsertLentTransactionDTO{" +
                "usernameCustomer='" + usernameCustomer + '\'' +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
