package com.technical.repository;

import com.technical.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = """
            SELECT *
            FROM Role as ro
            WHERE ro.roleName = :role
            """, nativeQuery = true)
    Optional<Role> findByRole(@Param("role") String role);
}
