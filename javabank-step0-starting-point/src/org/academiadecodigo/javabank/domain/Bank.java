package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The bank entity
 */
public class Bank {

    private AccountManager accountManager;
    private Map<Integer, Customer> customers;
    private int loginCustomer;

    /**
     * Creates a new instance of Bank and initializes it with the given account manager
     */
    public Bank() {
        this.customers = new HashMap<>();
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Customer getLoginCustomer() {
        return customers.get(loginCustomer);
    }

    public void setLoginCustomer(int id) {
        this.loginCustomer = id;
    }

    public Set<Integer> getCustomerIds() {
        return customers.keySet();
    }

    /**
     * Adds a new customer to the bank
     *
     * @param customer the new bank customer
     * @see Customer#setAccountManager(AccountManager)
     */
    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        customer.setAccountManager(accountManager);
    }

    /**
     * Gets the total balance of the bank
     *
     * @return the bank total balance
     */
    public double getBalance() {

        double balance = 0;

        for (Customer customer : customers.values()) {
            balance += customer.getBalance();
        }

        return balance;
    }
}
