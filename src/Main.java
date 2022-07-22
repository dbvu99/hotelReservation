import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {

        printMenu();
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean exit = false;

        while (!exit) {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Find and reserve a room");
                    break;
                case 2:
                    System.out.println("See my reservations");
                    break;
                case 3:
                    System.out.println("Create an account");
                    break;
                case 4:
                    System.out.println("Admin");
                    break;
                case 5:
                    System.out.println("Exit");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        scanner.close();

    }
}