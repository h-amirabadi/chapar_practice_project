package com.amirabadi.chapar_practice_project.data.mapper;

import com.amirabadi.chapar_practice_project.data.dto.OrderDTO;
import com.amirabadi.chapar_practice_project.data.model.Customer;
import com.amirabadi.chapar_practice_project.data.model.Order;
import com.amirabadi.chapar_practice_project.data.model.Product;

public class OrderMapper {

    public static OrderDTO toDto(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomer().getId());
        dto.setProductId(order.getProduct().getId());
        dto.setCount(order.getCount());
        return dto;
    }

    public static Order toEntity(OrderDTO dto, Customer customer, Product product) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setCount(dto.getCount());
        return order;
    }
}
