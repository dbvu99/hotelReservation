package model;

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
    
    public boolean addReservation(IRoom room, Reservation reservation) {
        try {
            if (this.get(room) == null) {
                ReservationOrderedList reservations = new ReservationOrderedList();
                reservations.addReservation(reservation);
                this.put(room, reservations);
                return true;
            } else {
                return this.get(room).addReservation(reservation);
            }
        } catch (NullPointerException e) {
            throw e;
        }
    }

}
