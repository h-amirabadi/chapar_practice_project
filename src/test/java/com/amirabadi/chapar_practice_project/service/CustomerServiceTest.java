package com.amirabadi.chapar_practice_project.service;

import com.amirabadi.chapar_practice_project.controller.CustomerController;
import com.amirabadi.chapar_practice_project.data.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

@WebMvcTest(CustomerController.class)
public class CustomerServiceTest {

    @MockBean
    private CustomerService customerService;


    @Test
    public void testCreateCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("hossein.amiri@gamail.com");
        customerDTO.setFirstname("Hossein");
        customerDTO.setLastname("Amiri");

        when(customerService.save(any(CustomerDTO.class))).thenReturn(customerDTO);

    }

    @Test
    public void testGetAllCustomers() {
        List<CustomerDTO> customerList = new ArrayList<>();
        customerList.add(new CustomerDTO(UUID.randomUUID(), "hossein.amiri@gamail.com", "Hossein", "Amiri", "Hossein Amiri Customer description"));

        when(customerService.findAll()).thenReturn(customerList);
    }

    @Test
    public void testDeleteCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("hossein.amiri@gamail.com");
        customerDTO.setFirstname("Hossein");
        customerDTO.setLastname("Amiri");

        customerDTO = customerService.save(customerDTO);

        verify(customerService, times(1)).delete(customerDTO.getId());
    }
}
