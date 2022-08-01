package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class RoomsReservationsDatabase extends HashMap<IRoom, ReservationOrderedList> {
    private static final long serialVersionUID = 1L;
    private static RoomsReservationsDatabase instance = null;
    // private static RoomDatabase roomDatabase = RoomDatabase.getInstance();

    private RoomsReservationsDatabase() {
        super();
    }

    public static RoomsReservationsDatabase getInstance() {
        return instance != null ? instance : new RoomsReservationsDatabase();
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
        // System.out.println(room.getRoomNumber());
        try {
            ReservationOrderedList reservations = this.get(room);

            if (reservations == null) {
                return true;
            }

            return reservations.isNotOverlapped(checkInDate, checkOutDate);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate, Collection<IRoom> roomDatabase) {
        try {

            Collection<IRoom> rooms = new ArrayList<IRoom>();

            for (IRoom room : roomDatabase) {
                if (isRoomAvailable(room, checkInDate, checkOutDate)) {
                    rooms.add(room);
                }
            }

            return rooms;
        } catch (Exception e) {
            throw e;
        }
    }

}
