package ui;

import java.util.Scanner;


public class MainMenu {

    private static boolean isRunning = true;

    public void displayHome() {

        while(isRunning) {

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

    private void printAdminMenu(Scanner scanner) {
    }

    private void printCreateAccountMenu(Scanner scanner) {
        
    }

    private void printMyReservationsMenu(Scanner scanner) {
    }

    private void printFindAndReserveARoomMenu(Scanner scanner) {
    }
    
}
