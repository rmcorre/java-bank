package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class BankTest {

    public boolean test() {

        AccountManager accountManager = new AccountManager();
        Bank bank = new Bank();

        // bank initial balance should be 0
        if (bank.getBalance() != 0) {
            return false;
        }

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        bank.addCustomer(c1);
        bank.addCustomer(c2);

        Account a1 = accountManager.openAccount(AccountType.CHECKING);
        Account a2 = accountManager.openAccount(AccountType.CHECKING);

        c1.addAccount(a1);
        c2.addAccount(a2);

        accountManager.deposit(a1.getId(), 10);
        accountManager.deposit(a2.getId(), 20);

        // bank balance should equal sum of all accounts
        if (bank.getBalance() != 100) {
            return false;
        }

        return true;
    }
}
