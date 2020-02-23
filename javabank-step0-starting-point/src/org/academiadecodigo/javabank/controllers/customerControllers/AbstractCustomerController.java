package org.academiadecodigo.javabank.controllers.customerControllers;

import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.views.View;

public abstract class AbstractCustomerController implements Controller {

    protected View view;

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void init() {
        view.show();
    }

}
