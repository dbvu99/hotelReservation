package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
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


            Reservation reservation6 = new Reservation(
                new Customer("John6", "Doe", "j@d.com"),
                room101,
                new Date(System.currentTimeMillis()  + 1000 * 60 * 60 * 24 * 22),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 29));
            
            RoomsReservationsDatabase.getInstance().addReservationByRoom(room101, reservation2);
            RoomsReservationsDatabase.getInstance().addReservationByRoom(room101, reservation5);
            RoomsReservationsDatabase.getInstance().addReservationByRoom(room101, reservation3);
            RoomsReservationsDatabase.getInstance().addReservationByRoom(room101, reservation4);
            RoomsReservationsDatabase.getInstance().addReservationByRoom(room101, reservation1);
            RoomsReservationsDatabase.getInstance().addReservationByRoom(room101, reservation6);
            RoomsReservationsDatabase.getInstance().get(room101).forEach(item -> System.out.println(item));

            Collection<IRoom> rooms = RoomsReservationsDatabase.getInstance().findRooms(
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 1),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 5));

            Collection<IRoom> rooms2 = RoomsReservationsDatabase.getInstance().findRooms(
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 10),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 12));


            Collection<IRoom> rooms3 = RoomsReservationsDatabase.getInstance().findRooms(
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 10),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 14));


            Collection<IRoom> rooms4 = RoomsReservationsDatabase.getInstance().findRooms(
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30),
                    new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 33));



            SimpleDateFormat df = new SimpleDateFormat("M/d/yyyy");


            Collection<IRoom> rooms5 = RoomsReservationsDatabase.getInstance().findRooms(df.parse("8/12/2022"), df.parse("8/16/2022"));

            System.out.println("case 1");
            rooms.forEach(item -> System.out.println(item));
                
            System.out.println("case 2");
            rooms2.forEach(item -> System.out.println(item));

            System.out.println("case 3");
            rooms3.forEach(item -> System.out.println(item));

            System.out.println("case 4");
            rooms4.forEach(item -> System.out.println(item));
            
            System.out.println("case 5");
            rooms5.forEach(item -> System.out.println(item));

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
