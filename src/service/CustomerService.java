package service;

import java.util.ArrayList;
import java.util.Collection;

import model.Customer;

public class CustomerService {

    private static final ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();

    public static CustomerService getInstance() {
        return new CustomerService();
    }

    public  void addCustomer(String email, String firstName, String lastName) {
        try {
            Customer newCustomer = new Customer(email, firstName, lastName);
            CUSTOMERS.add(newCustomer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public  Customer getCustomer(String customerEmail)  {
        for (int i = 0; i < CUSTOMERS.size(); i++) {

            if (CUSTOMERS.get(i).getEmail().equals(customerEmail)) {
                return CUSTOMERS.get(i);
            }
        }
        return null;
    }

    public  Collection<Customer> getAllCustomers() {
        return CUSTOMERS;
    }


}
