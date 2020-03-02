package org.academiadecodigo.javabank.controllers;

public class LoginController extends AbstractController {

    private Controller nextController;
    private boolean authFailed = false;

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

    public void onLogin(int id) {

        if (authService.authenticate(id)) {
            nextController.showView();
            return;
        }

        authFailed = true;
        showView();

    }

    public boolean isAuthFailed() {
        return authFailed;
    }
}
