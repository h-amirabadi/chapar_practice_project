package com.amirabadi.chapar_practice_project.data.mapper;

import com.amirabadi.chapar_practice_project.data.dto.ProductDTO;
import com.amirabadi.chapar_practice_project.data.model.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }
}
