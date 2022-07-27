package ui;

import java.util.Scanner;

import api.AdminResource;
import api.HotelResource;
import model.IMenu;
import model.IRoom;
import model.Menu;
import model.Room;
import model.RoomType;

public class AdminMenu extends Menu implements IMenu {
    public AdminMenu() {
        super();
    }

    public void displayMenu() {
        System.out.println("");
        System.out.println("Admin Menu");
        System.out.println("");
        System.out.println("1. Display all reservations");
        System.out.println("2. Display all rooms");
        System.out.println("3. Display all customers");
        System.out.println("4. Add a room");
        System.out.println("5. Exit");
        System.out.println("________________________________________________");
        System.out.print("Enter your option: ");
    }
    

    @Override
    public void run(Scanner scanner) {
        while (isRunning) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        displayAllReservations();
                        break;
                    case 2:
                        displayAllRooms();
                        break;
                    case 3:
                        displayAllCustomers();
                        break;
                    case 4:
                        CreateRoomMenu createRoomMenu = new CreateRoomMenu();
                        createRoomMenu.run(scanner);
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
                System.out.println(e.getMessage());
                displayErroredInputFeedback();
            }
        }
    }

    private void displayAllRooms() {
        System.out.println("");
        System.out.println("All rooms");
        if (AdminResource.getInstance().getAllRooms().size() == 0) {
            System.out.println("No rooms found");
        } else {
            for (IRoom room : AdminResource.getInstance().getAllRooms()) {
                System.out.println(room);
            }
        }
        System.out.println("");
    }

    private void displayAllCustomers() {
    }

    private void displayAllReservations() {
        AdminResource.getInstance().displayAllReservations();
    }
    
}
