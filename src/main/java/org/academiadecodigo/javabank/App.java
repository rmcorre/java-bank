package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;

public class App {

    public static void main(String[] args) {

        App app = new App();
        app.bootstrap();
    }

    private void bootstrap() {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImpl());
        bootstrap.setCustomerService(new CustomerServiceImpl());
        bootstrap.loadCustomers();

        Controller loginController = bootstrap.wireObjects();
        loginController.showView();
    }
}
