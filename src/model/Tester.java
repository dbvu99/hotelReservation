package model;

import java.sql.Date;

public class Tester {
    public static void main(String[] args) {
        Room room = new Room("111", 50.0, RoomType.DOUBLE);
        System.out.println(room);
        FreeRoom freeRoom = new FreeRoom("222", 0.0, RoomType.SINGLE);
        System.out.println(freeRoom);
        Customer customer = new Customer("John", "Doe", "j@domain.com");
        System.out.println(customer);
        Reservation reservation = new Reservation(
                customer,
                room,
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2)
                );
        System.out.println(reservation);
        
        // test email validation
        Customer badCustomer = new Customer("John", "Doe", "bad email");
        System.out.println(badCustomer);
    }
}
