package com.technical.controller;

import com.technical.dto.book.BookDTO;
import com.technical.dto.book.InsertBookDTO;
import com.technical.entity.Book;
import com.technical.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<Page<BookDTO>> listBookDTO(@RequestParam(defaultValue = "1")Integer page,
                                                     @RequestParam(defaultValue ="")String category) {

        Page<BookDTO> gridBookDTO = bookService.findAllBookDTO(page, category);

        return new ResponseEntity<>(gridBookDTO, HttpStatus.OK);

    }

    @PostMapping("/insert")
    public ResponseEntity<Book> registerBook(@RequestBody InsertBookDTO dto) {

        Book insertedBook = bookService.insertBook(dto);

        return new ResponseEntity<>(insertedBook, HttpStatus.CREATED);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer bookId,
                                           @RequestBody InsertBookDTO dto) {

        Book insertedBook = bookService.updateBook(bookId,dto);

        return new ResponseEntity<>(insertedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Integer bookId) {

        bookService.deleteBook(bookId);

        return "Delete Success!";
    }
}
