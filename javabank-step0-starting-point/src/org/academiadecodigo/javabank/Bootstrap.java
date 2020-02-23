package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controllers.LoginController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.views.LoginView;

public class Bootstrap {

    public Bank generateTestData() {

        Bank bank = new Bank();
        AccountManager accountManager = new AccountManager();
        bank.setAccountManager(accountManager);

        Customer c1 = new Customer(1, "Rui");
        Customer c2 = new Customer(2, "Sergio");
        Customer c3 = new Customer(3, "Bruno");

        bank.addCustomer(c1);
        bank.addCustomer(c2);
        bank.addCustomer(c3);

        return bank;
    }

    public LoginController wireObjects(Bank bank) {

        Prompt prompt = new Prompt(System.in, System.out);

        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();

        loginController.setBank(bank);
        loginController.setView(loginView);

        loginView.setBank(bank);
        loginView.setPrompt(prompt);
        loginView.setLoginController(loginController);

        return loginController;

    }
}
