package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.RoomDatabase;
import model.RoomsReservationsDatabase;

public class ReservationService {

    public static ReservationService getInstance() {
        return new ReservationService();
    }

    public Collection<Reservation> getAllReserviations() {

        try {
            Collection<Reservation> reservations = new ArrayList<Reservation>();

            RoomsReservationsDatabase
                    .getInstance()
                    .values()
                    .forEach(reservation -> {
                        reservations.addAll(reservation);
                    });

            return reservations;

        } catch (Exception e) {
            throw e;
        }

    }

    public Collection<IRoom> getAllRooms() {
        return RoomDatabase.getInstance().values();
    }

    public void addRoom(IRoom room) throws Exception {
        try {
            RoomDatabase.getInstance().addRoom(room);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public ArrayList<Reservation> getReserviationsByCustomerEmail(String customerEmail) {

        ArrayList<Reservation> reservations = new ArrayList<Reservation>();

        getAllReserviations().forEach(reservation -> {
            if (reservation.getCustomer().getEmail().equals(customerEmail)) {
                reservations.add(reservation);
            }
        });

        return reservations;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            return RoomsReservationsDatabase.getInstance().addReservation(customer, room, checkInDate, checkOutDate);

        } catch (Exception e) {
            throw e;
        }
    }

    public IRoom getARoom(String roomId) {
        try {
            return RoomDatabase.getInstance().get(roomId);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) throws Exception {

        if (checkInDate.after(checkOutDate)) {
            throw new Exception("Check-in date must happen before check-out date");
        }

        if (checkInDate.before(new Date())) {
            throw new Exception("Check-in date must happen after today");
        }

        try {
            return RoomsReservationsDatabase.getInstance().findRooms(checkInDate, checkOutDate);
        } catch (Exception e) {
            throw e;
        }
    }

}
