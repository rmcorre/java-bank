package org.academiadecodigo.javabank.controllers;

import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.views.View;

public abstract class AbstractController implements Controller {

    protected AuthService authService;
    protected View view;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void showView() {
        view.show();
    }

}
