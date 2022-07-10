package service;

public class CustomerServiceTestor {

    public static void main(String[] args) {

        CustomerService.addCustomer("Duc", "Vu", "duc@domain.com");
        CustomerService.addCustomer("John", "Vu", "john@domain.com");
        CustomerService.addCustomer("David", "Vu", "david@domain.com");
        CustomerService.addCustomer("Tuan", "Vu", "tuan@domain.com");

        // adding customer with bad email
        CustomerService.addCustomer("Duc", "Vu", "bad email");

        System.out.println(CustomerService.getAllCustomers().toString());

        // get customer by email
        System.out.println(CustomerService.getCustomer("tuan@domain.com").toString());
        System.out.println(CustomerService.getCustomer("nonExist@mail.com").toString());
    }


}
