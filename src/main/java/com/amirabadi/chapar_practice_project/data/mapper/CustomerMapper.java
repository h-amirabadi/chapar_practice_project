package com.amirabadi.chapar_practice_project.data.mapper;

import com.amirabadi.chapar_practice_project.data.dto.CustomerDTO;
import com.amirabadi.chapar_practice_project.data.model.Customer;

public class CustomerMapper {

    public static CustomerDTO toDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setEmail(customer.getEmail());
        dto.setFirstname(customer.getFirstname());
        dto.setLastname(customer.getLastname());
        dto.setDescription(customer.getDescription());
        return dto;
    }

    public static Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setEmail(dto.getEmail());
        customer.setFirstname(dto.getFirstname());
        customer.setLastname(dto.getLastname());
        customer.setDescription(dto.getDescription());
        return customer;
    }
}
