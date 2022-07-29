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

    private static ReservationService instance = null;
    private static RoomDatabase roomDatabase = RoomDatabase.getInstance();
    private static RoomsReservationsDatabase roomsReservationsDatabase = RoomsReservationsDatabase.getInstance();

    private ReservationService() {
        super();
    }

    public static ReservationService getInstance() {
        return instance == null ? new ReservationService() : instance;
    }

    public Collection<Reservation> getAllReserviations() {

        try {
            Collection<Reservation> reservations = new ArrayList<Reservation>();

            roomsReservationsDatabase
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
        return roomDatabase.values();
    }

    public void addRoom(IRoom room) throws Exception {
        try {
            roomDatabase.addRoom(room);
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
            return roomsReservationsDatabase.addReservation(customer, room, checkInDate, checkOutDate);

        } catch (Exception e) {
            throw e;
        }
    }

    public IRoom getARoom(String roomId) {
        try {
            return roomDatabase.get(roomId);
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

        // System.out.println("rooms");
        // this.getAllRooms().forEach(room -> {
        // System.out.println(room);
        // });

        try {
            return roomsReservationsDatabase.findRooms(checkInDate, checkOutDate, roomDatabase.getAllRooms());
        } catch (Exception e) {
            throw e;
        }
    }

}
