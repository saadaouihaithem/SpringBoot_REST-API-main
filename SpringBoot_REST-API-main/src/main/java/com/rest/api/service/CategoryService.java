package com.rest.api.service;

import com.rest.api.entity.Category;
import com.rest.api.utils.request.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllProducts();

    CategoryDTO getSingleCategory(long category_id);

    void deleteCategoryWithId(long category_id);

    CategoryDTO addCategory(Category category);

    CategoryDTO modifyCategoryWithId(Category category, long category_id);

}