package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customerMap = new HashMap<>();

    private Integer getNextId() {
        return customerMap.isEmpty() ? 1 : Collections.max(customerMap.keySet()) + 1;
    }

    @Override
    public void add(Customer customer) {

        if (customer.getId() == null) {
            customer.setId(getNextId());
        }

        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer getCustomer(Integer id) {
        return customerMap.get(id);
    }

    @Override
    public List<Customer> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        Set<Integer> accountIds = new HashSet<>();
        List<Account> accountList = customerMap.get(id).getAccounts();

        for (Account account : accountList) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    @Override
    public double getBalance(int customerId) {

        List<Account> accounts = customerMap.get(customerId).getAccounts();

        double balance = 0;

        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }
}
