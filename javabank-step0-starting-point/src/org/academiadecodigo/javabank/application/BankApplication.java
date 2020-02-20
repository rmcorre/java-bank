package org.academiadecodigo.javabank.application;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.application.customerOperations.CustomerBalanceOperation;
import org.academiadecodigo.javabank.application.customerOperations.CustomerOpenAccountOperation;
import org.academiadecodigo.javabank.application.customerOperations.Operation;
import org.academiadecodigo.javabank.application.customerOperations.accountTransactions.CustomerDepositOperation;
import org.academiadecodigo.javabank.application.customerOperations.accountTransactions.CustomerWithdrawOperation;
import org.academiadecodigo.javabank.domain.Bank;

import java.util.HashMap;
import java.util.Map;

public class BankApplication {

    private Bank bank;
    private int accessingCustomerId;
    private Map<Integer, Operation> operationsMap;

    private Prompt prompt;
    private MenuInputScanner mainMenu;


    public BankApplication(Bank bank) {

        this.bank = bank;
        this.prompt = new Prompt(System.in, System.out);
    }

    public Bank getBank() {
        return bank;
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public int getAccessingCustomerId() {
        return accessingCustomerId;
    }

    public void start() {

        mainMenu = buildScanMainMenu();
        accessingCustomerId = scanAccessingCustomerId();
        operationsMap = buildOperationsMap();
        menuLoop();
    }

    private void menuLoop () {

        int userChoice = prompt.getUserInput(mainMenu);

        if (userChoice == UserOptions.QUIT.getOption()) {
            return;
        }

        operationsMap.get(userChoice).execute();
        menuLoop();

    }

    private int scanAccessingCustomerId() {

        IntegerSetInputScanner scanAccessingCustomerId = new IntegerSetInputScanner(bank.getCustomerIds());
        scanAccessingCustomerId.setMessage(Text.INSERT_CUSTOMER_ID);
        scanAccessingCustomerId.setError(Text.ERROR_INVALID_CUSTOMER_ID);

        return prompt.getUserInput(scanAccessingCustomerId);
    }

    private MenuInputScanner buildScanMainMenu() {

        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setMessage(Text.MENU_WELCOME);
        mainMenu.setError(Text.ERROR_INVALID_OPTION);

        return mainMenu;
    }

    private Map<Integer, Operation> buildOperationsMap() {

        Map<Integer, Operation> map = new HashMap<>();
        map.put(UserOptions.GET_BALANCE.getOption(), new CustomerBalanceOperation(this));
        map.put(UserOptions.DEPOSIT.getOption(), new CustomerDepositOperation(this));
        map.put(UserOptions.WITHDRAW.getOption(), new CustomerWithdrawOperation(this));
        map.put(UserOptions.OPEN_ACCOUNT.getOption(), new CustomerOpenAccountOperation(this));

        return map;
    }
}
