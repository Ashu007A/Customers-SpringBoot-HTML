package com.assignment.customers.services;

import com.assignment.customers.model.Customer;
import com.assignment.customers.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerSyncService {

    private final RemoteAPIService remoteAPIService;
    private final CustomerRepository customerRepository;

    public CustomerSyncService(RemoteAPIService remoteAPIService, CustomerRepository customerRepository) {
        this.remoteAPIService = remoteAPIService;
        this.customerRepository = customerRepository;
    }

    public void syncCustomers() {
        Customer[] remoteCustomers = remoteAPIService.fetchCustomersFromRemoteAPI();
        for (Customer remoteCustomer : remoteCustomers) {
            Customer localCustomer = customerRepository.findByUuid(remoteCustomer.getUuid());
            if (localCustomer != null) {
                // Customer exists locally, update it
                localCustomer.setFirstName(remoteCustomer.getFirstName());
                localCustomer.setLastName(remoteCustomer.getLastName());
                localCustomer.setEmail(remoteCustomer.getEmail());
                localCustomer.setPhone(remoteCustomer.getPhone());
                // Update any other fields as needed
                customerRepository.save(localCustomer);
            } else {
                // Customer does not exist locally, insert it
                customerRepository.save(remoteCustomer);
            }
        }
    }
}