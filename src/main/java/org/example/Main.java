package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();

        Client client1 = new Client("John", "Doe", "12345");
        Client client2 = new Client("Jane", "Doe", "67890");

        String accountNumber1 = bankService.createAccount(client1);
        String accountNumber2 = bankService.createAccount(client2);

        bankService.transfer(accountNumber1, accountNumber2, new BigDecimal("100"));

        bankService.printAccounts();
    }
}