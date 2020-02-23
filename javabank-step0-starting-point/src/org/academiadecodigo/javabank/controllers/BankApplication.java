package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controllers.customerControllers.CustomerBalanceController;
import org.academiadecodigo.javabank.controllers.customerControllers.CustomerOpenAccountController;
import org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions.CustomerDepositController;
import org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions.CustomerWithdrawController;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.views.Text;
import org.academiadecodigo.javabank.views.UserOptions;

import java.util.HashMap;
import java.util.Map;

public class BankApplication {

//    private Bank bank;
//    private int accessingCustomerId;
//    private Map<Integer, Controller> operationsMap;
//
//    private Prompt prompt;
//    private MenuInputScanner mainMenu;
//
//
//    public BankApplication(Bank bank) {
//
//        this.bank = bank;
//        this.prompt = new Prompt(System.in, System.out);
//    }
//
//    public Bank getBank() {
//        return bank;
//    }
//
//    public Prompt getPrompt() {
//        return prompt;
//    }
//
//    public int getAccessingCustomerId() {
//        return accessingCustomerId;
//    }
//
//    public void start() {
//
//        mainMenu = buildScanMainMenu();
//        operationsMap = buildOperationsMap();
//        menuLoop();
//    }
//
//    private void menuLoop () {
//
//        int userChoice = prompt.getUserInput(mainMenu);
//
//        if (userChoice == UserOptions.QUIT.getOption()) {
//            return;
//        }
//
//        operationsMap.get(userChoice).init();
//        menuLoop();
//
//    }
//
//
//    private MenuInputScanner buildScanMainMenu() {
//
//        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
//        mainMenu.setMessage(Text.VIEW_LOGIN_WELCOME);
//        mainMenu.setError(Text.ERROR_INVALID_OPTION);
//
//        return mainMenu;
//    }
//
//    private Map<Integer, Controller> buildOperationsMap() {
//
//        Map<Integer, Controller> map = new HashMap<>();
//        map.put(UserOptions.GET_BALANCE.getOption(), new CustomerBalanceController(this));
//        map.put(UserOptions.DEPOSIT.getOption(), new CustomerDepositController(this));
//        map.put(UserOptions.WITHDRAW.getOption(), new CustomerWithdrawController(this));
//        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new CustomerOpenAccountController(this));
//
//        return map;
//    }
}
