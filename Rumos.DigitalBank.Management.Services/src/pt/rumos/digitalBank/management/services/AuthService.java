package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.Customer;


import java.util.List;

public class AuthService {
    private final static AuthService INSTANCE;
    private Customer authenticatedCustomer;
    private final CustomerService customerService;
    private boolean isLoggedIn;

    static {
        INSTANCE = new AuthService(); // Eager loading
    }

    private AuthService() {

        customerService = CustomerService.getInstance();
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
        List<Customer> registeredCustomers = customerService.getAllCustomers();
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


