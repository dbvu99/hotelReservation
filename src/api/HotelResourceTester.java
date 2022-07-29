package api;

import java.text.SimpleDateFormat;

import model.Customer;
import model.Room;
import model.RoomType;
import service.ReservationService;

public class HotelResourceTester {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        ReservationService reservationService = ReservationService.getInstance();
        Customer customer = new Customer("John", "Doe", "j@d.com");
        HotelResource hotelResource = HotelResource.getInstance();

        try {
            reservationService.addRoom(new Room("100", 100.0, RoomType.DOUBLE));
            // reservationService.addRoom(new Room("101", 100.0, RoomType.DOUBLE));
            // reservationService.addRoom(new Room("102", 100.0, RoomType.DOUBLE));
            // reservationService.addRoom(new Room("103", 100.0, RoomType.DOUBLE));
            // reservationService.addRoom(new Room("104", 100.0, RoomType.DOUBLE));
            // reservationService.addRoom(new Room("105", 100.0, RoomType.DOUBLE));

            System.out.println(hotelResource.reserveARoom(
                    customer,
                    reservationService.getARoom("100"),
                    sdf.parse("8/8/2022"), sdf.parse("8/16/2022")));

            System.out.println("available rooms");
            reservationService.findRooms(sdf.parse("3/29/2023"),
                    sdf.parse("4/29/2023")).forEach(room -> {
                        System.out.println(room);
                    });

            System.out.println("reservations");
            reservationService.getAllReserviations().forEach(reservation -> {
                System.out.println(reservation);
            });

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
