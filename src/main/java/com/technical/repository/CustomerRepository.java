package com.technical.repository;

import com.technical.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = """
            SELECT *
            FROM Customer
            WHERE Username = :usernameCustomer
            """,nativeQuery = true)
    Optional<Customer> findByUsername(@Param("usernameCustomer") String usernameCustomer);
}
