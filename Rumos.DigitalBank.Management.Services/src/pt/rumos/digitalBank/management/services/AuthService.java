package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private final static AuthService INSTANCE;
    private Customer authenticatedCustomer;
    private List<Customer> registeredCustomers;
    private boolean isLoggedIn;

    static {
        INSTANCE = new AuthService(); // Eager loading
    }

    private AuthService() {
        registeredCustomers = new ArrayList<>();
    }

    public static AuthService getInstance() {
        return INSTANCE;
    }

    public boolean isAuthenticated() {
        return isLoggedIn;
    }

    public Customer getAuthenticatedCustomer() {
        return authenticatedCustomer;
    }

    public boolean login(String username, String password) {
        for (Customer customer : registeredCustomers) {
            if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                authenticatedCustomer = customer;
                isLoggedIn = true;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        authenticatedCustomer = null;
        isLoggedIn = false;
    }
}

