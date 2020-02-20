package org.academiadecodigo.javabank.application.customerOperations;

import org.academiadecodigo.javabank.application.BankApplication;
import org.academiadecodigo.javabank.application.Text;
import org.academiadecodigo.javabank.domain.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class CustomerBalanceOperation extends AbstractCustomerOperation {

    private DecimalFormat df = new DecimalFormat("#.##");

    public CustomerBalanceOperation(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void execute() {


        System.out.println("\n" + customer.getName() + Text.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }
    }
}
