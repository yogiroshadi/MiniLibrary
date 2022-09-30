package com.technical.service;

import com.technical.dto.book.BookDTO;
import com.technical.dto.book.InsertBookDTO;
import com.technical.entity.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Book insertBook(InsertBookDTO dto);

    Page<BookDTO> findAllBookDTO(Integer page, String category);

    Book updateBook(Integer bookId, InsertBookDTO dto);

    void deleteBook(Integer bookId);
}
