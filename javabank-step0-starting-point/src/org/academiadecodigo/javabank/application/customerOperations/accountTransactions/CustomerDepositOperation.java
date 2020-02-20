package org.academiadecodigo.javabank.application.customerOperations.accountTransactions;

import org.academiadecodigo.javabank.application.BankApplication;

public class CustomerDepositOperation extends AbstractAccountTransactionOperation {

    public CustomerDepositOperation(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void execute() {

        super.execute();

        if (!hasAccounts()) {
            return;
        }

        Integer accountId = scanAccount();
        Double amount = scanAmount();

        if (customer.getAccountIds().contains(accountId)) {
            accountManager.deposit(accountId, amount);
        }
    }
}
