package service;

public class CustomerServiceTestor {

    public static void main(String[] args) {

        CustomerService.getInstance().addCustomer("Duc", "Vu", "duc@domain.com");
        CustomerService.getInstance().addCustomer("John", "Vu", "john@domain.com");
        CustomerService.getInstance().addCustomer("David", "Vu", "david@domain.com");
        CustomerService.getInstance().addCustomer("Tuan", "Vu", "tuan@domain.com");

        // adding customer with bad email
        CustomerService.getInstance().addCustomer("Duc", "Vu", "bad email");

        System.out.println(CustomerService.getInstance().getAllCustomers().toString());

        // get customer by email
        System.out.println(CustomerService.getInstance().getCustomer("tuan@domain.com").toString());
        System.out.println(CustomerService.getInstance().getCustomer("nonExist@mail.com").toString());
    }


}
