package Week4.LockerPuzzle;

public class LockerPuzzle {
    public static void main(String[] args) {
        lockerSim(8);
    }
    //Weirdly finds the sqrt of n to the nearest full number.
    public static void lockerSim(int n) {
        if (n < 1)
            return;
        System.out.println("Simulating " + n + " lockers");
        boolean[] lockers = new boolean[n];
        for (int i = 0; i < n; i++) {
            lockers[i] = false;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = j - 1; i < n; i += j) {
                lockers[i] = !lockers[i];
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (lockers[i]) {
                System.out.println("Locker " + i + " is open");
                total++;
            }
        }
        System.out.println(total + " lockers are open");
    }
}
