package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankService {

    private static Map<String, Account> accounts = new HashMap<>();

    public String createAccount(Client client){
        Account account = new Account("DE" + String.format("%08d",accounts.size()), BigDecimal.ZERO, client);
        accounts.put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount){
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public void printAccounts(){
        for(Account account : accounts.values()){
            System.out.println(account);
        }
    }
}
