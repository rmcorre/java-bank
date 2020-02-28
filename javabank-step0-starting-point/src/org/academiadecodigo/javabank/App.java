package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controllers.LoginController;
import org.academiadecodigo.javabank.domain.Bank;

public class App {

    private Bank bank;

    public static void main(String[] args) {

        App app = new App();
        app.bootstrap();
    }

    private void bootstrap() {
        Bootstrap bootstrap = new Bootstrap();
        bank = bootstrap.generateTestData();

        LoginController loginController = bootstrap.wireObjects(bank);
        loginController.showView();
    }
}
