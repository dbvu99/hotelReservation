package model;


public class Menu {
    protected boolean isRunning;

    public Menu() {
        this.isRunning = true;
    }

    protected void displayInvalidChoiceFeedback() {
        System.out.println("-------------------------------------");
        System.out.println("| Invalid choice, please try again! |");
        System.out.println("-------------------------------------");
        System.out.println("");
    }

    protected void displayErroredInputFeedback() {
        System.out.println("---------------------------------");
        System.out.println("| INVALID INPUT!!!! Try again! |");
        System.out.println("---------------------------------");
        System.out.println("");
    }
}
