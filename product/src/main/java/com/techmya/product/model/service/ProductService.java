package com.techmya.product.model.service;

import com.techmya.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct(String productName);

    void registNewProduct(ProductDTO newProduct);

    List<String> getAllProductCategory();
}
