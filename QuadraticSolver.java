import java.util.Scanner;

public class QuadraticSolver {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
        System.out.println("Demonstration or Actual Uses? (0,1)");
        String temp = scanner.nextLine();
        if (Integer.valueOf(temp) != 0 || Integer.valueOf(temp) != 1) {
            System.out.println("Invalid response.");
            return;
        }
        } catch (Exception e) {
            System.out.println("You submitted an invalid value.");
        }
        
    }

}
