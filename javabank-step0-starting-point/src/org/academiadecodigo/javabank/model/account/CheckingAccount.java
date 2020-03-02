package org.academiadecodigo.javabank.model.account;

/**
 * A checking account with no restrictions
 * @see AbstractAccount
 * @see AccountType#CHECKING
 */
public class CheckingAccount extends AbstractAccount {

    /**
     * @see Account#getAccountType()
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
