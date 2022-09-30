package com.technical.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.technical.dto.book.BookDTO;
import com.technical.entity.lentdetail.LentDetail;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "BookName")
    private String bookName;
    @Column(name = "Writer")
    private String writer;
    @Column(name = "Publisher")
    private String publisher;
    @Column(name = "TotalBook")
    private Integer totalBook;

    @JsonIgnore
    @Column(name = "CategoryId")
    private Integer categoryId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CategoryId", insertable = false, updatable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LentDetail> lentDetails;

    public Book() {
    }

    public Book(String bookName, String writer, String publisher, Integer totalBook, Integer categoryId) {
        this.bookName = bookName;
        this.writer = writer;
        this.publisher = publisher;
        this.totalBook = totalBook;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(Integer totalBook) {
        this.totalBook = totalBook;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<LentDetail> getLentDetails() {
        return lentDetails;
    }

    public void addLentDetails(LentDetail lentDetail) {
        if (this.lentDetails == null) {
            this.lentDetails = new ArrayList<>();
        }

        this.lentDetails.add(lentDetail);
    }

}
