package com.assignment.customers.services;

import com.assignment.customers.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteAPIService {

    @Value("${remote.api.url}")
    private String apiUrl;

    @Value("${remote.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate;

    public RemoteAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Customer[] fetchCustomersFromRemoteAPI() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Customer[]> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Customer[].class);
        return response.getBody();
    }
}