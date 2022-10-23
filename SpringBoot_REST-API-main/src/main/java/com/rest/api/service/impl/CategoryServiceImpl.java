package com.rest.api.service.impl;

import com.rest.api.Proxy.ProductServiceProxy;
import com.rest.api.entity.Category;
import com.rest.api.repository.CategoryRepository;
import com.rest.api.service.CategoryService;
import com.rest.api.utils.request.CategoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ProductServiceProxy productProxy;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductServiceProxy productProxy) {
        this.categoryRepository = categoryRepository;
        this.productProxy = productProxy;
    }

    @Override
    public List<CategoryDTO> getAllProducts() {

        List<CategoryDTO> categories = new ArrayList<CategoryDTO>();

        categoryRepository.findAll().forEach(category -> categories.add(category.toDTO()));

        return categories;
    }

    @Override
    public CategoryDTO getSingleCategory(long category_id) {
        return categoryRepository.findById(category_id).get().toDTO();
    }

    @Override
    public void deleteCategoryWithId(long category_id) {

        if (categoryRepository.existsById(category_id)) {
            productProxy.deleteCategoryProduct(category_id);
            //then delete category
        }
        //otherwise throw exception

        categoryRepository.deleteById(category_id);
    }

    @Override
    public CategoryDTO addCategory(Category category) {
        return categoryRepository.save(category).toDTO();
    }

    @Override
    public CategoryDTO modifyCategoryWithId(Category category, long category_id) {

        if (categoryRepository.existsById(category_id)) {
            category.setId(category_id);

            return categoryRepository.save(category).toDTO();
        }

        //if category does not exist
        //throw an exception
        return categoryRepository.save(category).toDTO();
    }
}
