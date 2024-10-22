package com.amirabadi.chapar_practice_project.controller;


import com.amirabadi.chapar_practice_project.data.dto.CustomerDTO;
import com.amirabadi.chapar_practice_project.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.delete;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

//    @Autowired
    private final MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    public CustomerControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void testCreateCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail("test@example.com");
        customerDTO.setFirstname("John");
        customerDTO.setLastname("Doe");

        when(customerService.save(any(CustomerDTO.class))).thenReturn(customerDTO);

        /*mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@example.com\", \"firstname\":\"John\", \"lastname\":\"Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.firstname").value("John"))
                .andExpect(jsonPath("$.lastname").value("Doe"));*/
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        List<CustomerDTO> customerList = new ArrayList<>();
        customerList.add(new CustomerDTO(UUID.randomUUID(), "test@example.com", "John", "Doe", "Customer description"));

        when(customerService.findAll()).thenReturn(customerList);

        /*mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("test@example.com"))
                .andExpect(jsonPath("$[0].firstname").value("John"));*/
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        UUID customerId = UUID.randomUUID();

      /*  mockMvc.perform(delete("/customers/" + customerId))
                .andExpect(status().isNoContent());*/

        verify(customerService, times(1)).delete(customerId);
    }
}
