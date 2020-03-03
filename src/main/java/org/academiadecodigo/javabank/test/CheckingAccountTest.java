package org.academiadecodigo.javabank.test;

import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.CheckingAccount;

public class CheckingAccountTest {

    public boolean test() {

        AbstractAccount account = new CheckingAccount();

        // account should start with zero money
        if (account.getBalance() != 0) {
            return false;
        }

        // we should be able to deposit money in account
        account.credit(80);
        if (account.getBalance() != 80) {
            return false;
        }

        // we should be able to take money from account
        account.debit(40);
        if (account.getBalance() != 40) {
            return false;
        }

        return true;
    }

}
