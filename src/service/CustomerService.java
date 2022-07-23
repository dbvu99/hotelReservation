package service;

import java.util.ArrayList;
import java.util.Collection;

import model.Customer;

public class CustomerService {

    private static final ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();

    public static CustomerService getInstance() {
        return new CustomerService();
    }

    public  void addCustomer(String firstName, String lastName, String email) {
        try {
            Customer newCustomer = new Customer(firstName, lastName, email);
            CUSTOMERS.add(newCustomer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public  Customer getCustomer(String customerEmail)  {
        for (int i = 0; i < CUSTOMERS.size(); i++) {

            if (CUSTOMERS.get(i).getEmail().equals(customerEmail)) {
                return CUSTOMERS.get(i);
            }
        }

        throw new IllegalArgumentException("Customer with email " + customerEmail + " does not exist.");
    }

    public  Collection<Customer> getAllCustomers() {
        return CUSTOMERS;
    }


}
