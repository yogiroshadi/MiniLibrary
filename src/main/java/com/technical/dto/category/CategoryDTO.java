package com.technical.dto.category;

import com.technical.entity.Category;

import javax.persistence.Column;

public class CategoryDTO {

    private Integer id;
    private String category;

    public CategoryDTO(Integer id, String category) {
        this.id = id;
        this.category = category;
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.category = category.getCategory();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
