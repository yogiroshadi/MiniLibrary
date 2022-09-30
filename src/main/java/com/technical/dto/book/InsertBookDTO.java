package com.technical.dto.book;

import javax.persistence.Column;

public class InsertBookDTO {

    private String bookName;
    private String writer;
    private String publisher;
    private Integer totalBook;
    private String category;

    public InsertBookDTO(String bookName, String writer, String publisher, Integer totalBook, String category) {
        this.bookName = bookName;
        this.writer = writer;
        this.publisher = publisher;
        this.totalBook = totalBook;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "InsertBookDTO{" +
                "bookName='" + bookName + '\'' +
                ", writer='" + writer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", totalBook=" + totalBook +
                ", category='" + category + '\'' +
                '}';
    }
}
