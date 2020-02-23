package org.academiadecodigo.javabank.controllers.customerControllers;

import org.academiadecodigo.javabank.controllers.BankApplication;
import org.academiadecodigo.javabank.views.Text;
import org.academiadecodigo.javabank.domain.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class CustomerBalanceController extends AbstractCustomerController {

    private DecimalFormat df = new DecimalFormat("#.##");

    public CustomerBalanceController(BankApplication bankApplication) {
        super(bankApplication);
    }

    @Override
    public void init() {


        System.out.println("\n" + customer.getName() + Text.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }
    }
}
