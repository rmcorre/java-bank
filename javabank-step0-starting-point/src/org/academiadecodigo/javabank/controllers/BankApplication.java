package org.academiadecodigo.javabank.controllers;

public class BankApplication {

//    private Bank bank;
//    private int accessingCustomerId;
//
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
//
//
//        return map;
//    }
}
