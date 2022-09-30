package com.technical.service;

import com.technical.dto.lenttransaction.InsertLentTransactionDTO;
import com.technical.entity.LentTransaction;

public interface LentTransactionService {
    LentTransaction insertLentTransaction(InsertLentTransactionDTO dto);

    LentTransaction updateStatus(String username);
}
