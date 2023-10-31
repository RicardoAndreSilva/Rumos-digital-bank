
package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.BankAccount;
import pt.rumos.DigitalBank.management.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankAccountService implements IBankAccountService {
    private List<BankAccount> bankAccounts;
    private int accountNumberCounter = 1;

    public BankAccountService() {
        bankAccounts = new ArrayList<>();
    }

    @Override
    public BankAccount createBankAccount(Customer primaryAccountHolder) {
        String accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, primaryAccountHolder);
        bankAccounts.add(newAccount);
        return newAccount;
    }

    public boolean withdrawFromAccount(BankAccount account, double amount) {
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }

    @Override
    public boolean depositToAccount(BankAccount account, double amount) {
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public void addSecondaryAccountHolder(BankAccount account, Customer secondaryAccountHolder) {
        if (account != null) {
            account.addSecondaryAccountHolder(secondaryAccountHolder);
        }
    }

    @Override
    public List<BankAccount> getCustomerAccounts(Customer customer) {
        List<BankAccount> customerAccounts = new ArrayList<>();
        for (BankAccount account : bankAccounts) {
            if (account.getPrimaryAccountHolder().equals(customer) || account.getSecondaryAccountHolders().contains(customer)) {
                customerAccounts.add(account);
            }
        }
        return customerAccounts;
    }

    private String generateAccountNumber() {
        String accountNumber = "Number of Account-" + accountNumberCounter;
        accountNumberCounter++;
        return accountNumber;
    }

    @Override
    public BankAccount getAccountByNumber(String accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
