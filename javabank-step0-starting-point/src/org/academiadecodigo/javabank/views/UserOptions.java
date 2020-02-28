package org.academiadecodigo.javabank.views;

public enum UserOptions {

    GET_BALANCE(1, Text.MENU_GET_BALANCE),
    DEPOSIT(2, Text.MENU_DEPOSIT),
    WITHDRAW(3, Text.MENU_WITHDRAW),
    OPEN_ACCOUNT(4, Text.MENU_OPEN_ACCOUNT),
    QUIT(5, Text.MENU_QUIT);

    private int optionId;
    private String optionText;

    UserOptions(int optionId, String optionText) {
        this.optionId = optionId;
        this.optionText = optionText;
    }

    public int getOptionId() {
        return optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public static String[] createOptionsArray() {

        String[] options = new String[values().length];

        for (UserOptions value : values()) {
            options[value.getOptionId() - 1] = value.getOptionText();
        }
        return options;
    }

}
