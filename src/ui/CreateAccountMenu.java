package ui;

import java.util.Scanner;

import api.HotelResource;

public class CreateAccountMenu {

    private String firstName = "";
    private String lastName  = "";
    private String email = "";
    private boolean isRunning = true;

    public CreateAccountMenu() {
        this.isRunning = true;
    }

    public void displayForm() {
        System.out.println("Fill out the form below to create an account.");

        System.out.print("Your first name: ");
        System.out.println(this.firstName == null || firstName.isBlank() ? "....." : firstName);

        System.out.print("Your last name: ");
        System.out.println(lastName == null || lastName.isBlank() ? "....." : lastName);

        System.out.print("Your email: ");
        System.out.println(email == null || email.isBlank() ? "....." : email);

        System.out.println("");
        System.out.println("Select an option below:");
        System.out.println("1. Edit your first name");
        System.out.println("2. Edit your last name");
        System.out.println("3. Edit your email");
        System.out.println("4. Submit the form");
        System.out.println("5. Go back to the main menu");

    }

    public void run(Scanner scanner) {
        while (isRunning) {
            displayForm();
            try {
                scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                System.out.println("Your choice: " + choice);

                switch (choice) {
                    case 1:
                        System.out.print("Enter your first name: ");
                        scanner = new Scanner(System.in);
                        firstName = scanner.nextLine();
                        break;
                    case 2:
                        System.out.print("Enter your last name: ");
                        scanner = new Scanner(System.in);
                        lastName = scanner.nextLine();
                        break;
                    case 3:
                        System.out.print("Enter your email: ");
                        scanner = new Scanner(System.in);
                        email = scanner.nextLine();
                        break;
                    case 4:
                        try {
                            HotelResource.getInstance().createACustomer(firstName, lastName, email);
                            System.out.println("-------------------------------------");
                            System.out.println("| Succesfully created your account! |");
                            System.out.println("-------------------------------------");
                            firstName = "";
                            lastName = "";
                            email = "";
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());

                            if (e.getMessage().equals("Invalid email address.")) {
                                System.out.println("-----------------------------------------------");
                                System.out.println("| Invalid email, please try a different email |");
                                System.out.println("-----------------------------------------------");
                            }
                        }
                        break;
                    case 5:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("-------------------------------------");
                        System.out.println("| Invalid choice, please try again! |");
                        System.out.println("-------------------------------------");
                        System.out.println("");
                        break;
                }

            } catch (Exception e) {
                // System.out.println(e.getMessage());
                System.out.println("---------------------------------");
                System.out.println("| INVALID INPUT!!!! Try again! |");
                System.out.println("---------------------------------");
                System.out.println("");
            }
        }
    }
}
