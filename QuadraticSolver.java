import java.util.Scanner;

public class QuadraticSolver {

    public void demonstration() {
        findRoots(2, 4, 1);
        findRoots(1, 2, 1);
        findRoots(5, 1, 1);
        findRoots(0, 1, 0);
        findRoots(0, 0, 0);
        findRoots("x", "y", "z");
    }

    public String findRoots(Object aIn, Object bIn, Object cIn){
        try {
            int a = (Integer) aIn;
            int b = (Integer) bIn;
            int c = (Integer) cIn;
        } catch (Exception e) {
            System.out.println("One or more of your inputs were invalid. Sorry");
            System.out.println("Error Message: " + e.getMessage());
        }
        return "";
    }

    public static void main(String[] args) {

        QuadraticSolver qSolver = new QuadraticSolver();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Demonstration or Actual Uses? (0,1)");
            String temp = scanner.nextLine();
            if (Integer.valueOf(temp) != 0 || Integer.valueOf(temp) != 1) {
                System.out.println("Invalid response.");
                return;
            }
            if (Integer.valueOf(temp) == 0) {
                qSolver.demonstration();
                return;
            } else {
                
                return;
            }
        } catch (Exception e) {
            System.out.println("You submitted an invalid value.");
            System.out.println("Error: " + e.getMessage());
        }

    }

}
