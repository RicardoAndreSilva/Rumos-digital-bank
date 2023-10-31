package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.BankAccount;
import pt.rumos.DigitalBank.management.model.Customer;
import java.util.List;

public interface IBankAccountService {
   BankAccount createBankAccount(Customer primaryAccountHolder);
   boolean withdrawFromAccount(BankAccount account, double amount);
   boolean depositToAccount(BankAccount account, double amount);
   void addSecondaryAccountHolder(BankAccount account, Customer secondaryAccountHolder);
   List<BankAccount> getCustomerAccounts(Customer customer);
   BankAccount getAccountByNumber(String accountNumber);
}



