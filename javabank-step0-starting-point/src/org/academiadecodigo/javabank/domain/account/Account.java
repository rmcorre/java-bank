package org.academiadecodigo.javabank.domain.account;

public interface Account {

    int getId();

    double getBalance();

    AccountType getAccountType();

    void credit(double amount);

    void debit(double amount);

    boolean canCredit(double amount);

    boolean canDebit(double amount);

    boolean canWithdraw();

}
