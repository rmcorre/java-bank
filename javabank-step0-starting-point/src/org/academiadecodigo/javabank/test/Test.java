package org.academiadecodigo.javabank.test;

public class Test {

    public static void main(String[] args) {

        CheckingAccountTest checkingAccountTest = new CheckingAccountTest();
        SavingsAccountTest savingsAccountTest = new SavingsAccountTest();
        CustomerTest customerTest = new CustomerTest();

        System.out.println("CheckingAccount: " + (checkingAccountTest.test() ? "OK" : "FAIL"));
        System.out.println("SavingsAccount: " + (savingsAccountTest.test() ? "OK" : "FAIL"));
        System.out.println("Customer: " + (customerTest.test() ? "OK" : "FAIL"));

    }

}
