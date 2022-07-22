package model;

import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private final String emailRegex = "^(.+)@(.+).com$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) {

        // validate email with regex here
        if (pattern.matcher(email).matches()) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        } else {
            throw new IllegalArgumentException("Error, Invalid email");
        }
    }

    // override to string
    @Override
    public String toString() {
        return String.format(
                "Customer{firstName='%s', lastName='%s', email='%s'}",
                firstName,
                lastName,
                email);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer other = (Customer) obj;
            return this.email.equals(other.email);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    public String getEmail() {
        return this.email;
    }

}
