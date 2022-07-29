package api;

public class APItestor {
    public static void main(String[] args) {

        HotelResource hotelResource = HotelResource.getInstance();
        AdminResource adminResource = AdminResource.getInstance();

        try {
            hotelResource.createACustomer("duc", "vu", "d@d.com");
            hotelResource.createACustomer("john", "vu", "d1@d.com");
            adminResource.getAllCustomers().forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
