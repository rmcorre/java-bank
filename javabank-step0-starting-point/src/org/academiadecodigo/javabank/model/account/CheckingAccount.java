package org.academiadecodigo.javabank.model.account;

/**
 * A checking account with no restrictions
 * @see AbstractAccount
 * @see AccountType#CHECKING
 */
public class CheckingAccount extends AbstractAccount {

    /**
     * Creates a new {@code CheckingAccount} instance
     *
     * @see AbstractAccount#AbstractAccount(int)
     */
    public CheckingAccount(int id) {
        super(id);
    }

    /**
     * @see AbstractAccount#getAccountType()
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
