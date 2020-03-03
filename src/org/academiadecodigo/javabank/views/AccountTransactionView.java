package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.controllers.accountTransactions.AccountTransactionController;


public class AccountTransactionView extends AbstractView {

    private AccountTransactionController transactionController;

    public void setTransactionController(AccountTransactionController transactionController) {
        this.transactionController = transactionController;
    }

    @Override
    public void show() {

        if (transactionController.getAccountIds().size() == 0) {
            showNoAccountsError();
        }

        showAccounts();

        transactionController.submitTransaction(scanAccount(), scanAmount());
    }

    private void showNoAccountsError() {
        System.out.println("\n" + Text.VIEW_ACCOUNT_TRANSACTION_NOACCOUNTS_ERROR);
    }

    private void showAccounts() {
        System.out.println("\n" + Text.VIEW_ACCOUNT_TRANSACTION_ACCOUNTS_MESSAGE + buildAccountsList());
    }

    private String buildAccountsList() {

        StringBuilder builder = new StringBuilder();

        for (Integer id : transactionController.getAccountIds()) {
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    protected int scanAccount() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(transactionController.getAccountIds());
        scanner.setMessage(Text.VIEW_ACCOUNT_TRANSACTION_CHOOSE_ACCOUNT);
        scanner.setError(Text.VIEW_ACCOUNT_TRANSACTION_INVALID_ACCOUNT_ERROR);

        return prompt.getUserInput(scanner);
    }

    protected double scanAmount() {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Text.VIEW_ACCOUNT_TRANSACTION_AMOUNT);
        scanner.setError(Text.VIEW_ACCOUNT_TRANSACTION_INVALID_AMOUNT_ERROR);

        return prompt.getUserInput(scanner);
    }
}
