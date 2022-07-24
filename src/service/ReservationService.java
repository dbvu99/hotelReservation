package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {

    private static final ArrayList<IRoom> ROOMS = new ArrayList<IRoom>();
    private static final ArrayList<Reservation> RESERVATIONS = new ArrayList<Reservation>();
    private static final HashMap<IRoom, ArrayList<Reservation>> RESERVATIONS_BY_ROOM = new HashMap<IRoom, ArrayList<Reservation>>();


    public static ReservationService getInstance() {
        return new ReservationService();
    }

    public  HashMap<IRoom, ArrayList<Reservation>> getReservationsByAllRooms() {
        return RESERVATIONS_BY_ROOM;
    }

    public ArrayList<Reservation> getAllReserviations() {

        ArrayList<Reservation> allReservations = new ArrayList<Reservation>();

        RESERVATIONS_BY_ROOM.values().forEach(allReservations::addAll);

        return allReservations;
    }

    public Collection<IRoom> getAllRooms() {
        return ROOMS;
    }

    public void addRoom(IRoom room) {
        try {
            ROOMS.add(room);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public ArrayList<Reservation> getReserviations() {
        return RESERVATIONS;
    }

    public ArrayList<Reservation> getReserviationsByCustomerEmail(String customerEmail) {

        ArrayList<Reservation> reservationsByCustomerEmail = new ArrayList<Reservation>();

        for (int i = 0; i < RESERVATIONS.size(); i++) {
            if (RESERVATIONS.get(i).getCustomer().getEmail().equals(customerEmail)) {
                reservationsByCustomerEmail.add(RESERVATIONS.get(i));
            }
        }

        return reservationsByCustomerEmail;
    }

   

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        RESERVATIONS.add(reservation);

        if (RESERVATIONS_BY_ROOM.containsKey(room)) {
            RESERVATIONS_BY_ROOM.get(room).add(reservation);
        } else {
            ArrayList<Reservation> reservations = new ArrayList<Reservation>();
            reservations.add(reservation);
            RESERVATIONS_BY_ROOM.put(room, reservations);
        }

        return reservation;
    }

    public  IRoom getARoom(String roomId)  {
        for (int i = 0; i < ROOMS.size(); i++) {
            if (ROOMS.get(i).getRoomNumber().equals(roomId)) {
                return ROOMS.get(i);
            }
        }
        return null;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) throws Exception {

        if (checkInDate.after(checkOutDate)) {
            throw new Exception("Check-in date must happen before check-out date");
        }

        try {


            ArrayList<IRoom> availableRooms = new ArrayList<IRoom>(0);


            if (ROOMS.isEmpty()) {
                return availableRooms;
            }

            for (IRoom room : ROOMS) {
                if (isRoomAvailable(room, checkInDate, checkOutDate)) {
                    availableRooms.add(room);
                }
            }
            
            return availableRooms;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isRoomAvailable(IRoom room, Date checkInDate, Date checkOutDate) {

        if (RESERVATIONS_BY_ROOM.get(room) == null) {
            return true;
        }

        for (Reservation reservation : RESERVATIONS_BY_ROOM.get(room)) {
            if (reservation.isOverlapped(checkInDate, checkOutDate)) {
                return false;
            }
        }

        return true;
    }
    
    public void printAllReservation() {
        System.out.println(RESERVATIONS);
    }

    public void displayAllReservations() {
    }
 

}
