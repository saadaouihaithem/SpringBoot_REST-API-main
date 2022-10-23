package com.rest.api.controller;

import com.rest.api.entity.Category;
import com.rest.api.service.impl.CategoryServiceImpl;
import com.rest.api.utils.request.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryServiceImpl service;

    @Autowired
    public CategoryController(CategoryServiceImpl service) {

        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getCategories() {

        return new ResponseEntity<List<CategoryDTO>>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryDTO> getSingleCategory(@PathVariable("category_id")int  categoryid) {

        return new ResponseEntity<CategoryDTO>(service.getSingleCategory(categoryid), HttpStatus.OK);
    }

    @DeleteMapping("/{category_id}")
    public ResponseEntity<Object> deleteCategoryWithId(@PathVariable("category_id") int category_id) {

        service.deleteCategoryWithId(category_id);

        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> addNewCategory(@RequestBody Category category) {

        return new ResponseEntity<CategoryDTO>(service.addCategory(category), HttpStatus.CREATED);
    }

    @PutMapping("/{categoryid}")
    public ResponseEntity<CategoryDTO> modifyExistingCategory(@RequestBody Category category,
                                                              @PathVariable("category_id") int category_id) {

        return new ResponseEntity<CategoryDTO>(service.modifyCategoryWithId(category, category_id), HttpStatus.CREATED);
    }}