package org.academiadecodigo.javabank.views;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.controllers.MainMenuController;

public class MainMenuView extends AbstractView {

    private MainMenuController mainMenuController;

    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    @Override
    public void show() {

        showMainMenuPrompt();
    }

    private void showMainMenuPrompt() {
        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.createOptionsArray());
        mainMenu.setMessage("\n" + Text.VIEW_MAINMENU_MESSAGE + bank.getLoginCustomer().getName());
        mainMenu.setError(Text.VIEW_MAINMENU_INVALID_OPTION);
        mainMenuController.onMenuSelection(prompt.getUserInput(mainMenu));
    }
}
