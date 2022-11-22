package FinalProject;

public class RPS_TYPE {
    private int tValue;
    private String tName;

    public RPS_TYPE(int input) {
        this.tValue = input;
        this.tName = getName(input);
    }

    public RPS_TYPE(String input) {
        this.tName = input.toUpperCase().trim();
        this.tValue = getVal(this.tName);
    }

    public RPS_TYPE() {
        this.tValue = 0;
        this.tName = "ROCK";
    }

    public static String getName(int i) {
        switch (i) {
            default:
                return "ROCK";
            case 1:
                return "PAPER";
            case 2:
                return "SCISSORS";
        }
    }

    public static int getVal(String s) {
        switch (s.toUpperCase().trim()) {
            default:
                return 0;
            case "PAPER":
                return 1;
            case "SCISSORS":
                return 2;
        }
    }

}
