package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class RoomsReservationsDatabase extends HashMap<IRoom, ReservationOrderedList> {
    private static final long serialVersionUID = 1L;
    private static RoomsReservationsDatabase instance = new RoomsReservationsDatabase();
    
    private RoomsReservationsDatabase() {
        super();
    }
    
    public static RoomsReservationsDatabase getInstance() {
        return instance;
    }

    public void addReservationByRoom(IRoom room, Reservation reservation) {
        try {
            if (this.get(room) == null) {
                ReservationOrderedList reservations = new ReservationOrderedList();
                reservations.addReservation(reservation);
                this.put(room, reservations);
            } else {
                this.get(room).addReservation(reservation);
            }
        } catch (NullPointerException e) {
            throw e;
        }
    }


    public Reservation addReservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            if (this.get(room) == null) {
                ReservationOrderedList reservations = new ReservationOrderedList();
                Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
                reservations.add(reservation);
                this.put(room, reservations);
                return reservation;
            } else {
                return this.get(room).addNewReservation(customer, room, checkInDate, checkOutDate);
            }
        } catch (NullPointerException e) {
            throw e;
        }
    }


    public boolean isRoomAvailable(IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            ReservationOrderedList reservations = this.get(room);

            
            if (reservations == null) {
                return true;
            }

            // System.out.println("Size: " + reservations.size());
            
            return reservations.isNotOverlapped(checkInDate, checkOutDate);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        // System.out.println("Find rooms "  + checkInDate + " " + checkOutDate);
        try {

            Collection<IRoom> rooms = new ArrayList<IRoom>();

            for (IRoom room : RoomDatabase.getInstance().values()) {
                if (this.isRoomAvailable(room, checkInDate, checkOutDate)) {
                    rooms.add(room);
                }
            }

            
            return rooms;
        } catch (Exception e) {
            throw e;
        }
    }


}
