package org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.BankApplication;

public class DepositController extends AbstractAccountTransactionController {


    @Override
    public void submitTransaction(int accountId, double amount) {
        bank.getAccountManager().deposit(accountId, amount);
    }
}
