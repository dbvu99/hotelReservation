package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {

    private static final ArrayList<IRoom> ROOMS = new ArrayList<IRoom>();
    private static final ArrayList<Reservation> RESERVATIONS = new ArrayList<Reservation>();


    public static ReservationService getInstance() {
        return new ReservationService();
    }

    public Collection<IRoom> getAllRooms() {
        return ROOMS;
    }

    public void addRoom(IRoom room) {
        ROOMS.add(room);
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

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        if (checkInDate.after(checkOutDate)) {
            throw new IllegalArgumentException("Check-in date must happen before check-out date");
        }

        ArrayList<IRoom> availableRooms = new ArrayList<IRoom>();

        for (int i = 0; i < RESERVATIONS.size(); i++) {
            if (RESERVATIONS.get(i).isAvailable(checkInDate, checkOutDate)) {
                availableRooms.add(RESERVATIONS.get(i).getRoom());
            }

        }
        
        return availableRooms;
    }
    
    public void printAllReservation() {
        System.out.println(RESERVATIONS);
    }

    public void displayAllReservations() {
    }
 

}
