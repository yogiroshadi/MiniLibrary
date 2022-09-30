package com.technical.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technical.entity.lentdetail.LentDetail;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "LentTransaction")
public class LentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "StartDate")
    private LocalDate startDate;
    @Column(name = "DueDate")
    private LocalDate dueDate;
    @Column(name = "isReturned")
    private Boolean isReturned;

    @Column(name = "CustomerId")
    private Integer customerId;
    @ManyToOne
    @JoinColumn(name = "CustomerId", insertable = false, updatable = false)
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "lentTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LentDetail> lentDetails;

    public LentTransaction() {
    }

    public LentTransaction(LocalDate startDate, LocalDate dueDate, Integer customerId) {
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.customerId = customerId;
    }

    public LentTransaction(LocalDate startDate, LocalDate dueDate, Boolean isReturned, Integer customerId) {
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.isReturned = isReturned;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<LentDetail> getLentDetails() {
        return lentDetails;
    }

    public void setLentDetails(List<LentDetail> lentDetails) {
        this.lentDetails = lentDetails;
    }

    public Boolean getReturned() {
        return isReturned;
    }

    public void setReturned(Boolean returned) {
        isReturned = returned;
    }

    @Override
    public String toString() {
        return "LentTransaction{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", isReturned=" + isReturned +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", lentDetails=" + lentDetails +
                '}';
    }
}
