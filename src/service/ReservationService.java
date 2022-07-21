package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {

    private static ArrayList<IRoom> rooms = new ArrayList<IRoom>();
    private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public static ReservationService getInstance() {
        return new ReservationService();
    }

    public void addRoom(IRoom room) {
        rooms.add(room);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public  IRoom getARoom(String roomId)  {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber().equals(roomId)) {
                return rooms.get(i);
            }
        }
        return null;
    }

    public ArrayList<IRoom> findRooms(Date checkInDate, Date checkOutDate) {

        if (checkInDate.after(checkOutDate)) {
            throw new IllegalArgumentException("Check-in date must happen before check-out date");
        }

        ArrayList<IRoom> availableRooms = new ArrayList<IRoom>();

        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).isAvailable(checkInDate, checkOutDate)) {
                availableRooms.add(reservations.get(i).getRoom());
            }

        }
        
        return availableRooms;
    }
    
    public void printAllReservation() {
        System.out.println(reservations);
    }
 

}
