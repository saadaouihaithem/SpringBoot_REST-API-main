package com.rest.api.service.impl;




import com.rest.api.Proxy.CategoryFeignProxy;
import com.rest.api.entity.Category;
import com.rest.api.entity.Product;
import com.rest.api.repository.ProductRepository;
import com.rest.api.service.ProductService;
import com.rest.api.utils.request.ProductDTO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl  implements ProductService {

    private ProductRepository productRepository;
    private CategoryFeignProxy categoryProxy;

    public ProductServiceImpl(ProductRepository productRepository, CategoryFeignProxy categoryProxy) {
        this.productRepository = productRepository;
        this.categoryProxy = categoryProxy;
    }


    @Override
    public List<ProductDTO> getAllProducts() {

        List<ProductDTO> rawList = new ArrayList<ProductDTO>();
        productRepository.findAll()
                .forEach(product -> {
                    ProductDTO result = product.toDTO();
                    result.setCategory(categoryProxy.getSingleCategory(product.getCategory_id()).getBody());
                    rawList.add(result);
                });
        return rawList;
    }


    @Override
    public ProductDTO getProductWithId(long id) {
        Product product = productRepository.findById(id).get();
        ProductDTO result = product.toDTO();

        result.setCategory(categoryProxy.getSingleCategory(product.getCategory_id()).getBody());

        return result;
    }


    @Override
    public void deleteProductById(long id) {

        productRepository.deleteById(id);
    }


    @Override
    public ProductDTO saveProduct(Product product, long category_id) {

//		//verify that the specified category exists by calling the category api
//		//if exists, set the category id for the product
//		product.setCategoryId(categoryid);
//
//		//if category is not found, exception is thrown from category service
//		return productRepository.save(product).toDTO();
        return null;
    }


    @Override
    public ProductDTO modifyProduct(Product product,long id, long category_id) {

        if (productRepository.existsById(id)) {

            //verify that the category as well exists
            Category category = categoryProxy.getSingleCategory(category_id).getBody();
            if (category == null) {
                //throw an exception
            }
            //then save the product if the category exists
            product.setId(id);
            product.setCategory_id((category.getId()));

            ProductDTO result = productRepository.save(product).toDTO();
            result.setCategory(category);
            return result;
        }
        //if not found, throw exception
        return null;
    }


    @Override
    public ProductDTO createNewProduct(Product product, long category_id) {
        Category category = categoryProxy.getSingleCategory(category_id).getBody();

        if (category == null) {
            //throw exception
        }

        product.setCategory_id((category.getId()));

        ProductDTO result = productRepository.save(product).toDTO();
        result.setCategory(category);
        return result;
    }


    @Override
    public void deleteProductByCategoryId(long category_id) {
        List<Product> products = productRepository.findBycategory_id(category_id);

        products.forEach(product -> {
            productRepository.deleteById(product.getId());
        });
    }
}