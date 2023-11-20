package com.log.pp2.repository;

import com.log.pp2.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRegisRepo extends JpaRepository<CustomerRegistration,Integer> {
    Optional<CustomerRegistration> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);

    CustomerRegistration findById(int customerNumber);
}
