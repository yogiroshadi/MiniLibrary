package com.technical.repository;

import com.technical.dto.book.BookDTO;
import com.technical.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = """
            SELECT boo.Id AS id, boo.BookName AS bookName,
                    boo.Publisher AS publisher, boo.Writer AS writer,
                    boo.TotalBook AS totalBook, cat.CategoryName AS categoryName
                FROM Book AS boo
                    JOIN Category AS cat ON boo.CategoryId = cat.Id
                    WHERE cat.CategoryName LIKE CONCAT('%', :category , '%')
            """,
            countQuery = """
            SELECT COUNT(boo.id)
            FROM Book AS boo
                JOIN Category AS cat ON boo.CategoryId = cat.Id
                WHERE cat.CategoryName LIKE CONCAT('%', :category , '%')
            """,nativeQuery = true)
    Page<BookDTO> findAllBookDTO(@Param("category") String category, Pageable pagination);

    Optional<Book> findBybookName(String bookName);
}
