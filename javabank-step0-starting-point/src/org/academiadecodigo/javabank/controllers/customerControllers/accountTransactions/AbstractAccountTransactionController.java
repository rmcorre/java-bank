package org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.AbstractController;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    protected Bank bank;

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
