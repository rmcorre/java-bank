package org.academiadecodigo.javabank.application.customerOperations;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.domain.Customer;

public abstract class AbstractCustomerOperation implements Operation {

    protected BankApplication bankApplication;
    protected Customer customer;

    public AbstractCustomerOperation(BankApplication bankApplication) {
        this.bankApplication = bankApplication;
        this.customer = bankApplication.getBank().getCustomer(bankApplication.getAccessingCustomerId());
    }

}
