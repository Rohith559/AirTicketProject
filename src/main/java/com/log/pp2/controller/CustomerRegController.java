package com.log.pp2.controller;

import com.log.pp2.entity.CustomerRegistration;
import com.log.pp2.service.CusRegisService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-api")
public class CustomerRegController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRegController.class);

    private final CusRegisService cusRegisService;

    public CustomerRegController(CusRegisService cusRegisService){
        this.cusRegisService = cusRegisService;
    }

    @PostMapping(path = "/cusdetails")
    public String createCustomer(@RequestBody @Valid CustomerRegistration cusdeatils){
        logger.info("Registering New Customer");
        return  cusRegisService.createCustomer(cusdeatils);
    }

    @PostMapping(path ="/login")
    public boolean login(@RequestParam("email")String email ,@RequestParam("password")String password)
    {
        logger.info("Logging in with the help of email and password");
        return cusRegisService.login(email,password);
    }

    @GetMapping(path="/allFlights")
    public ResponseEntity<Object> getAllCustomers(){
        logger.info("To get all customer deatils");
        return  cusRegisService.getAllCustomers();
    }
}
