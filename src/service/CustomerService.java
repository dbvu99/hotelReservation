package service;

import java.util.ArrayList;
import java.util.Collection;

import model.Customer;
import model.CustomerDatabase;

public class CustomerService {

    private static CustomerDatabase customerDatabase = CustomerDatabase.getInstance();

    private static CustomerService instance = null;

    private CustomerService() {
        super();
    }

    public static CustomerService getInstance() {
        return instance == null ? new CustomerService() : instance;
    }

    public void addCustomer(String firstName, String lastName, String email) throws Exception {
        try {
            Customer customer = new Customer(firstName, lastName, email);
            customerDatabase.addCustomer(customer);
        } catch (Exception e) {
            throw e;
        }
    }

    public Customer getCustomer(String customerEmail) {
        try {
            return customerDatabase.get(customerEmail);
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public Collection<Customer> getAllCustomers() {
        try {
            return customerDatabase.values();
        } catch (NullPointerException e) {
            return new ArrayList<Customer>();
        }
    }

}
