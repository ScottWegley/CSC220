package Week4.LockerPuzzle;

public class LockerPuzzle {
    public static void main(String[] args) {
        lockerSim(5);
    }

    public static void lockerSim(int n){
        if(n<1) return;
        System.out.println("Simulating " + n + " lockers");
        boolean[] lockers = new boolean[n];
        for (int i = 0; i < n; i++) {
            lockers[i] = false;
        }

        for (boolean b : lockers) {
            System.out.println(b);
        }
    }
}
