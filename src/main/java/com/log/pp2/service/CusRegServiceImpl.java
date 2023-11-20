package com.log.pp2.service;

import com.log.pp2.entity.Booking;
import com.log.pp2.entity.CustomerRegistration;

import com.log.pp2.repository.CustomerRegisRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CusRegServiceImpl implements CusRegisService{
    private static final Logger logger = LoggerFactory.getLogger(CusRegServiceImpl.class);

    private final CustomerRegisRepo cusRegRepo;

    public  CusRegServiceImpl(CustomerRegisRepo cusRegRepo){
        this.cusRegRepo = cusRegRepo;
    }
    @Override
    public String createCustomer(CustomerRegistration customerdetilas) {
        if(cusRegRepo.existsByEmail(customerdetilas.getEmail())){
            logger.info("Try with some other email,this email id already exist");
            return "The email has been registered already";
        }
        else{
             cusRegRepo.save(customerdetilas);
             return "Successfully Registered Customer";
        }

    }

    public boolean login(String email , String password)
    {
        Optional<CustomerRegistration> customer = cusRegRepo.findByEmailAndPassword(email,password);
        return customer.isPresent();
    }

    @Override
    public ResponseEntity<Object> getAllCustomers() {
        List<CustomerRegistration> customers = cusRegRepo.findAll();
        if (customers.isEmpty()) {
            String msg = "No customer has been registered";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(customers);
        }
    }
}
