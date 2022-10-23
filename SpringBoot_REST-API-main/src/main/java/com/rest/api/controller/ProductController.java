package com.rest.api.controller;

import com.rest.api.entity.Product;
import com.rest.api.service.impl.ProductServiceImpl;
import com.rest.api.utils.request.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductServiceImpl service;

    @Autowired
    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getProducts() {

        return new ResponseEntity<List<ProductDTO>>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getSingleProduct(@PathVariable("id") int id) {

        return new ResponseEntity<ProductDTO>(service.getProductWithId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSingleProduct(@PathVariable("id") int id) {
        service.deleteProductById(id);
    }

    @DeleteMapping("/categories/{category_id}")
    public void deleteCategoryProduct(@PathVariable("category_id") int category_id) {
        service.deleteProductByCategoryId(category_id);
    }

    @PutMapping("/{id}/category/{category_id}")
    public ResponseEntity<ProductDTO> modifyExistingProduct(@PathVariable("id") int id,
                                                            @PathVariable("category_id") int category_id, @RequestBody Product product) {

        return new ResponseEntity<ProductDTO>(service.modifyProduct(product, id, category_id), HttpStatus.CREATED);
    }

    @PostMapping("/category/{category_id}")
    public ResponseEntity<ProductDTO> addProduct(@PathVariable("category_id") int category_id,
                                                 @RequestBody Product product) {

        return new ResponseEntity<ProductDTO>(service.createNewProduct(product, category_id), HttpStatus.CREATED);
    }}