package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.DebitCard;

public class ATMService {
    private AuthService authService;
    private BankAccountService bankAccountService;
    private DebitCardServiceIml debitCardService;

    public ATMService(AuthService authService, BankAccountService bankAccountService, DebitCardServiceIml debitCardService) {
        this.authService = authService;
        this.bankAccountService = bankAccountService;
        this.debitCardService = debitCardService;
    }


    public boolean performATMOperation(int cardNumber, int pin, double amount) {
        if (!authService.isAuthenticated()) {
            System.out.println("Cliente não autenticado.");
            return false;
        }




        if (debitCardService.withdrawFromDebitCard(cardNumber, amount)) {
            System.out.println("Operação no ATM bem-sucedida.");
            return true;
        } else {
            System.out.println("Falha na operação no ATM.");
            return false;
        }
    }
}

