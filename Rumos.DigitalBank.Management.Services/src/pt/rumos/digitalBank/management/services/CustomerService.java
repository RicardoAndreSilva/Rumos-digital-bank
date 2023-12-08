package pt.rumos.digitalBank.management.services;

import pt.rumos.DigitalBank.management.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final static CustomerService INSTANCE;


    private final List<Customer> registeredCustomers;

    static {
        INSTANCE = new CustomerService();

    }


    private CustomerService() {
        registeredCustomers = new ArrayList<>();
    }

    public static CustomerService getInstance() {
        return INSTANCE;
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(registeredCustomers);
    }

    public Customer getCustomerByNif(int nif) {
        for (Customer customer : registeredCustomers) {
            if (customer.getNif() == nif) {
                return customer;

            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        for (Customer existingCustomer : registeredCustomers) {
            if (existingCustomer.getNif() == customer.getNif()) {
                throw new IllegalArgumentException("Customer with NIF " + customer.getNif() + " already exists.");
            }

        }
        registeredCustomers.add(customer);
    }

    public void deleteCustomerByNif(int nif) {
        Customer customerToDelete = getCustomerByNif(nif);
        if (customerToDelete != null) {
            registeredCustomers.remove(customerToDelete);
        } else {
            throw new IllegalArgumentException("Customer with NIF " + nif + " not found.");
        }
    }

    public void updateCustomer(int nif, Customer updatedCustomer) {
        Customer customerToUpdate = getCustomerByNif(nif);
        if (customerToUpdate != null) {
            customerToUpdate.setName(updatedCustomer.getName());
            customerToUpdate.setDateOfBirth(updatedCustomer.getDateOfBirth());
            customerToUpdate.setPhoneNumber(updatedCustomer.getPhoneNumber());
            customerToUpdate.setMobileNumber(updatedCustomer.getMobileNumber());
            customerToUpdate.setEmail(updatedCustomer.getEmail());
            customerToUpdate.setProfession(updatedCustomer.getProfession());
            customerToUpdate.setPassword(updatedCustomer.getPassword());
            customerToUpdate.setUsername(updatedCustomer.getUsername());


            System.out.println("Customer with NIF " + nif + " updated successfully.");
        } else {
            throw new IllegalArgumentException("Customer with NIF " + nif + " not found. Cannot update.");
        }
    }

}