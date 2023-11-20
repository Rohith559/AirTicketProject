package com.log.pp2.test;

import com.log.pp2.entity.CustomerRegistration;
import com.log.pp2.repository.CustomerRegisRepo;
import com.log.pp2.service.CusRegServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CusRegServiceImplTest {

    @Mock
    private CustomerRegisRepo cusRegRepo;

    @InjectMocks
    private CusRegServiceImpl cusRegService;

    @Test
    void createCustomerSuccess() {
        CustomerRegistration customerDetails = new CustomerRegistration();
        customerDetails.setEmail("rohith@example.com");

        when(cusRegRepo.existsByEmail(anyString())).thenReturn(false);


        String result = cusRegService.createCustomer(customerDetails);

        assertEquals("Successfully Registered Customer", result);
    }

    @Test
    void createCustomerEmailAlreadyExists() {

        CustomerRegistration customerDetails = new CustomerRegistration();
        customerDetails.setEmail("rohith@gmail.com");

        when(cusRegRepo.existsByEmail(anyString())).thenReturn(true);


        String result = cusRegService.createCustomer(customerDetails);


        assertEquals("The email has been registered already", result);
    }

    @Test
    void loginSuccess() {

        String email = "rohi@gmail.com";
        String password = "password";

        when(cusRegRepo.findByEmailAndPassword(anyString(), anyString())).thenReturn(Optional.of(new CustomerRegistration()));


        boolean result = cusRegService.login(email, password);


        assertTrue(result);
    }

    @Test
    void loginFailure() {

        String email = "ro@example.com";
        String password = "password";

        when(cusRegRepo.findByEmailAndPassword(anyString(), anyString())).thenReturn(Optional.empty());


        boolean result = cusRegService.login(email, password);

        assertFalse(result);
    }
}

