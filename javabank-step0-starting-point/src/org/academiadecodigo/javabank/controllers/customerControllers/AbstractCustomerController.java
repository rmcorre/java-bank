package org.academiadecodigo.javabank.controllers.customerControllers;

import org.academiadecodigo.javabank.controllers.BankApplication;
import org.academiadecodigo.javabank.controllers.Controller;
import org.academiadecodigo.javabank.domain.Customer;

public abstract class AbstractCustomerController implements Controller {

    protected BankApplication bankApplication;
    protected Customer customer;

    public AbstractCustomerController(BankApplication bankApplication) {
        this.bankApplication = bankApplication;
        this.customer = bankApplication.getBank().getCustomer(bankApplication.getAccessingCustomerId());
    }

}
