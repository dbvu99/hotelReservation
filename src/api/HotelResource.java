package api;

import java.util.Collection;
import java.util.Date;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {
    public Customer getCustomer(String customerEmail) {
        return CustomerService.getInstance().getCustomer(customerEmail);

    }

    public void createACustomer(String email, String firstName, String lastName) {
        CustomerService.getInstance().addCustomer(email, firstName, lastName);
    }

    public IRoom getARoom(String roomId) {
        return  ReservationService.getInstance().getARoom(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        return ReservationService.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        return ReservationService.getInstance().getReserviationsByCustomerEmail(customerEmail);
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return ReservationService.getInstance().findRooms(checkInDate, checkOutDate);
    }



}
