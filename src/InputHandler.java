import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public Move getPlayerMove(Player player) {
        System.out.println("Player " + player + ", enter row and column (1-3):");
        int row = getValidInput("row") - 1;
        int col = getValidInput("column") - 1;
        return new Move(row, col);
    }

    private int getValidInput(String coordinate) {
        int input;
        do {
            System.out.print("Enter " + coordinate + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number. Please enter a number between 1 and 3.");
                scanner.next(); // Consume the invalid input
            }
            input = scanner.nextInt();
            if (input < 1 || input > 3) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        } while (input < 1 || input > 3);

        return input;
    }

    public void close() {
        scanner.close();
    }
}