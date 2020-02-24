package org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.AbstractController;

public abstract class AbstractAccountTransactionController extends AbstractController {

//    protected AccountManager accountManager;
//    private Prompt prompt;
//
//    public AbstractAccountTransactionController(BankApplication bankApplication) {
//        super(bankApplication);
//        this.accountManager = bankApplication.getBank().getAccountManager();
//        this.prompt = bankApplication.getPrompt();
//    }
//
//    @Override
//    public void init() {
//
//        if (!hasAccounts()) {
//            System.out.println(Text.ERROR_NO_ACCOUNT);
//            return;
//        }
//
//        System.out.println("\n" + Text.OPEN_ACCOUNTS_LIST + buildAccountsList());
//    }
//
//    protected boolean hasAccounts() {
//        return customer.getAccounts().size() > 0;
//    }
//
//    private String buildAccountsList() {
//
//        StringBuilder builder = new StringBuilder();
//
//        for (Integer id : customer.getAccountIds()) {
//            builder.append(id);
//            builder.append(" ");
//        }
//
//        return builder.toString();
//    }
//
//    protected int scanAccount() {
//
//        IntegerSetInputScanner scanner = new IntegerSetInputScanner(customer.getAccountIds());
//        scanner.setMessage(Text.CHOOSE_ACCOUNT);
//        scanner.setError(Text.ERROR_INVALID_ACCOUNT);
//
//        return prompt.getUserInput(scanner);
//    }
//
//    protected double scanAmount() {
//        DoubleInputScanner scanner = new DoubleInputScanner();
//        scanner.setMessage(Text.CHOOSE_AMOUNT);
//        scanner.setError(Text.ERROR_INVALID_AMOUNT);
//
//        return prompt.getUserInput(scanner);
//    }
}
