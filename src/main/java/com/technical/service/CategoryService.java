package com.technical.service;

import com.technical.dto.category.CategoryDTO;
import com.technical.dto.category.InsertCategoryDTO;
import com.technical.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> listCategoryDTO();

    Category insertCategory(InsertCategoryDTO dto);

    void deleteCategory(Integer categoryId);

    Category updateCategory(Integer categoryId, InsertCategoryDTO dto);
}
