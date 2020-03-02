package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.javabank.controllers.LoginController;

public class LoginView extends AbstractView {

    private LoginController loginController;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {

        if (loginController.isAuthFailed()) {
            System.out.println("\n" + Text.VIEW_LOGIN_ERROR);
        }

        showBankName();
        showLoginPrompt();
    }

    private void showBankName() {
        System.out.println("\n" + Text.VIEW_LOGIN_WELCOME);
    }

    private void showLoginPrompt() {

        IntegerInputScanner customerId = new IntegerInputScanner();
        customerId.setMessage(Text.VIEW_LOGIN_MESSAGE);
        customerId.setError(Text.VIEW_LOGIN_ERROR);

        loginController.onLogin(prompt.getUserInput(customerId));
    }
}
