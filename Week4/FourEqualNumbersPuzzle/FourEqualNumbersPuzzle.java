package Week4.FourEqualNumbersPuzzle;

import java.util.Arrays;
import java.util.Scanner;

public class FourEqualNumbersPuzzle {

    private static int[][] testTable = { { 0, 1, 0, 3, 1, 6, 1 },
            { 0, 1, 6, 8, 6, 0, 1 },
            { 5, 6, 2, 1, 8, 2, 9 },
            { 6, 5, 6, 1, 1, 9, 1 },
            { 1, 3, 6, 1, 4, 0, 7 },
            { 3, 3, 3, 3, 4, 0, 7 } };

    public static void main(String[] args) throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        int rows = 0;
        int columns = 0;
        try {
            /* System.out.print("Please supply the number of rows for this table: ");
            rows = input.nextInt();
            System.out.print("Please supply the number of colums for this table: ");
            columns = input.nextInt();
            if (rows < 4 || columns < 4) {
                throw new IllegalArgumentException(
                        "The dimensions of this table (" + rows + "," + columns + ") are invalid");
            } */
            int[][] myTable = FourEqualNumbersPuzzle.testTable;
            /* int[][] myTable = new int[columns][rows];
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print("Please enter a single digit value for index " + j + " " + i + ":");
                    myTable[i][j] = input.nextInt();
                }
            } */
            System.out.print(Arrays.deepToString(myTable));
            isConsecutiveFour(myTable);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            input.close();
        }
    }

    public static boolean isConsecutiveFour(int[][] values) {
        System.out.println(values.length + " " + values[0].length);
        for (int i = 0; i < values.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < values[0].length; j++) {
                System.out.print(values[i][j]);
                if(i <= values.length - 4) { //Check for vertical matches
                    if(values[i+1][j] == values[i][j] && values[i+2][j] == values[i][j] &&
                        values[i+3][j] == values[i][j]){
                            System.out.print(values[i][j]);
                            return true;
                    }
                }
                if(j < values[0].length - 4) { //Check for horizontal matches

                }
            }
        }
        return false;
    }
}
