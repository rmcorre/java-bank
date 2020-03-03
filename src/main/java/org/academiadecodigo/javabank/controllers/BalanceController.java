package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.controllers.AbstractController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;

public class BalanceController extends AbstractController {

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return authService.getAccessingCustomer();
    }

    public double getCustomerBalance() {
        return customerService.getBalance(authService.getAccessingCustomer().getId());
    }
}
