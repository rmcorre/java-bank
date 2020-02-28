package org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.BankApplication;

public class WithdrawController extends AbstractAccountTransactionController {

    @Override
    public void submitTransaction(int accountId, double amount) {
        bank.getAccountManager().withdraw(accountId, amount);
    }


//    public CustomerWithdrawController(BankApplication bankApplication) {
//        super(bankApplication);
//    }
//
//    @Override
//    public void init() {
//
//        super.init();
//
//        if (!hasAccounts()) {
//            return;
//        }
//
//        Integer accountId = scanAccount();
//        Double amount = scanAmount();
//
//        if (customer.getAccountIds().contains(accountId)) {
//            accountManager.withdraw(accountId, amount);
//        }
//    }
}
