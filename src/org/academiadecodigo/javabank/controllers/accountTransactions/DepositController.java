package org.academiadecodigo.javabank.controllers.accountTransactions;

public class DepositController extends AbstractAccountTransactionController {


    @Override
    public void submitTransaction(int accountId, double amount) {
        accountService.deposit(accountId, amount);
    }
}
