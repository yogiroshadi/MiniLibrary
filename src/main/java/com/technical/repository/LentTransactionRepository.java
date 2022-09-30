package com.technical.repository;

import com.technical.entity.LentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LentTransactionRepository extends JpaRepository<LentTransaction, Integer> {

    @Query(value = """
            SELECT *
            FROM LentTransaction AS len
                JOIN LentDetail AS lenDet ON lenDet.LentId = len.Id
                JOIN Book AS boo ON boo.Id = lenDet.BookId
            WHERE len.CustomerId = :id
                AND len.isReturned = '0'
            """, nativeQuery = true)
    Optional<LentTransaction> findByCustomerIdReturnedFalse(Integer id);
}
