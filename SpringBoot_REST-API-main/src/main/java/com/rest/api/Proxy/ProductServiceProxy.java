package com.rest.api.Proxy;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface ProductServiceProxy {

    @DeleteMapping("/api/products/categories/{category_id}")
    public void deleteCategoryProduct(@PathVariable("category_id") long category_id);
}