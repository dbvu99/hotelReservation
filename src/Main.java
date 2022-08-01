
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.RoomType;

public class Main {
    public static void main(String[] args) throws Exception {
        // AdminResource.getInstance().addOneRoom("101", 100.0, RoomType.SINGLE);
        // AdminResource.getInstance().addOneRoom("102", 200.0, RoomType.SINGLE);
        // AdminResource.getInstance().addOneRoom("104", 300.0, RoomType.SINGLE);

        // System.out.println(AdminResource.getInstance().getAllRooms());

        // Collection<IRoom> rooms = HotelResource.getInstance().findRooms(new Date(),
        // new Date());

        // HotelResource.getInstance().reserveARoom(new Customer("D", "V", "d@m.com"),
        // (IRoom) rooms.toArray()[0],
        // new Date(), new Date());

        // System.out.println(AdminResource.getInstance().getAllCustomers());
        // AdminResource.getInstance().displayAllReservations();

        // System.out.println(HotelResource.getInstance().findRooms(new Date(), new
        // Date()));

        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers.add(new Customer("D", "V", "duc@mail.com"));
        customers.add(new Customer("D", "V", "duc2@mail.com"));
        customers.add(new Customer("D", "V", "duc1@mail.com"));
        customers.add(new Customer("D", "V", "duc3@mail.com"));
        customers.add(new Customer("D", "V", "duc4@mail.com"));

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getEmail() == "duc@mail.com") {
                System.out.println(customers.get(i));
            }
        }

        System.out.println(customers);
    }

}
