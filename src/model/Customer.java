package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private final static String EMAIL_REGEX = "^(.+)@(.+).com$";

    public Customer(String firstName, String lastName, String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        // System.out.println("Customer email: " + matcher.matches());

        if (matcher.matches()) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email address.");
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    // override to string
    @Override
    public String toString() {
        return String.format(
                "{\sfirstName=%s, lastName=%s, email=%s\s}",
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
