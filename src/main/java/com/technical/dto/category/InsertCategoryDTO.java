package com.technical.dto.category;

public class InsertCategoryDTO {
    private String category;

    public InsertCategoryDTO() {
    }

    public InsertCategoryDTO(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
