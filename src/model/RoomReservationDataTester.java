package model;

import java.util.Date;

public class RoomReservationDataTester {
    public static void main(String[] args) {
        try {
            Room room101 = new Room("100", 100.0, RoomType.DOUBLE);


            Reservation reservation1 = new Reservation(
                new Customer("John0", "Doe", "j@d.com"),
                room101,
                new Date(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2));
            
            Reservation reservation5 = new Reservation(
                new Customer("John1", "Doe", "j@d.com"),
                room101,
                new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 4));
                

            Reservation reservation2 = new Reservation(
                new Customer("John4", "Doe", "j@d.com"),
                room101,
                new Date(System.currentTimeMillis()  + 1000 * 60 * 60 * 24 * 13),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 17));
                

            Reservation reservation3 = new Reservation(
                new Customer("John2", "Doe", "j@d.com"),
                room101,
                new Date(System.currentTimeMillis()  + 1000 * 60 * 60 * 24 * 8),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 9));


            Reservation reservation4 = new Reservation(
                new Customer("John3", "Doe", "j@d.com"),
                room101,
                new Date(System.currentTimeMillis()  + 1000 * 60 * 60 * 24 * 5),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7));
            
            RoomsReservationsDatabase.getInstance().addReservation(room101, reservation2);
            RoomsReservationsDatabase.getInstance().addReservation(room101, reservation5);
            RoomsReservationsDatabase.getInstance().addReservation(room101, reservation3);
            RoomsReservationsDatabase.getInstance().addReservation(room101, reservation4);
            RoomsReservationsDatabase.getInstance().addReservation(room101, reservation1);

            RoomsReservationsDatabase.getInstance().get(room101).forEach(item -> System.out.println(item));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
