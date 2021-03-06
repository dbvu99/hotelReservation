package service;

import java.text.SimpleDateFormat;

import model.Customer;
import model.Room;
import model.RoomType;

public class ReservationServiceTestor {
        public static void main(String[] args) {
                // TODO Auto-generated method stub

                SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
                ReservationService reservationService = ReservationService.getInstance();
                Customer customer = new Customer("John", "Doe", "j@d.com");

                try {
                        reservationService.addRoom(new Room("100", 100.0, RoomType.DOUBLE));
                        reservationService.addRoom(new Room("101", 100.0, RoomType.DOUBLE));
                        reservationService.addRoom(new Room("102", 100.0, RoomType.DOUBLE));
                        reservationService.addRoom(new Room("103", 100.0, RoomType.DOUBLE));
                        reservationService.addRoom(new Room("104", 100.0, RoomType.DOUBLE));
                        reservationService.addRoom(new Room("105", 100.0, RoomType.DOUBLE));

                        System.out.println("rooms");
                        reservationService.getAllRooms().forEach(room -> {
                                System.out.println(room);
                        });

                        System.out.println("available rooms");
                        reservationService.findRooms(sdf.parse("3/29/2023"), sdf.parse("4/29/2023")).forEach(room -> {
                                System.out.println(room);
                        });

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("101"),
                                                        sdf.parse("3/29/2023"),
                                                        sdf.parse("4/29/2023"));
                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("102"),
                                                        sdf.parse("3/29/2023"),
                                                        sdf.parse("4/29/2023"));
                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("103"),
                                                        sdf.parse("3/29/2023"),
                                                        sdf.parse("4/29/2023"));
                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("104"),
                                                        sdf.parse("3/29/2023"),
                                                        sdf.parse("4/29/2023"));
                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("105"),
                                                        sdf.parse("3/29/2023"),
                                                        sdf.parse("4/29/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("3/29/2023"),
                                                        sdf.parse("4/29/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("2/28/2023"),
                                                        sdf.parse("4/29/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("2/28/2023"),
                                                        sdf.parse("3/08/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("2/28/2023"),
                                                        sdf.parse("3/08/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("2/25/2023"),
                                                        sdf.parse("3/06/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("2/22/2023"),
                                                        sdf.parse("2/27/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("3/25/2023"),
                                                        sdf.parse("3/28/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("2/25/2023"),
                                                        sdf.parse("2/28/2023"));

                        reservationService
                                        .reserveARoom(customer,
                                                        reservationService.getARoom("100"),
                                                        sdf.parse("3/26/2023"),
                                                        sdf.parse("3/27/2023"));

                        System.out.println("reservations");
                        reservationService.getAllReserviations()
                                        .forEach(reservation -> System.out.println(reservation));

                        // System.out.println("rooms");
                        // reservationService.getAllRooms().forEach(room -> {
                        // System.out.println(room);
                        // });

                        System.out.println("available rooms");
                        reservationService.findRooms(sdf.parse("3/29/2023"), sdf.parse("4/29/2023")).forEach(room -> {
                                System.out.println(room);
                        });

                        System.out.println("available rooms");
                        reservationService.findRooms(sdf.parse("3/21/2023"), sdf.parse("3/22/2023")).forEach(room -> {
                                System.out.println(room);
                        });

                        System.out.println("available rooms");
                        reservationService.findRooms(sdf.parse("3/26/2023"), sdf.parse("4/27/2023")).forEach(room -> {
                                System.out.println(room);
                        });

                        System.out.println("available rooms");
                        reservationService.findRooms(sdf.parse("3/26/2023"), sdf.parse("4/27/2023")).forEach(room -> {
                                System.out.println(room);
                        });

                        System.out.println("available rooms");
                        reservationService.findRooms(sdf.parse("8/26/2022"), sdf.parse("8/27/2022")).forEach(room -> {
                                System.out.println(room);
                        });

                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        System.out.println(e);
                }
        }
}
