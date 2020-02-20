package org.academiadecodigo.javabank.application.customerOperations;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.Text;
import org.academiadecodigo.javabank.domain.account.AccountType;

public class CustomerOpenAccountOperation extends AbstractCustomerOperation {

    public CustomerOpenAccountOperation(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void execute() {

        int accountId = customer.openAccount(AccountType.CHECKING);
        System.out.println("\n" + Text.CREATED_ACCOUNT + customer.getName() + " : " + accountId);
    }
}
