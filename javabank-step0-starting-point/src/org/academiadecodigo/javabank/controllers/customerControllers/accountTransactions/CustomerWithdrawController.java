package org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.BankApplication;

public class CustomerWithdrawController extends AbstractAccountTransactionController {

    public CustomerWithdrawController(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void init() {

        super.init();

        if (!hasAccounts()) {
            return;
        }

        Integer accountId = scanAccount();
        Double amount = scanAmount();

        if (customer.getAccountIds().contains(accountId)) {
            accountManager.withdraw(accountId, amount);
        }
    }
}
