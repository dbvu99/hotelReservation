package model;

import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase extends HashMap<String, Customer> {
    private static final long serialVersionUID = 1L;
    private static CustomerDatabase instance = null;

    private CustomerDatabase() {
        super();
    }

    public static CustomerDatabase getInstance() {
        return instance != null ? instance : new CustomerDatabase();
    }

    public Customer getCustomer(String email) {
        try {
            return this.get(email);
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public void addCustomer(Customer customer) throws Exception {
        try {
            if (CustomerDatabase.getInstance().get(customer.getEmail()) != null) {
                throw new Exception("Email must be unqiue.");
            }

            CustomerDatabase.getInstance().put(customer.getEmail(), customer);

        } catch (Exception e) {
            throw e;
        }
    }
}
