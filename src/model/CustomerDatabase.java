package model;

import java.util.HashMap;
import java.util.Map;

public class CustomerDatabase extends HashMap<String, Customer> {
    private static final long serialVersionUID = 1L;
    private static CustomerDatabase instance = null;

    public CustomerDatabase() {
        super();
    }

    // public static CustomerDatabase getInstance() {
    // return instance != null ? instance : new CustomerDatabase();
    // }

    @Override
    public Customer get(Object key) {
        return super.get(key);
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
            if (this.get(customer.getEmail()) != null) {
                throw new Exception("Email must be unqiue.");
            }

            this.put(customer.getEmail(), customer);

        } catch (Exception e) {
            throw e;
        }
    }
}
