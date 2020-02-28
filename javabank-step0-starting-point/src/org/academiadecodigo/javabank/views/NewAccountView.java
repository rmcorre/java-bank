package org.academiadecodigo.javabank.views;

import org.academiadecodigo.javabank.controllers.customerControllers.NewAccountController;

public class NewAccountView extends AbstractView {

    private NewAccountController newAccountController;

    public void setNewAccountController(NewAccountController newAccountController) {
        this.newAccountController = newAccountController;
    }

    @Override
    public void show() {
        System.out.println("\n" + Text.VIEW_NEW_ACCOUNT_MESSAGE);
    }
}
