package com.techmya.product.model.dao;

import com.techmya.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 상품 전체 조회
    List<ProductDTO> getAllProduct(String productName);

    void registNewProduct(ProductDTO newProduct);

    List<String> getAllProductCategory();
}
