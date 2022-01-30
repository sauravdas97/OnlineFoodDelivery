package com.foodDelivery.customer.service;

import com.foodDelivery.customer.entity.Customer;
import com.foodDelivery.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

//    POST request to add one customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

//    GET request to get all customers from DB
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }
//    GET request to find customer by id
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
