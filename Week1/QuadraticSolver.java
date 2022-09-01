package Week1;

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

    public void findRoots(Object aIn, Object bIn, Object cIn) {
        try {
            System.out.println("Your inputs were " + aIn.toString() + " " + bIn.toString() + " " + cIn.toString());
            int a = (Integer) aIn;
            int b = (Integer) bIn;
            int c = (Integer) cIn;

            Double ansOne = null;
            Double ansTwo = null;

            switch (processEquation(a, b, c)) {
                case TWO_REAL:
                    ansOne = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                    ansTwo = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                    break;
                default:
                    System.out.println("Something has gone wrong.");
                    break;
            }

            if (ansOne != null && ansTwo != null) {
                System.out.println("Your answers are " + ansOne.toString() + " and " + ansTwo.toString());
                return;
            }

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

    public EquationStates processEquation(int aIn, int bIn, int cIn) {
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

    public static void main(String[] args) {

        QuadraticSolver qSolver = new QuadraticSolver();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Demonstration or Actual Uses? (0,1)");
            String temp = scanner.nextLine();
            if (Integer.parseInt(temp) != 0 && Integer.parseInt(temp) != 1) {
                System.out.println("Invalid response.");
                return;
            }
            if (Integer.valueOf(temp) == 0) {
                qSolver.demonstration();
                return;
            } else {
                while (true) {
                    
                }
            }
        } catch (Exception e) {
            System.out.println("You submitted an invalid value.");
            System.out.println("Error: " + e.getMessage());
        }

    }

}
