package com.technical.entity.lentdetail;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@SuppressWarnings("Serial")
public class LentDetailKey implements Serializable {
    @Column(name = "BookId")
    private Integer bookId;

    @Column(name = "LentId")
    private Integer lentId;

    public LentDetailKey() {
    }

    public LentDetailKey(Integer bookId, Integer lentId) {
        this.bookId = bookId;
        this.lentId = lentId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getLentId() {
        return lentId;
    }

    public void setLentId(Integer lentId) {
        this.lentId = lentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LentDetailKey that = (LentDetailKey) o;
        return bookId.equals(that.bookId) && lentId.equals(that.lentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, lentId);
    }

    @Override
    public String toString() {
        return "LentDetailKey{" +
                "bookId=" + bookId +
                ", lentId=" + lentId +
                '}';
    }
}
