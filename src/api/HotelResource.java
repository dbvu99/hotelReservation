package api;

import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {

    private Customer customer;

    // public Customer getCustomer(String customerEmail) {
    //     return CustomerService.getInstance().getCustomer(customerEmail);
    // }

    public Customer getCustomer(String customerEmail) {
        return customer;
    }

    // public void createACustomer(String firstName, String lastName, String email) {
    //     try {
    //         CustomerService.getInstance().addCustomer(firstName, lastName, email);
    //     } catch (IllegalArgumentException e) {
    //         throw new IllegalArgumentException(e.getMessage());
    //     }
    // }


    public void createACustomer(String firstName, String lastName, String email) {
        customer = new Customer(firstName, lastName, email);
    }

    public IRoom getARoom(String roomId) {
        return ReservationService.getInstance().getARoom(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        return ReservationService.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return ReservationService.getInstance().getReserviationsByCustomerEmail(customerEmail);
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
