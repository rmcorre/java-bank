package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.LoginController;
import org.academiadecodigo.javabank.controllers.MainMenuController;
import org.academiadecodigo.javabank.controllers.customerControllers.BalanceController;
import org.academiadecodigo.javabank.controllers.customerControllers.NewAccountController;
import org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions.AccountTransactionController;
import org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions.DepositController;
import org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions.WithdrawController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.managers.AccountManager;
import org.academiadecodigo.javabank.views.*;

import java.util.HashMap;
import java.util.Map;

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

        MainMenuController mainMenuController = new MainMenuController();
        MainMenuView mainMenuView = new MainMenuView();

        mainMenuView.setBank(bank);
        mainMenuView.setPrompt(prompt);
        mainMenuView.setMainMenuController(mainMenuController);

        mainMenuController.setView(mainMenuView);
        loginController.setNextController(mainMenuController);

        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceController.setView(balanceView);
        balanceView.setBalanceController(balanceController);
        balanceView.setBank(bank);

        NewAccountController newAccountController = new NewAccountController();
        NewAccountView newAccountView = new NewAccountView();
        newAccountController.setView(newAccountView);
        newAccountView.setNewAccountController(newAccountController);
        newAccountController.setBank(bank);

        DepositController depositController = new DepositController();
        AccountTransactionView depositView = new AccountTransactionView();
        depositController.setView(depositView);
        depositView.setTransactionController(depositController);
        depositController.setBank(bank);
        depositView.setBank(bank);
        depositView.setPrompt(prompt);

        WithdrawController withdrawController = new WithdrawController();
        AccountTransactionView withdrawView = new AccountTransactionView();
        withdrawController.setView(withdrawView);
        withdrawView.setTransactionController(withdrawController);
        withdrawController.setBank(bank);
        withdrawView.setBank(bank);
        withdrawView.setPrompt(prompt);

        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.GET_BALANCE.getOptionId(), balanceController);
        controllerMap.put(UserOptions.DEPOSIT.getOptionId(), depositController);
        controllerMap.put(UserOptions.WITHDRAW.getOptionId(), withdrawController);
        controllerMap.put(UserOptions.OPEN_ACCOUNT.getOptionId(), newAccountController);

        mainMenuController.setControllerMap(controllerMap);

        return loginController;

    }
}
