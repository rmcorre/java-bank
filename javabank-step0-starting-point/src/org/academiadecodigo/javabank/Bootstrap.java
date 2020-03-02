package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.controllers.LoginController;
import org.academiadecodigo.javabank.controllers.MainMenuController;
import org.academiadecodigo.javabank.controllers.BalanceController;
import org.academiadecodigo.javabank.controllers.NewAccountController;
import org.academiadecodigo.javabank.controllers.accountTransactions.DepositController;
import org.academiadecodigo.javabank.controllers.accountTransactions.WithdrawController;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AccountServiceImpl;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;
import org.academiadecodigo.javabank.views.*;

import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    private CustomerServiceImpl customerService;
    private AccountServiceImpl accountService;
    private AuthServiceImpl authService;

    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public void setAuthService(AuthServiceImpl authService) {
        this.authService = authService;
    }

    public void loadCustomers() {

        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        c1.setName("Rui");
        c2.setName("Sergio");
        c3.setName("Bruno");
        customerService.add(c1);
        customerService.add(c2);
        customerService.add(c3);
    }

    public Controller wireObjects() {

        Prompt prompt = new Prompt(System.in, System.out);

        authService.setCustomerService(customerService);

        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();
        loginController.setView(loginView);
        loginController.setAuthService(authService);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);

        MainMenuController mainMenuController = new MainMenuController();
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuController.setView(mainMenuView);
        mainMenuController.setAuthService(authService);
        mainMenuView.setMainMenuController(mainMenuController);
        mainMenuView.setPrompt(prompt);
        loginController.setNextController(mainMenuController);

        BalanceController balanceController = new BalanceController();
        BalanceView balanceView = new BalanceView();
        balanceController.setView(balanceView);
        balanceController.setCustomerService(customerService);
        balanceController.setAuthService(authService);
        balanceView.setBalanceController(balanceController);

        NewAccountController newAccountController = new NewAccountController();
        NewAccountView newAccountView = new NewAccountView();
        newAccountController.setView(newAccountView);
        newAccountController.setAuthService(authService);
        newAccountController.setAccountService(accountService);
        newAccountController.setAccountFactory(new AccountFactory());
        newAccountView.setNewAccountController(newAccountController);

        DepositController depositController = new DepositController();
        AccountTransactionView depositView = new AccountTransactionView();
        depositController.setView(depositView);
        depositController.setAuthService(authService);
        depositController.setAccountService(accountService);
        depositController.setCustomerService(customerService);
        depositView.setTransactionController(depositController);
        depositView.setPrompt(prompt);

        WithdrawController withdrawController = new WithdrawController();
        AccountTransactionView withdrawView = new AccountTransactionView();
        withdrawController.setView(withdrawView);
        withdrawController.setAuthService(authService);
        withdrawController.setAccountService(accountService);
        withdrawController.setCustomerService(customerService);
        withdrawView.setTransactionController(withdrawController);
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
