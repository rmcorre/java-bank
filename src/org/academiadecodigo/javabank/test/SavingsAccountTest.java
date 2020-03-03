package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.SavingsAccount;

public class SavingsAccountTest {

    public boolean test() {

        AbstractAccount account = new SavingsAccount();

        // account should start with zero money
        if (account.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in account
        account.credit(120);
        if (account.getBalance() != 120) {
            return false;
        }

        // account should maintain a minimum balance
        account.debit(40);
        if (account.getBalance() != 120) {
            return false;
        }

        // we should be able to take money from account
        account.debit(20);
        if (account.getBalance() != 100) {
            return false;
        }

        return true;
    }

}
