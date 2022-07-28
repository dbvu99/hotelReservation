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
import model.Reservation;
import model.Room;
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

            ArrayList<IRoom> availableRooms = (ArrayList<IRoom>) HotelResource.getInstance().findRooms(checkInDate,
                    checkOutDate);

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

    private void displayOption3(Scanner scanner) {
        boolean isRunningOption3 = true;

        while (isRunningOption3) {
            try {
                isRunningOption3 = false;
                IRoom room = null;
                boolean isRunningRoom = true;
                while (isRunningRoom) {
                    System.out.print("Enter the room number, or 999 to go back to the menu option: ");
                    scanner = new Scanner(System.in);
                    try {
                        int roomNumber = scanner.nextInt();

                        if (roomNumber == 999) {
                            isRunningRoom = false;
                            // this break terminate current interation of the loop
                            break;
                        }

                        room = HotelResource.getInstance().getARoom(roomNumber + "");
                        if (room == null) {
                            System.out.println("- Room number " + roomNumber + " does not exist. Try again.");
                            isRunningRoom = true;
                        } else {
                            isRunningRoom = false;
                        }

                    } catch (Exception e) {
                        System.out.println("");
                        System.out.println("Invalid room number, please try again!");
                        isRunningRoom = true;
                    }
                }

                boolean isRunningCustomer = true;
                Customer customer = null;
                while (isRunningCustomer) {
                    System.out.print("Enter the customer's email, or 999 to go back to the menu option: ");
                    scanner = new Scanner(System.in);
                    try {
                        String customerEmail = scanner.nextLine();

                        if (customerEmail.equals("999")) {
                            isRunningCustomer = false;
                            // this break terminate current interation of the loop
                            break;
                        }

                        customer = HotelResource.getInstance().getCustomer(customerEmail);
                        if (customer == null) {
                            System.out.println(
                                    "- Customer with email " +
                                            customerEmail +
                                            " does not exist. Try again.");

                            isRunningCustomer = true;
                        } else {
                            isRunningCustomer = false;
                        }
                    } catch (Exception e) {
                        System.out.println("");
                        System.out.println("Invalid customer email, please try again!");
                        isRunningCustomer = true;
                    }
                }

                System.out.println("");
                System.out.println("Reserving room " + room.getRoomNumber() + " for " + customer.getFirstName() + " "
                        + customer.getLastName() + "...");

                try {
                    Reservation newReservation = ReservationService
                            .getInstance()
                            .reserveARoom(customer, room, checkInDate, checkOutDate);

                    if (newReservation == null) {
                        System.out.println(
                                "- Room " + room.getRoomNumber() + " is not available for the specified dates.");
                    } else {
                        System.out.println("- Room " +
                                room.getRoomNumber() +
                                " is reserved for " +
                                customer.getFirstName() + " " +
                                customer.getLastName() + " for the dates " + DATE_FORMATTER.format(checkInDate) + " to "
                                + DATE_FORMATTER.format(checkOutDate));

                        isRunningOption3 = false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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
                        boolean isRunningCheckInDate = true;

                        while (isRunningCheckInDate || checkInDate == null) {
                            try {
                                System.out.print("Enter a check-in date (M/d/yyyy): ");
                                scanner = new Scanner(System.in);
                                String ciDate = scanner.nextLine();
                                checkInDate = DATE_FORMATTER.parse(ciDate);

                                if (checkInDate != null) {
                                    // System.out.println(checkInDate.before(new Date()));
                                    if (checkInDate.before(new Date())) {
                                        System.out.println(
                                                "- Check-in date cannot be in the past. Try a different date.");
                                        checkInDate = null;
                                        isRunningCheckInDate = true;

                                    } else {
                                        System.out.println(
                                                "You have selected " +
                                                        checkInDate +
                                                        " as your check-in date.");
                                        isRunningCheckInDate = false;
                                    }

                                } else {
                                    displayInValidDateFeedback();
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                displayInValidDateFeedback();
                            }
                        }
                        break;
                    case 2:
                        boolean isRunningCheckOutDate = true;
                        while (isRunningCheckOutDate || checkOutDate == null) {
                            try {
                                System.out.print("Enter a check-out date (M/d/yyyy): ");
                                scanner = new Scanner(System.in);
                                String coDate = scanner.nextLine();
                                checkOutDate = DATE_FORMATTER.parse(coDate);
                                if (checkOutDate != null) {

                                    if (checkOutDate.before(new Date())) {
                                        System.out.println(
                                                "- Check-out date cannot be in the past. Try a different date.");
                                        checkOutDate = null;
                                        isRunningCheckOutDate = true;
                                    } else {
                                        System.out.println(
                                                "You have selected " +
                                                        checkOutDate +
                                                        " as your check-out date.");
                                        isRunningCheckOutDate = false;
                                    }

                                } else {
                                    displayInValidDateFeedback();
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                displayInValidDateFeedback();
                            }
                        }
                        break;
                    case 3:
                        displayOption3(scanner);
                        break;
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
