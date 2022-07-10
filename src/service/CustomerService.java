package service;

import java.util.ArrayList;
import java.util.Collection;

import model.Customer;

public class CustomerService {

    private static Collection<Customer> customers = new ArrayList<Customer>();


    public static void addCustomer(String email, String firstName, String lastName) {

        try {
            Customer newCustomer = new Customer(email, firstName, lastName);
            customers.add(newCustomer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Customer getCustomer(String customerEmail)  {
        for (int i = 0; i < customers.size(); i++) {

            if (((ArrayList<Customer>) customers).get(i).getEmail().equals(customerEmail)) {
                return ((ArrayList<Customer>) customers).get(i);
            }
        }
        return null;
    }

    public static Collection<Customer> getAllCustomers() {
        return customers;
    }

}
