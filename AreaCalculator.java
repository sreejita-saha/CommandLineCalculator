//area calculator of shapes but also max area finder
import java.sql.SQLOutput;
import java.util.Scanner;
public class AreaCalculator {
    Scanner input = new Scanner(System.in);

    private void Triangle() {
        double base = 0;
        double perpendHeight = 0;

        System.out.print("Enter the length of base: ");
        base = input.nextDouble();

        System.out.print("Enter the perpendicular height: ");
        perpendHeight = input.nextDouble();

        double area = 0.5*base*perpendHeight;

        System.out.println("Area is: " + area);
    }

    public void main(String[] args) {
        Triangle();
    }

}
