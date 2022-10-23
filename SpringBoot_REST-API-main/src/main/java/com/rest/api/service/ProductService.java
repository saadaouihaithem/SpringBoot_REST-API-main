package com.rest.api.service;


import com.rest.api.entity.Product;
import com.rest.api.utils.request.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO createNewProduct(Product product, long category_id);

    ProductDTO getProductWithId(long id);

    void deleteProductById(long id);

    ProductDTO saveProduct(Product product, long category_id);

    ProductDTO modifyProduct(Product product, long id, long category_id);

    void deleteProductByCategoryId(long category_id);
}
