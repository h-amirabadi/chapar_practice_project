package com.amirabadi.chapar_practice_project.repository;

import com.amirabadi.chapar_practice_project.data.model.Customer;
import com.amirabadi.chapar_practice_project.data.repositories.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepo customerRepository;


    @Test
    public void testSaveAndFindAllCustomer() {
        Customer customer = new Customer();
        customer.setEmail("hossein.amiri@gamail.com");
        customer.setFirstname("Hossein");
        customer.setLastname("Amiri");

        customerRepository.save(customer);

        List<Customer> costumers = customerRepository.findAll();
        assertEquals(1, costumers.size());
    }
}
