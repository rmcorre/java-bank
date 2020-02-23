package org.academiadecodigo.javabank.views;

public enum UserOptions {

    GET_BALANCE(1, Text.MENU_GET_BALANCE),
    DEPOSIT(2, Text.MENU_DEPOSIT),
    WITHDRAW(3, Text.MENU_WITHDRAW),
    OPEN_ACCOUNT(4, Text.MENU_OPEN_ACCOUNT),
    QUIT(5, Text.MENU_QUIT);

    private int option;
    private String text;

    UserOptions(int option, String text) {
        this.option = option;
        this.text = text;
    }

    public int getOption() {
        return option;
    }

    public String getText() {
        return text;
    }

    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for (UserOptions option : values()) {
            messages[option.getOption() - 1] = option.getText();
        }
        return messages;
    }

}
