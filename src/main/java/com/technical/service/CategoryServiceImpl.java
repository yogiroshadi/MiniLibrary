package com.technical.service;

import com.technical.customerror.NotFoundException;
import com.technical.dto.category.CategoryDTO;
import com.technical.dto.category.InsertCategoryDTO;
import com.technical.entity.Category;
import com.technical.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> listCategoryDTO() {
        List<Category> categoryList = categoryRepository.findAll();

        List<CategoryDTO> categoryDTOS = categoryList.stream()
                .map(x -> new CategoryDTO(x))
                .collect(Collectors.toList());

        return categoryDTOS;
    }

    @Override
    public Category insertCategory(InsertCategoryDTO dto) {

        Category newCategory = new Category(
                dto.getCategory()
        );

        Category insertedCategory = categoryRepository.save(newCategory);

        return insertedCategory;

    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category category = categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new NotFoundException("Category didnt exist!"));


        categoryRepository.delete(category);
    }

    @Override
    public Category updateCategory(Integer categoryId, InsertCategoryDTO dto) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category didnt exist!"));

        category.setCategory(dto.getCategory());

        Category updatedCategory = categoryRepository.save(category);

        return updatedCategory;

    }
}
