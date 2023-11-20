package com.log.pp2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class CustomerRegistration {
    @Id
    @GeneratedValue(generator = "customer-sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer-sequence",allocationSize = 100, initialValue = 5000,sequenceName = "customer-sequence")
    private int customerId;
    @NotNull(message = "Give correct name as per ur ssn_type")
    private String customer_Name;
    @Email(message = "Give correct syntax of mail")
    private String email;
    @NotNull(message = "Password cannot be blank")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character")
    private String password;
    @Past(message = "DataOf Birth need to be past date")
    private Date dob;
    @NotNull(message = "SSN_type need to be Aadhaar or Pan")
    private String ssn_type;
    @NotNull(message = "Give correct ssn_no")
    private String ssn_no;


}
