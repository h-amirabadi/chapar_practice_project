package com.amirabadi.chapar_practice_project.controller;

import com.amirabadi.chapar_practice_project.data.dto.CustomerDTO;
import com.amirabadi.chapar_practice_project.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("hossein.amiri@gamail.com");
        customerDTO.setFirstname("Hossein");
        customerDTO.setLastname("Amiri");

//        when(customerService.save(any(CustomerDTO.class))).thenReturn(customerDTO);

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("hossein.amiri@gamail.com"))
                .andExpect(jsonPath("$.firstname").value("Hossein"))
                .andExpect(jsonPath("$.lastname").value("Amiri"));
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        List<CustomerDTO> customerList = new ArrayList<>();
        customerList.add(new CustomerDTO(UUID.randomUUID(), "hossein.amiri@gamail.com", "Hossein", "Amiri", "Hossein Amiri Customer description"));

        when(customerService.findAll()).thenReturn(customerList);

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("hossein.amiri@gamail.com"))
                .andExpect(jsonPath("$[0].firstname").value("Hossein"));
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("hossein.amiri@gamail.com");
        customerDTO.setFirstname("Hossein");
        customerDTO.setLastname("Amiri");

        customerDTO = customerService.save(customerDTO);

        mockMvc.perform(delete("/customers/" + customerDTO.getId()))
                .andExpect(status().isNoContent());

    }
}
