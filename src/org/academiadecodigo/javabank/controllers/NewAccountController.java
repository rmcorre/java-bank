package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountService;

public class NewAccountController extends AbstractController {

    private int newAccountId;
    private AccountFactory accountFactory;
    private AccountService accountService;

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public int getNewAccountId() {
        return newAccountId;
    }

    @Override
    public void showView() {

        newAccountId = createAccount();
        super.showView();
    }

    public int createAccount() {

        Account newAccount = accountFactory.createAccount(AccountType.CHECKING);
        accountService.add(newAccount);
        authService.getAccessingCustomer().addAccount(newAccount);

        return newAccount.getId();
    }
}
