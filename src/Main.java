import java.io.Console;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

public class Main {
    public static void main(String[] args) throws Exception {
        AdminResource.getInstance().addOneRoom("101", 100.0, RoomType.SINGLE);
        AdminResource.getInstance().addOneRoom("102", 200.0, RoomType.SINGLE);
        AdminResource.getInstance().addOneRoom("104", 300.0, RoomType.SINGLE);

        System.out.println(AdminResource.getInstance().getAllRooms());


        Collection<IRoom> rooms = HotelResource.getInstance().findRooms(new Date(), new Date());


        HotelResource.getInstance().reserveARoom(new Customer("D", "V", "d@m.com"), (IRoom) rooms.toArray()[0],
                new Date(), new Date());

        System.out.println(AdminResource.getInstance().getAllCustomers());
        AdminResource.getInstance().displayAllReservations();
        
        System.out.println(HotelResource.getInstance().findRooms(new Date(), new Date()));
    }


}