package features.java7;

// In Java 7, Java allows you to use string objects in the expression of switch statement

public class SwitchStatementExample {
    public static void main(String[] args) {
        String game = "Card-Games";
        switch (game) {
            case "Hockey": case "Cricket": case "Football":
                System.out.println("This is an outdoor game");
                break;
            case "Chess": case "Card-Games": case "Puzzles": case "Indoor basketball":
                System.out.println("This is a indoor game");
                break;
            default:
                System.out.println("What game is it");
        }
    }
}
