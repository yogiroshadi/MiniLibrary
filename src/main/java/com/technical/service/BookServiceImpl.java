package com.technical.service;

import com.technical.customerror.NotFoundException;
import com.technical.dto.book.BookDTO;
import com.technical.dto.book.InsertBookDTO;
import com.technical.entity.Book;
import com.technical.entity.Category;
import com.technical.repository.BookRepository;
import com.technical.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private final Integer rowsInPage = 2;

    @Override
    public Book insertBook(InsertBookDTO dto) {

        Category category = categoryRepository
                .findCategoryByCategoryName(dto.getCategory())
                .orElseThrow(()-> new NotFoundException("Category with name " + dto.getCategory() + " is not exist!"));

        Book newBook = new Book(
                dto.getBookName(),
                dto.getWriter(),
                dto.getPublisher(),
                dto.getTotalBook(),
                category.getId()
        );

        return bookRepository.save(newBook);

    }

    @Override
    public Page<BookDTO> findAllBookDTO(Integer page, String category) {

        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));

        Page<BookDTO> listBookDTO = bookRepository.findAllBookDTO(category, pagination);

        return listBookDTO;
    }

    @Override
    public Book updateBook(Integer bookId, InsertBookDTO dto) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book didn't exist!"));

        Category category = categoryRepository.findCategoryByCategoryName(dto.getCategory())
                .orElseThrow(() -> new NotFoundException("Category didn't exist!"));

        book.setBookName(dto.getBookName());
        book.setCategoryId(category.getId());
        book.setWriter(dto.getWriter());
        book.setPublisher(dto.getPublisher());
        book.setTotalBook(dto.getTotalBook());

        Book updatedBook = bookRepository.save(book);

        return updatedBook;
    }

    @Override
    public void deleteBook(Integer bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new NotFoundException("Book didn't exist!"));

        bookRepository.delete(book);
    }
}
