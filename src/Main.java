import java.io.Console;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

public class Main {
    public static void populateTestData() {
        CustomerService.getInstance().addCustomer("Nguyen", "Duc", "duc@mail.com");



        ReservationService.getInstance().addRoom(new Room("101", 100.00, RoomType.SINGLE));


        Room room101 = new Room("101", 10.00, RoomType.SINGLE);

        Customer customer = new Customer("Duc", "Vu", "duc@bluespace.com");

        // Reservation reservation = new Reservation(customer, room101, new Date(), new Date());

        ReservationService.getInstance().addRoom(room101);

        ReservationService.getInstance().reserveARoom(customer, room101, new Date(), new Date());

        System.out.println(ReservationService.getInstance().getReservationsByAllRooms().toString());
        System.out.println(ReservationService.getInstance().getReservationsByAllRooms().keySet().toString());
        System.out.println(ReservationService.getInstance().getAllReserviations().toString());

        System.out.println(room101.hashCode());
        System.out.println((new Room("101", 10.00, RoomType.SINGLE).hashCode()));
    }

    public static void printMenu() {
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("________________________________________________");
        System.out.print("Enter your option: ");
    }

    public static void printFindAndReserveARoomMenu(Scanner scanner) {
        System.out.println("1. Find and reserve a room");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. Back");

        System.out.print("Enter your option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                printFindARoomMenu(scanner);
                break;
            case 2:
                printMenu();
                break;
            default:
                System.out.println("Invalid choice");
                printFindAndReserveARoomMenu(scanner);
                break;
        }
    }

    private static void printFindARoomMenu(Scanner scanner) {
    }

    public static Date pickADate(Scanner scanner) {
        System.out.println("Select the date (1-31)");
        int date = scanner.nextInt();
        System.out.println("Select the month (1-12)");
        int month = scanner.nextInt();
        System.out.println("Select the year (YYYY)");
        int year = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date);
        return calendar.getTime();
    }

    public static void findAndReserveARoom(Scanner scanner) {
        System.out.println("Follow the instruction to select a check in date:");
        Date checkInDate = pickADate(scanner);
        System.out.println(checkInDate);

        System.out.println("Follow the instruction to select a check out date:");
        Date checkOutDate = pickADate(scanner);
        System.out.println(checkOutDate);

        Collection<IRoom> rooms = HotelResource.getInstance().findRooms( checkInDate, checkOutDate);
        System.out.println("Available rooms:");

        for (IRoom room : rooms) {
            System.out.println(room.toString());
        }


        System.out.println("Enter the ID of the room you want to reserve:");
        String roomId = scanner.nextLine();
        IRoom room = HotelResource.getInstance().getARoom(roomId);
        System.out.println("Enter a customer email:");
        String customerEmail = scanner.nextLine();
        Customer customer = HotelResource.getInstance().getCustomer(customerEmail);
        Reservation reservation = HotelResource.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
        System.out.println("Reservation: " + reservation.toString());

    }

    public static void createACustomer(Scanner scanner) {

        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        try {
            HotelResource.getInstance().createACustomer(firstName, lastName, email);
            for (Customer customer : CustomerService.getInstance().getAllCustomers()) {
                System.out.println(customer.toString());
            }
        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

    }


    public static void main(String[] args) {

        // only for testing
        populateTestData();

        // Scanner scanner = new Scanner(System.in);
        // String choice = "";
        // boolean exit = false;
        // try {
        //     while (!exit) {
        //         printMenu();
        //         choice = scanner.nextLine();
        //         switch (choice) {
        //             case "1":
        //                 System.out.println("Find and reserve a room");
        //                 findAndReserveARoom(scanner);
        //                 break;
        //             case "2":
        //                 System.out.println("See my reservations");
        //                 break;
        //             case "3":
        //                 System.out.println("Create an account");
        //                 createACustomer(scanner);
        //                 break;
        //             case "4":
        //                 System.out.println("Admin");
        //                 break;
        //             case "5":
        //                 System.out.println("Exit");
        //                 exit = true;
        //                 break;
        //             default:
        //                 System.out.println("Invalid choice, please try again!");
        //                 break;
        //         }
        //     }
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // scanner.close();

    }
}