package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public class AuthServiceImpl implements AuthService {

    private CustomerService customerService;
    private Customer accessingCustomer;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean authenticate(Integer id) {

        accessingCustomer = customerService.getCustomer(id);
        return accessingCustomer != null;
    }

    @Override
    public Customer getAccessingCustomer() {
        return accessingCustomer;
    }
}
