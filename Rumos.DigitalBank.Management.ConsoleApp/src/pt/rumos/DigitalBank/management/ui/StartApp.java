package pt.rumos.DigitalBank.management.ui;

import pt.rumos.DigitalBank.management.model.Customer;
import pt.rumos.DigitalBank.management.utils.Console;
import pt.rumos.digitalBank.management.services.AuthService;
import pt.rumos.digitalBank.management.services.CustomerService;

import static pt.rumos.DigitalBank.management.ui.Management.showManagementOptionsCustomer;

public class StartApp {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Console.writeLine("Welcome to Rumos Digital Bank App");


        AuthService authService = AuthService.getInstance();
        CustomerService customerService = CustomerService.getInstance();

        do {
            Console.writeLine("Choose an option:");
            Console.writeLine("1. Authenticate as an existing customer");
            Console.writeLine("2. Register as a new customer");
            Console.write("Enter your choice: ");

            try {
                int choice = Integer.parseInt(Console.readLine());

                switch (choice) {
                    case 1:
                        authenticateExistingCustomer(authService);
                        break;
                    case 2:
                        registerNewCustomer(customerService);
                        break;
                    default:
                        Console.writeLine("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                Console.writeLine("Invalid input. Please enter a number.");
            }
        } while (!authService.isAuthenticated());
    }

    private static void authenticateExistingCustomer(AuthService authService) {
        Console.write("Username: ");
        String username = Console.readLine().trim();
        Console.write("Password: ");
        String password = Console.readLine().trim();

        authService.login(username, password);

        if (authService.isAuthenticated()) {
            Console.writeLine("Hello, " + authService.getAuthenticatedCustomer().getName());
            showOptions(authService.getAuthenticatedCustomer(),authService);
        } else {
            Console.writeLine("Wrong credentials");
        }
    }

    private static void showOptions(Customer authenticatedCustomer, AuthService authService) {
        Console.writeLine("Choose an option:");
        Console.writeLine("1. ATM");
        Console.writeLine("2. MANAGEMENT");
        Console.write("Enter your choice: ");

        int choice = Integer.parseInt(Console.readLine());
        switch (choice) {
            case 1:

                Console.writeLine("ATM option selected");
                break;
            case 2:

                Console.writeLine("MANAGEMENT option selected");
                Management.showManagementOptionsCustomer(authService,authenticatedCustomer);
                break;
            default:
                Console.writeLine("Invalid choice. Please try again.");
        }
    }



    private static void registerNewCustomer(CustomerService customerService) {
        Console.write("Enter a username: ");
        String username = Console.readLine();
        Console.write("Enter a password: ");
        String password = Console.readLine();
        Console.write("Enter your name: ");
        String name = Console.readLine();
        Console.write("Enter your NIF: ");
        String nif = Console.readLine();
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
            Customer newCustomer = new Customer(username, password, name, nif, dateOfBirth, phoneNumber, mobileNumber, email, profession);
            customerService.addCustomer(newCustomer);

            Console.writeLine("===================Customer registered successfully===================");
            Console.writeLine("Username: " + newCustomer.getUsername());
            Console.writeLine("Name: " + newCustomer.getName());
            Console.writeLine("NIF: " + newCustomer.getNif());
            Console.writeLine("Date of Birth: " + newCustomer.getDateOfBirth());
            Console.writeLine("Phone Number: " + newCustomer.getPhoneNumber());
            Console.writeLine("Mobile Number: " + newCustomer.getMobileNumber());
            Console.writeLine("Email: " + newCustomer.getEmail());
            Console.writeLine("Profession: " + newCustomer.getProfession());
            Console.writeLine("======================================================================");
        } catch (IllegalArgumentException e) {
            Console.writeLine(e.getMessage());
        }
    }
}




