package com.technical.controller;

import com.technical.dto.customer.InsertCustomerDTO;
import com.technical.dto.customer.UpdateCustomerDTO;
import com.technical.entity.Customer;
import com.technical.service.CustomerService;
import com.technical.utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JwtToken jwtToken;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody InsertCustomerDTO dto) {

        Customer registeredCustomer = customerService.registerCustomer(dto);

        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestHeader("Authorization")String bearer,
                                                   @RequestBody UpdateCustomerDTO dto) {

        String token = bearer.replace("Bearer", "");

        String username = jwtToken.getUsername(token);

        Customer updatedCustomer = customerService.updateCustomer(username, dto);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);

    }
}
