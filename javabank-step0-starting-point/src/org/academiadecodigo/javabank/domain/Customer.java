package org.academiadecodigo.javabank.domain;

import org.academiadecodigo.javabank.domain.account.Account;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The customer domain entity
 */
public class Customer {

    private int id;
    private String name;
    private Map<Integer, Account> accounts = new HashMap<>();

    public Customer (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Account> getAccounts() {
        return new HashSet<>(accounts.values());
    }

    public Set<Integer> getAccountIds() {
        return new HashSet<>(accounts.keySet());
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public double getBalance(int id) {
        return accounts.get(id).getBalance();
    }

    public double getBalance() {

        double balance = 0;

        for (Account account : accounts.values()) {
            balance += account.getBalance();
        }

        return balance;
    }

}
