package org.academiadecodigo.javabank.controllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.AbstractController;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

import java.util.Set;

public abstract class AbstractAccountTransactionController extends AbstractController implements AccountTransactionController {

    protected AccountService accountService;
    protected CustomerService customerService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Set<Integer> getAccountIds() {
        return customerService.listCustomerAccountIds(authService.getAccessingCustomer().getId());
    }
}
