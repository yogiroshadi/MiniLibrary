package com.technical.repository;

import com.technical.dto.category.CategoryDTO;
import com.technical.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


    @Query(value = """
            SELECT *
            FROM Category
            WHERE categoryName = :categoryName
            """, nativeQuery = true)
    Optional<Category> findCategoryByCategoryName(@Param("categoryName") String category);
}
