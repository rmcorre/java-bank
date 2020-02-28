package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.domain.Bank;

public class LoginController extends AbstractController {

    private Controller nextController;
    private Bank bank;

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void onLogin(int id) {

        bank.setLoginCustomer(id);
        nextController.showView();
    }
}
