package com.technical.entity.lentdetail;

import com.technical.entity.Book;
import com.technical.entity.LentTransaction;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "LentDetail")
public class LentDetail {

    @EmbeddedId
    private LentDetailKey id = new LentDetailKey();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "BookId")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("lentId")
    @JoinColumn(name = "LentId")
    private LentTransaction lentTransaction;

    @Column(name = "OverdueCost")
    private BigDecimal overdueCost;

    public LentDetail() {
    }


    public LentDetail(LentDetailKey id, BigDecimal overdueCost) {
        this.id = id;
        this.overdueCost = overdueCost;
    }

    public LentDetail(Book book, LentTransaction lentTransaction, BigDecimal overdueCost) {
        this.book = book;
        this.lentTransaction = lentTransaction;
        this.overdueCost = overdueCost;
    }

    public LentDetailKey getId() {
        return id;
    }

    public void setId(LentDetailKey id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LentTransaction getLentTransaction() {
        return lentTransaction;
    }

    public void setLentTransaction(LentTransaction lentTransaction) {
        this.lentTransaction = lentTransaction;
    }

    public BigDecimal getOverdueCost() {
        return overdueCost;
    }

    public void setOverdueCost(BigDecimal overdueCost) {
        this.overdueCost = overdueCost;
    }
}
