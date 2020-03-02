package org.academiadecodigo.javabank.controllers.accountTransactions;

public class WithdrawController extends AbstractAccountTransactionController {

    @Override
    public void submitTransaction(int accountId, double amount) {
        accountService.withdraw(accountId, amount);
    }
}
