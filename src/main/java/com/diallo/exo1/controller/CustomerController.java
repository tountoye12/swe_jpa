package com.diallo.exo1.controller;


import com.diallo.exo1.entity.Customer;
import com.diallo.exo1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }
}
