package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

public class CustomerTest {

    public boolean test() {

        AccountManager accountManager = new AccountManager();
        Customer customer = new Customer(1, "Rui");

        // customer should start with zero balance
        if (customer.getBalance() != 0) {
            return false;
        }

        Account a1 = accountManager.openAccount(AccountType.CHECKING);
        Account a2 = accountManager.openAccount(AccountType.SAVINGS);
        accountManager.deposit(a1.getId(), 100);
        accountManager.deposit(a2.getId(), 120);

        // customer balance should equal sum of all accounts balance
        if (customer.getBalance() != 220) {
            return false;
        }

        // customer should be able to get balance for its accounts
        if (customer.getBalance(a1.getId()) != 100 || customer.getBalance(a2.getId()) != 120) {
            return false;
        }

        return true;
    }
}
