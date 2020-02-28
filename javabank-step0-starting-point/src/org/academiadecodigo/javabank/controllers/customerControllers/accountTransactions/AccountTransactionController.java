package org.academiadecodigo.javabank.controllers.customerControllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.Controller;

public interface AccountTransactionController extends Controller {

    void submitTransaction(int accountId, double amount);
}
