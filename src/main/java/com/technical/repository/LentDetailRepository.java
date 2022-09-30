package com.technical.repository;

import com.technical.entity.lentdetail.LentDetail;
import com.technical.entity.lentdetail.LentDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LentDetailRepository extends JpaRepository<LentDetail, LentDetailKey> {

    @Query(value = """
            SELECT *
            FROM LentDetail as len
            WHERE len.LentId = :lentTransactionId
                AND len.BookId = :bookId
            """, nativeQuery = true)
    Optional<LentDetail> findByLentIdAndBookId(Integer lentTransactionId, Integer bookId);
}
