package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controllers.BankApplication;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;

public class App {

    public static void main(String[] args) {

        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank(accountManager);
        BankApplication bankApplication = new BankApplication(bank);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Horacio");

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        bankApplication.start();
    }
}
