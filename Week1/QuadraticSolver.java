package Week1;

import java.util.Arrays;
import java.util.Scanner;

public class QuadraticSolver {

    public static void main(String[] args) {

        QuadraticSolver qSolver = new QuadraticSolver();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Demonstration or Actual Uses? (0,1)");
            String temp = scanner.nextLine();
            if (Integer.parseInt(temp) != 0 && Integer.parseInt(temp) != 1) {
                System.out.println("Invalid response.");
                scanner.close();
                return;
            }
            if (Integer.valueOf(temp) == 0) {
                qSolver.demonstration();
                scanner.close();
                return;
            } else {
                while (true) {
                    System.out.println("Please submit a value for a");
                    String a = scanner.nextLine();
                    System.out.println("Please submit a value for b");
                    String b = scanner.nextLine();
                    System.out.println("Please submit a value for c");
                    String c = scanner.nextLine();
                    qSolver.findRoots(a, b, c);
                }
            }
        } catch (Exception e) {
            System.out.println("You submitted an invalid value.");
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    public void demonstration() {
        findRoots(2, 4, 1);
        findRoots(1, 2, 1);
        findRoots(5, 1, 1);
        findRoots(0, 1, 0);
        findRoots(0, 0, 0);
        findRoots("x", "y", "z");
    }

    public void findRoots(Object aIn, Object bIn, Object cIn) {
        try {
            System.out.println("Your inputs were " + aIn.toString() + " " + bIn.toString() + " " + cIn.toString());
            Double a = (double) aIn;
            Double b = (double) bIn;
            Double c = (double) cIn;

            Double ansOne = null;
            Double ansTwo = null;

            switch (processEquation(a, b, c)) {
                case TWO_REAL:
                    ansOne = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                    ansTwo = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                    System.out.println("Your answers are " + ansOne.toString() + " and " + ansTwo.toString());
                    break;
                case ONE_REAL:
                    ansOne = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                    System.out.println("Your answer is " + ansOne.toString());
                    break;
                case TWO_COMPLEX:
                    System.out.println("The answer is: -" + b + "/" + (2 * a) + " ± i*sqrt(" + -((b * b) - (4 * a * c))
                            + ")/" + 2 * a);
                    break;
                case LINEAR_ONE:
                    System.out.println("The answer is: -" + c / b);
                    break;
                case LINEAR_ZERO:
                    System.out.println(
                            "Your inputs produced a linear equation parallel to the x-axis which cannot intersect the x-axis by definition.");
                    break;
                default:
                    System.out.println("Something has gone wrong.");
                    break;
            }
            return;
        } catch (Exception e) {
            System.out.println("One or more of your inputs were invalid. Your inputs: " + aIn.toString() + " "
                    + bIn.toString() + " " + cIn.toString());
            System.out.println("Error Message: " + e.getMessage());
        }
        return;
    }

    enum EquationStates {
        TWO_REAL,
        ONE_REAL,
        TWO_COMPLEX,
        LINEAR_ONE,
        LINEAR_ZERO,
        INVALID
    }

    public EquationStates processEquation(Double aIn, Double bIn, Double cIn) {
        if (aIn == 0) {
            if (bIn == 0) {
                return EquationStates.LINEAR_ZERO;
            } else {
                return EquationStates.LINEAR_ONE;
            }
        }
        Double underRoot = Math.pow(bIn, 2) - (4 * aIn * cIn); // b^2 - 4ac
        if (underRoot > 0) {
            return EquationStates.TWO_REAL;
        }
        if (underRoot == 0) {
            return EquationStates.ONE_REAL;
        }
        if (underRoot < 0) {
            return EquationStates.TWO_COMPLEX;
        }
        return EquationStates.INVALID;
    }

}
