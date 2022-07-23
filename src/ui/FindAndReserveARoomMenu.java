package ui;

import java.util.Scanner;

import model.IMenu;
import model.Menu;

public class FindAndReserveARoomMenu extends Menu implements IMenu {

    public FindAndReserveARoomMenu() {
        super();
    }

    private void displayMenu() {
        System.out.println("1. Find a room");
        System.out.println("2. Reserve a room");
        System.out.println("3. Go back to the main menu");
        System.out.println("________________________________________________");
        System.out.print("Enter your choice: ");
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
                        // FindARoomMenu menu = new FindARoomMenu();
                        // menu.run(scanner);
                        break;
                    case 2:
                        // ReserveARoomMenu menu2 = new ReserveARoomMenu();
                        // menu2.run(scanner);
                        break;
                    case 3:
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
