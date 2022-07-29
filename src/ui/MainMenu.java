package ui;

import java.util.Collection;
import java.util.Scanner;

import api.HotelResource;
import model.Reservation;

public class MainMenu {

    private static boolean isRunning = true;
    private static HotelResource hotelResource = HotelResource.getInstance();

    public void displayHome() {

        while (isRunning) {

            try {
                System.out.println("1. Find and reserve a room");
                System.out.println("2. See my reservations");
                System.out.println("3. Create an account");
                System.out.println("4. Admin");
                System.out.println("5. Exit");
                System.out.println("________________________________________________");
                System.out.print("Enter your option: ");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        FindAndReserveARoomMenu findAndReserveARoomMenu = new FindAndReserveARoomMenu();
                        findAndReserveARoomMenu.run(scanner);
                        break;
                    case 2:
                        printMyReservationsMenu(scanner);
                        break;
                    case 3:
                        CreateAccountMenu menu = new CreateAccountMenu();
                        menu.run(scanner);
                        break;
                    case 4:
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.run(scanner);
                        break;
                    case 5:
                        isRunning = false;
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again!");
                        break;
                }

                // scanner.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("INVALID INPUT!!!! Try again!\n");
            }

        }

    }

    private void printMyReservationsMenu(Scanner scanner) {
        boolean isRunningOption2 = true;

        while (isRunningOption2) {
            System.out.println("");
            System.out.println("Please enter your email address (mail@domain.com): ");
            scanner.nextLine();
            try {
                String email = scanner.nextLine();
                if (email.isEmpty()) {
                    System.out.println("Email cannot be empty!");
                } else {
                    System.out.println("");
                    System.out.println("Your reservations: ");
                    System.out.println("");

                    Collection<Reservation> reservations = hotelResource.getCustomersReservations(email);
                    if (reservations.isEmpty()) {
                        System.out.println("You have no reservations!");
                    } else {
                        hotelResource.getCustomersReservations(email).forEach(System.out::println);
                        System.out.println("");
                    }
                    isRunningOption2 = false;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
