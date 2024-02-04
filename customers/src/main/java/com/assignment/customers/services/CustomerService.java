package com.assignment.customers.services;
import com.assignment.customers.model.Customer;
import com.assignment.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update an existing customer
    public Customer updateCustomer(Long customerId, Customer customerDetails) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            customer.setFirstName(customerDetails.getFirstName());
            customer.setLastName(customerDetails.getLastName());
            customer.setStreet(customerDetails.getStreet());
            customer.setAddress(customerDetails.getAddress());
            customer.setCity(customerDetails.getCity());
            customer.setState(customerDetails.getState());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhone(customerDetails.getPhone());
            return customerRepository.save(customer);
        }
        return null;
    }

    // Delete a customer
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    // Get a single customer by ID
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    // Get a list of customers with pagination, sorting, and searching
    public List<Customer> getAllCustomers(int page, int size, String sortBy, String keyword) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customerPage;
        if (keyword != null && !keyword.isEmpty()) {
            customerPage = customerRepository.findByKeyword(keyword, pageable);
        } else {
            customerPage = customerRepository.findAll(pageable);
        }
        return customerPage.getContent();
    }
}