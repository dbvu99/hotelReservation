package api;

import java.util.Collection;
import java.util.List;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

public class AdminResource {

    public static AdminResource getInstance() {
        return new AdminResource();
    }

    public Customer getCustomer(String customerEmail) {
        return CustomerService.getInstance().getCustomer(customerEmail);
    }

    public void addRoom(List<IRoom> rooms) {
        for (IRoom room : rooms) {
            ReservationService.getInstance().addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return ReservationService.getInstance().getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return CustomerService.getInstance().getAllCustomers();
    }

    public void displayAllReservations() {
        System.out.println(ReservationService.getInstance().getReserviations().toString());
    }
}
