package com.rest.api.Proxy;


import com.rest.api.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryFeignProxy {

        @GetMapping("/api/category/{category_id}")
        public ResponseEntity<Category> getSingleCategory(@PathVariable("category_id") long category_id);
    }

