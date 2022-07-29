package service;

import java.text.SimpleDateFormat;

import model.Customer;
import model.Room;
import model.RoomType;

public class ReservationServiceTestor2 {
        public static void main(String[] args) {
                // TODO Auto-generated method stub

                SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
                ReservationService reservationService = ReservationService.getInstance();
                Customer customer = new Customer("John", "Doe", "j@d.com");

                try {
                        reservationService.addRoom(new Room("100", 100.0, RoomType.DOUBLE));

                        System.out.println("rooms");
                        reservationService.getAllRooms().forEach(room -> {
                                System.out.println(room);
                        });

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
