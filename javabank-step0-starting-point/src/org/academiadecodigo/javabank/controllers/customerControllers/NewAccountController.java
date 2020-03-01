package org.academiadecodigo.javabank.controllers.customerControllers;

import org.academiadecodigo.javabank.controllers.AbstractController;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;

public class NewAccountController extends AbstractController {

    private Bank bank;
    private int newAccountId;

    public void setBank(Bank bank) {
        this.bank = bank;
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

        Account newAccount = bank.getAccountManager().openAccount(AccountType.CHECKING);
        bank.getLoginCustomer().addAccount(newAccount);

        return newAccount.getId();
    }
}
