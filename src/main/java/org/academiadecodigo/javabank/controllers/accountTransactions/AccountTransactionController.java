package org.academiadecodigo.javabank.controllers.accountTransactions;

import org.academiadecodigo.javabank.controllers.Controller;

import java.util.Set;

public interface AccountTransactionController extends Controller {

    Set<Integer> getAccountIds();
    void submitTransaction(int accountId, double amount);
}
