package org.academiadecodigo.javabank.views;


import org.academiadecodigo.javabank.controllers.BalanceController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.text.DecimalFormat;
import java.util.List;

public class BalanceView extends AbstractView {

    private DecimalFormat df = new DecimalFormat("#.##");
    private BalanceController balanceController;

    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }

    @Override
    public void show() {
        showBalance();
    }

    private void showBalance() {
        //In classic MVC the Model notifies the view for changes, but it is also
        // correct to have the view reading the model, either directly via the
        // controller or indirectly. What can not happen is for the view to
        // update the model directly. Model updates must always be done via the
        // controller.
        Customer customer = balanceController.getCustomer();
        System.out.println("\n" + customer.getName() + Text.BALANCE_MESSAGE + "\n");

        List<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Text.VIEW_BALANCE_TOTAL_MESSAGE + df.format(balanceController.getCustomerBalance()));
    }
}
