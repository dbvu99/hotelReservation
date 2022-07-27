package api;

import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.CustomerDatabase;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {


    public Customer getCustomer(String customerEmail) {
        try {
            return CustomerService.getInstance().getCustomer(customerEmail);
        } catch (Exception e) {
            throw e;
        }
    }


    public void createACustomer(String firstName, String lastName, String email) throws Exception {
        try {
            CustomerService.getInstance().addCustomer(firstName, lastName, email);
        } catch (Exception e) {
            throw e;
        }

    }

    public IRoom getARoom(String roomId) {
        try {
            return ReservationService.getInstance().getARoom(roomId);
        } catch (Exception e) {
            throw e;
        }
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            return ReservationService.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        try {
            return ReservationService.getInstance().getReserviationsByCustomerEmail(customerEmail);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) throws Exception {
        try {
            return ReservationService.getInstance().findRooms(checkInDate, checkOutDate);
        } catch (Exception e) {
            throw e;
        }
    }

    public static HotelResource getInstance() {
        return new HotelResource();
    }

}
