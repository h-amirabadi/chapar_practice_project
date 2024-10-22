package com.amirabadi.chapar_practice_project.service;


import com.amirabadi.chapar_practice_project.data.dto.CustomerDTO;
import com.amirabadi.chapar_practice_project.data.mapper.CustomerMapper;
import com.amirabadi.chapar_practice_project.data.model.Customer;
import com.amirabadi.chapar_practice_project.data.repositories.CustomerRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Transactional
    public CustomerDTO save(CustomerDTO dto) {
        Customer customer = CustomerMapper.toEntity(dto);
        customer = customerRepo.save(customer);
        return CustomerMapper.toDto(customer);
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll() {
        return customerRepo.findAll().stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(UUID id) {
        customerRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public CustomerDTO findById(UUID id) {
        return customerRepo.findById(id)
                .map(CustomerMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}

