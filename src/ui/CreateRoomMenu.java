package ui;

import java.util.Scanner;

import api.AdminResource;
import model.IMenu;
import model.Menu;
import model.RoomType;

public class CreateRoomMenu extends Menu implements IMenu {

    public CreateRoomMenu() {
        super();
    }

    @Override
    public void run(Scanner scanner) {
        while (isRunning) {
            System.out.println("");
            System.out.println("Add a room");
            System.out.println("");
            System.out.println("1. Add a single-bed room");
            System.out.println("2. Add a double-bed room");
            System.out.println("3. Add a free room");
            System.out.println("4. Add test rooms");
            System.out.println("5. Back");
            System.out.println("________________________________________________");
            System.out.print("Enter your option: ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addSingleRoom(scanner);
                        break;
                    case 2:
                        addMultipleRooms(scanner);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        isRunning = false;
                        System.out.println("Bye!");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("INVALID INPUT!!!! Try again!\n");
            }
        }
    }

    private void addMultipleRooms(Scanner scanner) {
        boolean isSuccess = false;

        while (!isSuccess) {
            try {
                System.out.println("");
                System.out.println("Add a double room");
                System.out.println("");
                System.out.println("Room Type: " + RoomType.DOUBLE);
                System.out.println("Room number:");
                System.out.print("Enter room number: ");
                scanner = new Scanner(System.in);
                String roomNumber = scanner.nextInt() + "";
                System.out.print("Room cost per night:");
                scanner = new Scanner(System.in);
                double roomCost = scanner.nextDouble();
                AdminResource.getInstance().addOneRoom(roomNumber, roomCost, RoomType.DOUBLE);
                isSuccess = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                displayErroredInputFeedback();
            }
        }
    }

    private void addSingleRoom(Scanner scanner) {
        boolean isSuccess = false;

        while (!isSuccess) {
            try {
                System.out.println("");
                System.out.println("Add a single room");
                System.out.println("");
                System.out.println("Room Type: " + RoomType.SINGLE);
                System.out.println("Room number:");
                System.out.print("Enter room number: ");
                scanner = new Scanner(System.in);
                String roomNumber = scanner.nextInt() + "";
                System.out.print("Room cost per night:");
                scanner = new Scanner(System.in);
                double roomCost = scanner.nextDouble();
                AdminResource.getInstance().addOneRoom(roomNumber, roomCost, RoomType.SINGLE);
                isSuccess = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                displayErroredInputFeedback();
            }
        }
    }
    
}
