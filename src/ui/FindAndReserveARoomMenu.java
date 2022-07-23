package ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.IMenu;
import model.IRoom;
import model.Menu;

public class FindAndReserveARoomMenu extends Menu implements IMenu {

    private Date checkInDate = null;
    private Date checkOutDate = null;
    private ArrayList<IRoom> availableRooms = new ArrayList<>(0);

    private final String DATE_FORMAT_PATTERN = "m/d/yyyy";
    private final DateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT_PATTERN);

    public FindAndReserveARoomMenu() {
        super();
    }

    public void displayAvailbleRooms() {
        System.out.println("Available rooms:");

        if (checkInDate == null || checkOutDate == null) {
            System.out.println("- Please enter a check in and check out date to see available rooms.");
            System.out.println("");
            return;
        }

        if (availableRooms.size() == 0) {
            System.out.println("No rooms are available for the specified dates.");
            return;
        }

        // System.out.println("Available rooms:");
        // for (IRoom room : availableRooms) {
        //     System.out.println(room.getRoomNumber());
        // }

    }

    private void displayMenu() {

        System.out.println("");
        System.out.println("Enter the booking details below to see available rooms:");
        System.out.print("- Check-in Date: ");
        System.out.println(checkInDate == null ? "....." : checkInDate);

        System.out.print("- Check-out Date: ");
        System.out.println(checkOutDate == null ? "....." : checkOutDate);
        System.out.println("");

        displayAvailbleRooms();

        System.out.println("Select an option below:");
        System.out.println("1. Enter a check-in date");
        System.out.println("2. Enter a check-out date");
        System.out.println("3. Reserve a room");
        System.out.println("5. Go back to the main menu");
        System.out.println("________________________________________________");
        System.out.print("Enter your choice: ");
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
                System.out.println("Your choice: " + choice);
                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter a check-in date (m/d/yyyy): ");
                            scanner = new Scanner(System.in);
                            String ciDate = scanner.nextLine();
                            checkInDate = DATE_FORMATTER.parse(ciDate);
                            System.out.println("You have selected " + ciDate + " as your check-in date.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            displayInValidDateFeedback();
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Enter a check-out date (m/d/yyyy): ");
                            scanner = new Scanner(System.in);
                            String coDate = scanner.nextLine();
                            checkOutDate = DATE_FORMATTER.parse(coDate);
                            System.out.println("You have selected " + coDate + " as your check-out date.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            displayInValidDateFeedback();
                        }
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
