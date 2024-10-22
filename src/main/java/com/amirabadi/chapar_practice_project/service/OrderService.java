package com.amirabadi.chapar_practice_project.service;

import com.amirabadi.chapar_practice_project.data.dto.OrderDTO;
import com.amirabadi.chapar_practice_project.data.mapper.OrderMapper;
import com.amirabadi.chapar_practice_project.data.model.Customer;
import com.amirabadi.chapar_practice_project.data.model.Order;
import com.amirabadi.chapar_practice_project.data.model.Product;
import com.amirabadi.chapar_practice_project.data.repositories.CustomerRepo;
import com.amirabadi.chapar_practice_project.data.repositories.OrderRepo;
import com.amirabadi.chapar_practice_project.data.repositories.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    private final CustomerRepo customerRepo;

    private final ProductRepo productRepo;

    public OrderService(OrderRepo orderRepo, CustomerRepo customerRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    @Transactional
    public OrderDTO save(OrderDTO dto) {
        Customer customer = customerRepo.findById(dto.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productRepo.findById(dto.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));

        Order order = OrderMapper.toEntity(dto, customer, product);
        order = orderRepo.save(order);
        return OrderMapper.toDto(order);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        return orderRepo.findAll().stream().map(OrderMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        return orderRepo.findById(id).map(OrderMapper::toDto).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
