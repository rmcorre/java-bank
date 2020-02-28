package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.controllers.LoginController;

public class LoginView extends AbstractView {

    private LoginController loginController;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {

        showBankName();
        showLoginPrompt();
    }

    private void showBankName() {

        System.out.println("\n" + Text.VIEW_LOGIN_WELCOME);
    }

    private void showLoginPrompt() {

        IntegerSetInputScanner customerIds = new IntegerSetInputScanner(bank.getCustomerIds());
        customerIds.setMessage(Text.VIEW_LOGIN_MESSAGE);
        customerIds.setError(Text.VIEW_LOGIN_ERROR);

        loginController.onLogin(prompt.getUserInput(customerIds));
    }
}
