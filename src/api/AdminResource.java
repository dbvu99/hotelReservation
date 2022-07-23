package api;

import java.util.Collection;
import java.util.List;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

public class AdminResource {

    public static AdminResource getInstance() {
        return new AdminResource();
    }

    public Customer getCustomer(String customerEmail) {
        return CustomerService.getInstance().getCustomer(customerEmail);
    }

    public void addRooms(List<IRoom> rooms) {
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

    public void addOneRoom(String roomNumber, double roomCost, RoomType enumuration) {
        try {
            ReservationService.getInstance().addRoom(new Room(roomNumber, roomCost, enumuration));
            System.out.println("Room added successfully");
            System.out.println("");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
