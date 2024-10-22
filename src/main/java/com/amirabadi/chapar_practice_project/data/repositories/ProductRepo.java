package com.amirabadi.chapar_practice_project.data.repositories;

import com.amirabadi.chapar_practice_project.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo  extends JpaRepository<Product, Long> {
}
