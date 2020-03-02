package org.academiadecodigo.javabank.model.account;

import org.academiadecodigo.javabank.model.AbstractModel;

/**
 * A generic account domain entity to be used as a base for concrete types of accounts
 */
public abstract class AbstractAccount extends AbstractModel implements Account{

    private double balance = 0;

    /**
     * Gets the account balance
     *
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the account type
     *
     * @return the account type
     */
    public abstract AccountType getAccountType();

    /**
     * Credits the account if possible
     *
     * @param amount the amount to credit
     * @see AbstractAccount#canCredit(double)
     */
    public void credit(double amount) {
        if (canCredit(amount)) {
            balance += amount;
        }
    }

    /**
     * Debits the account if possible
     *
     * @param amount the amount to debit
     * @see AbstractAccount#canDebit(double)
     */
    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }

    /**
     * Checks if a specific amount can be credited on the account
     *
     * @param amount the amount to check
     * @return {@code true} if the account can be credited
     */
    public boolean canCredit(double amount) {
        return amount > 0;
    }

    /**
     * Checks if a specific amount can be debited from the account
     *
     * @param amount the amount to check
     * @return {@code true} if the account can be debited
     */
    public boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }

    /**
     * Checks if the account can be withdrawn
     *
     * @return {@code true} if withdraw can be done
     */
    public boolean canWithdraw() {
        return true;
    }
}
