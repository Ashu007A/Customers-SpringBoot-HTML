package com.assignment.customers.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncScheduler {

    private final CustomerSyncService customerSyncService;

    public SyncScheduler(CustomerSyncService customerSyncService) {
        this.customerSyncService = customerSyncService;
    }

    @Scheduled(fixedRate = 3600000) // Run every hour (3600000 milliseconds)
    public void syncCustomersRegularly() {
        customerSyncService.syncCustomers();
    }
}
