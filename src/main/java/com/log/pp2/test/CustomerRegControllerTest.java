package com.log.pp2.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.log.pp2.controller.CustomerRegController;
import com.log.pp2.entity.CustomerRegistration;
import com.log.pp2.service.CusRegisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerRegController.class)
class CustomerRegControllerTest {

    @MockBean
    public CusRegisService cusRegisService;

    @Autowired
    MockMvc mockMvc;


    @Test
    void createCustomer() throws Exception {

        CustomerRegistration customerRegistration = new CustomerRegistration();
        customerRegistration.setCustomerId(5001);
        customerRegistration.setCustomer_Name("Rohith");
        customerRegistration.setEmail("rohith@123gmail.com");
        customerRegistration.setPassword("Rohith@123");
        customerRegistration.setDob(Date.valueOf("2001-04-09"));
        customerRegistration.setSsn_type("Aadhaar");
        customerRegistration.setSsn_no("907340");

        when(cusRegisService.createCustomer(any(CustomerRegistration.class))).thenReturn("Registration successful");


        ResultActions resultActions = mockMvc.perform(post("/customer-api/cusdetails")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(customerRegistration)));

        resultActions.andExpect(status().isOk());
    }

    @Test
    void login() throws Exception {

        String email = "rohi@123gmail.com";
        String password = "Rohi@123";

        when(cusRegisService.login(email, password)).thenReturn(true);

        ResultActions resultActions = mockMvc.perform(post("/customer-api/login")
                .param("email", email)
                .param("password", password));

        resultActions.andExpect(status().isOk());
    }

}

