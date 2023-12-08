package pt.rumos.digitabank.management.interfaces;

import pt.rumos.DigitalBank.management.model.Customer;
import pt.rumos.DigitalBank.management.model.DebitCard;

import java.util.List;

public interface IDebitCardService {
    DebitCard createDebitCard(Customer customer);
    DebitCard getDebitCardByNumber(int cardNumber);
    boolean depositToDebitCard(int cardNumber, double amount);
    boolean withdrawFromDebitCard(int cardNumber, double amount);
}

