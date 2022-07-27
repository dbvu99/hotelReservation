package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import api.AdminResource;
import api.HotelResource;
import model.Customer;
import model.IMenu;
import model.IRoom;
import model.Menu;
import service.ReservationService;

public class FindAndReserveARoomMenu extends Menu implements IMenu {

    private Date checkInDate = null;
    private Date checkOutDate = null;
    private ArrayList<IRoom> availableRooms = new ArrayList<>(0);

    private final String DATE_FORMAT_PATTERN = "M/d/yyyy";
    private final DateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT_PATTERN);

    public FindAndReserveARoomMenu() {
        super();
    }

    public void displayAvailbleRooms() {

        try {
            System.out.println("Available rooms:");

            if (checkInDate == null || checkOutDate == null) {
                System.out.println("- Please enter a check in and check out date to see available rooms.");
                System.out.println("");
                return;
            }

            if (checkInDate.after(checkOutDate)) {
                System.out.println("- Check in date must be before check out date.");
                System.out.println("");
                return;
            }

            ArrayList<IRoom> availableRooms = (ArrayList<IRoom>) HotelResource.getInstance().findRooms(checkInDate, checkOutDate);

            if (availableRooms.size() == 0) {
                System.out.println("- No rooms are available for the specified dates.");
                return;
            } else {
                for (IRoom room : availableRooms) {
                    System.out.println(room);
                }
                return;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void displayMenu() {

        if (AdminResource.getInstance().getAllRooms().size() == 0) {
            System.out.println("");
            System.out.println("There is no room in the hotel. Please go to the Admin menu to add a room first.");
        }

        System.out.println("");
        System.out.println("Enter the booking details below to see available rooms:");
        System.out.print("- Check-in Date: ");
        System.out.println(checkInDate == null ? "....." : checkInDate);

        System.out.print("- Check-out Date: ");
        System.out.println(checkOutDate == null ? "....." : checkOutDate);
        System.out.println("");

        displayAvailbleRooms();

        System.out.println("Select an option below:");
        System.out.println("1. Edit the check-in date");
        System.out.println("2. Edit the check-out date");
        System.out.println("3. Reserve a room");
        System.out.println("5. Go back to the main menu");
        System.out.println("________________________________________________");
        System.out.print("Enter your option: ");
    }
    
    private void displayInValidDateFeedback() {
        System.out.println("-------------------------------------");
        System.out.println("| Invalid date, please try again! |");
        System.out.println("-------------------------------------");
        System.out.println("");
    }

    @Override
    public void run(Scanner scanner) {

        while (isRunning) {
            displayMenu();
            try {
                scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                // System.out.println("Your choice: " + choice);
                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter a check-in date (M/d/yyyy): ");
                            scanner = new Scanner(System.in);
                            String ciDate = scanner.nextLine();
                            checkInDate = DATE_FORMATTER.parse(ciDate);
                            System.out.println("You have selected " + checkInDate + " as your check-in date.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            displayInValidDateFeedback();
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter a check-out date (M/d/yyyy): ");
                            scanner = new Scanner(System.in);
                            String coDate = scanner.nextLine();
                            checkOutDate = DATE_FORMATTER.parse(coDate);
                            System.out.println("You have selected " + checkOutDate + " as your check-out date.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            displayInValidDateFeedback();
                        }
                        break;
                    case 3:
                        try {
                            System.out.print("Enter the room number: ");
                            scanner = new Scanner(System.in);
                            int roomNumber = scanner.nextInt();
                            IRoom room = HotelResource.getInstance().getARoom(roomNumber + "");
                            boolean isRunningRoom = true;
                            while (isRunningRoom && room == null) {
                                System.out.println("Room number " + roomNumber + " does not exist.");
                                System.out.print("Enter the another room number, or 99 to go back to the menu: ");
                                scanner = new Scanner(System.in);
                                roomNumber = scanner.nextInt();
                                if (roomNumber == 99) {
                                    break;
                                }
                                room = HotelResource.getInstance().getARoom(roomNumber + "");
                            }

                            System.out.println("You have selected room " + roomNumber + ".");
                            System.out.println("");
                            System.out.println("Please enter the customer details below:");
                            System.out.print("Customer email: ");
                            scanner = new Scanner(System.in);
                            String guestEmail = scanner.nextLine();
                            Customer customer = HotelResource.getInstance().getCustomer(guestEmail);
                            boolean isRunningEmail = true;
                            while (isRunningEmail && customer == null) {
                                System.out.println("Customer with email " + guestEmail + " does not exist.");
                                System.out.print("Please enter the customer email, or enter 99 to return to menu: ");
                                scanner = new Scanner(System.in);
                                guestEmail = scanner.nextLine();
                                if (guestEmail.equals("99")) {
                                    isRunningEmail = false;
                                }
                                customer = HotelResource.getInstance().getCustomer(guestEmail);
                            }
                            System.out.println("Adding room...");
                            ReservationService.getInstance().reserveARoom(customer, room, checkInDate, checkOutDate);
                            System.out.println("Room " + roomNumber + " has been reserved for " + customer.getFirstName() + " " + customer.getLastName() + ".");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    case 5:
                        isRunning = false;
                        System.out.println("Bye!");
                        break;
                    default:
                        displayInvalidChoiceFeedback();
                        break;
                }
            } catch (Exception e) {
                displayErroredInputFeedback();
            }
        }
        
    }
}
