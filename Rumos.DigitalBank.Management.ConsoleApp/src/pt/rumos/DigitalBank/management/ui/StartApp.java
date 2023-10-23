package pt.rumos.DigitalBank.management.ui;

import pt.rumos.DigitalBank.management.utils.Console;
import pt.rumos.digitalBank.management.services.AuthService;

public class StartApp {

    public static void start() {
        System.out.println("Welcome to Rumos Digital Bank App");

        AuthService login = null;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Authenticate as an existing customer");
            System.out.println("2. Register as a new customer");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(Console.readLine());

            case 1:
                System.out.print("Username: ");
                String username = Console.readLine();
                System.out.print("Password: ");
                String password = Console.readLine();
                login = AuthService.getInstance();
                login.login(username, password);

                if (login.isAuthenticated()) {
                    System.out.println("Hello, " + login.getAuthenticatedUser().getName());

                    switch (login.getAuthenticatedUser().getRole()) {
                        case ATM:
                            Atm.start();
                            break;
                        case MANAGEMENT:
                            Management.start();
                            break;
                    }
                } else {
                    System.out.println("Wrong credentials");
                }

                break;
            case 2:
                System.out.print("Enter a username: ");
                String newUsername = Console.readLine();
                System.out.print("Enter a password: ");
                String newPassword = Console.readLine();
                System.out.print("Enter your name: ");
                String name = Console.readLine();
                System.out.print("Enter your date of birth (yyyy-MM-dd): ");
                String dateOfBirth = Console.readLine();
                System.out.print("Enter your phone number: ");
                String phone = Console.readLine();
                System.out.print("Enter your mobile number: ");
                String mobile = Console.readLine();
                System.out.print("Enter your email: ");
                String email = Console.readLine();
                System.out.print("Enter your profession: ");
                String profession = Console.readLine();


        }

    }
}



