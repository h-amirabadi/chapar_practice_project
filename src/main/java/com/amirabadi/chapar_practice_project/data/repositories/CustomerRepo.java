package com.amirabadi.chapar_practice_project.data.repositories;

import com.amirabadi.chapar_practice_project.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepo extends JpaRepository<Customer, UUID> {
}
