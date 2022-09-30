package com.technical.service;

import com.technical.customerror.NotFoundException;
import com.technical.dto.lenttransaction.InsertLentTransactionDTO;
import com.technical.entity.Book;
import com.technical.entity.Customer;
import com.technical.entity.LentTransaction;
import com.technical.entity.lentdetail.LentDetail;
import com.technical.repository.BookRepository;
import com.technical.repository.CustomerRepository;
import com.technical.repository.LentDetailRepository;
import com.technical.repository.LentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LentTransactionServiceImpl implements LentTransactionService{

    @Autowired
    private LentTransactionRepository lentTransactionRepository;

    @Autowired
    private LentDetailRepository lentDetailRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public LentTransaction insertLentTransaction(InsertLentTransactionDTO dto) {

        Customer customer = customerRepository.findByUsername(dto.getUsernameCustomer())
                .orElseThrow(() -> new NotFoundException(
                        "Customer with username " + dto.getUsernameCustomer() + "not exist!"));

        Book book = bookRepository.findBybookName(dto.getBookName())
                .orElseThrow(() -> new NotFoundException(
                        "Book with name " + dto.getBookName() + " is not exist!"));

        if (book.getTotalBook() <= 0) {
            throw new NotFoundException("No book available to rent!");
        } else {
            LentTransaction lentTransaction = new LentTransaction(
                    dto.getStartDate(),
                    dto.getDueDate(),
                    false,
                    customer.getId()
            );

            LentTransaction insertedLentTransaction = lentTransactionRepository.save(lentTransaction);


            LentDetail lentDetail = new LentDetail(
                    book,
                    insertedLentTransaction,
                    new BigDecimal(0)
            );

            lentDetailRepository.save(lentDetail);

            book.setTotalBook(book.getTotalBook() - 1);
            bookRepository.save(book);

            return insertedLentTransaction;
        }


    }

    @Override
    public LentTransaction updateStatus(String username) {

        Customer customer = customerRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(
                        "Customer with username " + username + "not exist!"));

        LentTransaction lentTransaction = lentTransactionRepository.findByCustomerIdReturnedFalse(customer.getId())
                .orElseThrow(()-> new NotFoundException("Lent Transaction didn't exist!"));

        lentTransaction.setReturned(true);

        LentTransaction updatedStatus = lentTransactionRepository.save(lentTransaction);


        return updatedStatus;

    }
}
