package org.academiadecodigo.javabank.factories;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.model.account.CheckingAccount;
import org.academiadecodigo.javabank.model.account.SavingsAccount;

public class AccountFactory {

    private int nextAccountId = 1;

    private int getNextAccountId() {
        return nextAccountId++;
    }

    public Account createAccount(AccountType accountType) {

        Account newAccount;

        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount(getNextAccountId());
                break;
            case SAVINGS:
                newAccount = new SavingsAccount(getNextAccountId());
                break;
            default:
                newAccount = null;
        }
        return newAccount;
    }
}
