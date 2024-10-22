package com.amirabadi.chapar_practice_project.service;

import com.amirabadi.chapar_practice_project.data.dto.ProductDTO;
import com.amirabadi.chapar_practice_project.data.mapper.ProductMapper;
import com.amirabadi.chapar_practice_project.data.model.Product;
import com.amirabadi.chapar_practice_project.data.repositories.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Transactional
    public ProductDTO save(ProductDTO dto) {
        Product product = ProductMapper.toEntity(dto);
        product = productRepo.save(product);
        return ProductMapper.toDto(product);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        return productRepo.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return productRepo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
