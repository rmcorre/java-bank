package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {

    Customer getCustomer(Integer id);
    List<Customer> listCustomers();
    Set<Integer> listCustomerAccountIds(Integer id);
    double getBalance(int customerId);
    void add(Customer customer);
}
