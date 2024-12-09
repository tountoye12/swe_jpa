package com.diallo.exo1.service;

import com.diallo.exo1.entity.Customer;
import com.diallo.exo1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
