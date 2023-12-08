package pt.rumos.DigitalBank.management.ui;

import pt.rumos.DigitalBank.management.model.Customer;
import pt.rumos.DigitalBank.management.model.DebitCard;
import pt.rumos.DigitalBank.management.utils.Console;
import pt.rumos.digitabank.management.interfaces.IDebitCardService;
import pt.rumos.digitalBank.management.services.AuthService;
import pt.rumos.digitalBank.management.services.CustomerService;
import pt.rumos.digitalBank.management.services.DebitCardServiceIml;

public class Management {

    public static void start() {

        System.out.println("Welcome to Management App");
    }

    public static void showManagementOptionsCustomer(AuthService authService, Customer authenticatedCustomer) {
        Console.writeLine("Choose an option:");
        Console.writeLine("1. View customer information");
        Console.writeLine("2. Update customer information");
        Console.writeLine("3. Delete customer account");
        Console.writeLine("4. Create debit card");
        Console.writeLine("5. Create credit card");
        Console.write("Enter your choice: ");

        try {
            int choice = Integer.parseInt(Console.readLine());

            switch (choice) {
                case 1:
                    viewCustomerInformation(authenticatedCustomer);
                    break;
                case 2:
                    updateCustomerInformation(authenticatedCustomer);
                    break;
                case 3:
                    deleteCustomerByNIF(authService.getAuthenticatedCustomer());
                    break;
                case 4:
                    createDebitCard(authService);
                    break;
                case 5:
                    createCreditCard(authService);
                    break;
                default:
                    Console.writeLine("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            Console.writeLine("Please enter a number valid.");
        }
    }

    private static void deleteCustomerByNIF(Customer authenticatedCustomer) {
        Console.writeLine("Are you sure you want to delete your account; YES or NO?");
        String confirmationToDeleteAccount = Console.readLine();

        if (confirmationToDeleteAccount.equalsIgnoreCase("yes")) {
            try {
                CustomerService.getInstance().deleteCustomerByNif(authenticatedCustomer.getNif());
                Console.writeLine("Account deleted with Successfully");
            } catch (IllegalArgumentException e) {
                Console.writeLine(e.getMessage());
            }
        } else {
            Console.writeLine("Account deletion canceled");
        }
    }


    private static void viewCustomerInformation(Customer authenticatedCustomer) {
        Console.writeLine("Customer Information:");
        Console.writeLine("Username: " + authenticatedCustomer.getUsername());
        Console.writeLine("Name: " + authenticatedCustomer.getName());
        Console.writeLine("NIF: " + authenticatedCustomer.getNif());
        Console.writeLine("Date of Birth: " + authenticatedCustomer.getDateOfBirth());
        Console.writeLine("Phone Number: " + authenticatedCustomer.getPhoneNumber());
        Console.writeLine("Mobile Number: " + authenticatedCustomer.getMobileNumber());
        Console.writeLine("Email: " + authenticatedCustomer.getEmail());
        Console.writeLine("Profession: " + authenticatedCustomer.getProfession());
    }

    private static void updateCustomerInformation(Customer authenticatedCustomer) {
        Console.writeLine("Enter new information:");

        Console.write("Enter your name: ");
        String name = Console.readLine();
        Console.write("Enter your date of birth (yyyy-MM-dd): ");
        String dateOfBirth = Console.readLine();
        Console.write("Enter your phone number: ");
        String phoneNumber = Console.readLine();
        Console.write("Enter your mobile number: ");
        String mobileNumber = Console.readLine();
        Console.write("Enter your email: ");
        String email = Console.readLine();
        Console.write("Enter your profession: ");
        String profession = Console.readLine();

        try {
            authenticatedCustomer.setName(name);
            authenticatedCustomer.setDateOfBirth(dateOfBirth);
            authenticatedCustomer.setPhoneNumber(phoneNumber);
            authenticatedCustomer.setMobileNumber(mobileNumber);
            authenticatedCustomer.setEmail(email);
            authenticatedCustomer.setProfession(profession);

            Console.writeLine("updated successfully.");
        } catch (IllegalArgumentException e) {
            Console.writeLine(e.getMessage());
        }
    }

    private static void createCreditCard(AuthService authService) {
        Customer authenticatedCustomer= authService.isAuthenticated();
        IDebitCardService debitCardService = DebitCardServiceIml.g

                try{

                }
    }

    private static void createDebitCard(AuthService authService) {
    }
}


