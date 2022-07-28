package api;

import java.util.Collection;
import java.util.List;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

public class AdminResource {

    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();

    private static AdminResource instance = null;

    private AdminResource() {
    }

    public static AdminResource getInstance() {
        return instance == null ? new AdminResource() : instance;
    }

    public Customer getCustomer(String customerEmail) {
        return customerService.getCustomer(customerEmail);
    }

    public void addRooms(List<IRoom> rooms) throws Exception {
        for (IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        Collection<Reservation> reservations = reservationService.getAllReserviations();
        if (reservations.isEmpty()) {
            System.out.println("--------------------------");
            System.out.println("| No reservations found! |");
            System.out.println("--------------------------");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    public void addOneRoom(String roomNumber, double roomCost, RoomType enumuration) throws Exception {
        try {
            reservationService.addRoom(new Room(roomNumber, roomCost, enumuration));
            System.out.println("Room added successfully");
            System.out.println("");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
