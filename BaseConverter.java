import java.util.Scanner;

public abstract class BaseConverter {
    protected Scanner input = new Scanner(System.in);

    // abstract method to display the menu (needs to be implemented in subclasses)
    public abstract void displayMenu();

    // abstract method to perform the conversion based on user's choice (needs to be implemented in subclasses)
    public abstract void performConversion(int choice);

    // concrete method to run the converter
    public void runConverter() {
        // start an infinite loop that keeps the program running until user exits
        while (true) {
            displayMenu();

            // ask the user to input a choice
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            if (choice == 0) {
                System.out.println("Exiting converter... \n ");
                break;
            }
            performConversion(choice);
        }
    }
}
