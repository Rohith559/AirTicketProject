package com.log.pp2.service;

import com.log.pp2.entity.CustomerRegistration;
import org.springframework.http.ResponseEntity;

public interface CusRegisService {
    String createCustomer(CustomerRegistration customerdetilas);
    boolean login(String email , String password);
    ResponseEntity<Object> getAllCustomers();

}
