package api;

import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {

    private static ReservationService reservationService = ReservationService.getInstance();
    private static CustomerService customerService = CustomerService.getInstance();

    private static HotelResource instance = null;

    private HotelResource() {
    }

    public static HotelResource getInstance() {
        return instance == null ? new HotelResource() : instance;
    }

    public Customer getCustomer(String customerEmail) {
        try {
            return customerService.getCustomer(customerEmail);
        } catch (Exception e) {
            throw e;
        }
    }

    public void createACustomer(String firstName, String lastName, String email) throws Exception {
        try {
            customerService.addCustomer(firstName, lastName, email);
        } catch (Exception e) {
            throw e;
        }

    }

    public IRoom getARoom(String roomId) {
        try {
            return reservationService.getARoom(roomId);
        } catch (Exception e) {
            throw e;
        }
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        try {
            return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        try {
            return reservationService.getReserviationsByCustomerEmail(customerEmail);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) throws Exception {
        try {
            return reservationService.findRooms(checkInDate, checkOutDate);
        } catch (Exception e) {
            throw e;
        }
    }

}
