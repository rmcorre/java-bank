package org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.precisiondouble.DoubleInputScanner;
import org.academiadecodigo.javabank.controllers.BankApplication;
import org.academiadecodigo.javabank.views.Text;
import org.academiadecodigo.javabank.controllers.customerControllers.AbstractCustomerController;
import org.academiadecodigo.javabank.managers.AccountManager;

public abstract class AbstractAccountTransactionController extends AbstractCustomerController {

    protected AccountManager accountManager;
    private Prompt prompt;

    public AbstractAccountTransactionController(BankApplication bankApplication) {
        super(bankApplication);
        this.accountManager = bankApplication.getBank().getAccountManager();
        this.prompt = bankApplication.getPrompt();
    }

    @Override
    public void init() {

        if (!hasAccounts()) {
            System.out.println(Text.ERROR_NO_ACCOUNT);
            return;
        }

        System.out.println("\n" + Text.OPEN_ACCOUNTS_LIST + buildAccountsList());
    }

    protected boolean hasAccounts() {
        return customer.getAccounts().size() > 0;
    }

    private String buildAccountsList() {

        StringBuilder builder = new StringBuilder();

        for (Integer id : customer.getAccountIds()) {
            builder.append(id);
            builder.append(" ");
        }

        return builder.toString();
    }

    protected int scanAccount() {

        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customer.getAccountIds());
        scanner.setMessage(Text.CHOOSE_ACCOUNT);
        scanner.setError(Text.ERROR_INVALID_ACCOUNT);

        return prompt.getUserInput(scanner);
    }

    protected double scanAmount() {
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage(Text.CHOOSE_AMOUNT);
        scanner.setError(Text.ERROR_INVALID_AMOUNT);

        return prompt.getUserInput(scanner);
    }
}
