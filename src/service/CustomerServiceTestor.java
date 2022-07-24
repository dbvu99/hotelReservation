package service;

public class CustomerServiceTestor {

    public static void main(String[] args) {
        
        try {
            CustomerService.getInstance().addCustomer("Duc", "Vu", "duc@domain.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            CustomerService.getInstance().addCustomer("John", "Vu", "john@domain.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            CustomerService.getInstance().addCustomer("David", "Vu", "david@domain.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            CustomerService.getInstance().addCustomer("Tuan", "Vu", "tuan@domain.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {   
            System.out.println("test");
            CustomerService.getInstance().addCustomer("Tuan", "Vu", "tuan@domain.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // adding customer with bad email
        try {
            CustomerService.getInstance().addCustomer("Duc", "Vu", "bad email");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(CustomerService.getInstance().getAllCustomers().toString());

        // get customer by email
        System.out.println(CustomerService.getInstance().getCustomer("tuan@domain.com").toString());
        System.out.println(CustomerService.getInstance().getCustomer("nonExist@mail.com").toString());
    }


}
