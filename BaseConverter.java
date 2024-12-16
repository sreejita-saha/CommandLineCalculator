import java.util.Scanner;
public abstract class BaseConverter {
    protected Scanner input = new Scanner(System.in);

    public abstract void displayMenu();
    public abstract void performConversion(int choice);

    public void runConverter() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            if (choice == 0) {
                System.out.println("Exiting converter...");
                break;
            }
            performConversion(choice);
        }
    }
}
