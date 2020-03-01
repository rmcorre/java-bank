package org.academiadecodigo.javabank.views;

import org.academiadecodigo.javabank.controllers.customerControllers.BalanceController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.text.DecimalFormat;
import java.util.Set;

public class BalanceView extends AbstractView {

    private DecimalFormat df = new DecimalFormat("#.##");
    private BalanceController balanceController;

    @Override
    public void show() {
        showBalance();
    }

    public void setBalanceController(BalanceController balanceController) {
        this.balanceController = balanceController;
    }

    private void showBalance() {
        //In classic MVC the Model notifies the view for changes, but it is also
        // correct to have the view reading the model, either directly via the
        // controller or indirectly. What can not happen is for the view to
        // update the model directly. Model updates must always be done via the
        // controller.
        Customer customer = bank.getLoginCustomer();
        System.out.println("\n" + customer.getName() + Text.BALANCE_MESSAGE + "\n");

        Set<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getAccountType() + "\t" + df.format(account.getBalance()));
        }

        System.out.println("\n\n" + Text.VIEW_BALANCE_TOTAL_MESSAGE + df.format(customer.getBalance()));
    }
}
