package com.technical.controller;

import com.technical.dto.lenttransaction.InsertLentTransactionDTO;
import com.technical.entity.LentTransaction;
import com.technical.service.LentTransactionService;
import com.technical.utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lent")
public class LentTransactionController {

    @Autowired
    private LentTransactionService lentTransactionService;

    @Autowired
    private JwtToken jwtToken;

    @PostMapping("/insert")
    public ResponseEntity<LentTransaction> lentBook(@RequestHeader("Authorization") String authorization,
                                                    @RequestBody InsertLentTransactionDTO dto) {

        String token = authorization.replace("Bearer", "");

        String username = jwtToken.getUsername(token);
        dto.setUsernameCustomer(username);
        LentTransaction insertedTransaction = lentTransactionService.insertLentTransaction(dto);

        return new ResponseEntity<>(insertedTransaction, HttpStatus.OK);
    }

    @PostMapping("/updateStatus")
    public ResponseEntity<LentTransaction> updateStatus(@RequestParam String username) {

        LentTransaction updatedTransaction = lentTransactionService.updateStatus(username);

        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }
}

