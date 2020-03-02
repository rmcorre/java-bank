package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.views.Text;
import org.academiadecodigo.javabank.views.UserOptions;

import java.util.Map;

public class MainMenuController extends AbstractController {

    private Map<Integer, Controller> controllerMap;

    public void setControllerMap(Map<Integer, Controller> controllerMap) {
        this.controllerMap = controllerMap;
    }

    public String getCustomerName() {
        return authService.getAccessingCustomer().getName();
    }

    public void onMenuSelection(int option) {

        if (option == UserOptions.QUIT.getOptionId()) {
            return;
        }

        if (!controllerMap.containsKey(option)) {
            throw new IllegalStateException(Text.SYSTEM_ERROR);
        }

        controllerMap.get(option).showView();
        showView();
    }
}
