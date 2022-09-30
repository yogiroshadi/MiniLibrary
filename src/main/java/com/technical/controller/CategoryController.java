package com.technical.controller;

import com.technical.dto.category.CategoryDTO;
import com.technical.dto.category.InsertCategoryDTO;
import com.technical.entity.Category;
import com.technical.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> listCategory() {

        List<CategoryDTO> categoryList = categoryService.listCategoryDTO();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<Category> insertCategory(@RequestBody InsertCategoryDTO dto) {

        Category insertedCategory = categoryService.insertCategory(dto);

        return new ResponseEntity<>(insertedCategory, HttpStatus.OK);
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer categoryId,
                                                   @RequestBody InsertCategoryDTO dto) {

        Category updatedCategory = categoryService.updateCategory(categoryId, dto);

        return new ResponseEntity<>(updatedCategory, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable Integer categoryId) {

        categoryService.deleteCategory(categoryId);

        return "Delete Success";
    }
}
