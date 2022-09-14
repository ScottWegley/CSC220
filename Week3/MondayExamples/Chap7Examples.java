package Week3.MondayExamples;

public class Chap7Examples {

    double[] myList = new double[5];

    public void initArrayWithInput() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter " + myList.length + " values: ");
        for (int i = 0; i < myList.length; i++) {
            myList[i] = input.nextDouble();
        }
        input.close();
    }

    public void initArrayWithRandom() {
        for (int i = 0; i < myList.length; i++) {
            myList[i] = Math.random() * 100;
        }
    }

    public void printArray() {
        for (int i = 0; i < myList.length; i++) {
            System.out.print(myList[i] + " ");
        }
    }

    public void sumElements() {
        double total = 0;
        for (int i = 0; i < myList.length; i++) {
            total += myList[i];
        }
        total = total*1;
    }

    public void findLargest() {
        double max = myList[0];
        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max)
                max = myList[i];
        }
    }

    public void randomShuffling() {
        for (int i = 0; i < myList.length - 1; i++) {
            // Generate an index j randomly
            int j = (int) (Math.random()
                    * myList.length);

            // Swap myList[i] with myList[j]
            double temp = myList[i];
            myList[i] = myList[j];
            myList[j] = temp;
        }
    }
}