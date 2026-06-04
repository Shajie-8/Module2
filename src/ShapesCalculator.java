import java.util.PrimitiveIterator;

class ShapesCalculator {

    // UNDERSTAND: Reusable separator line for consistent formatting
    // DECISION: Extracted to method to follow DRY (Don't Repeat Yourself)
    static void printSeparator() {
        IO.println("========================================");
    }

    // UNDERSTAND: Entry point
    // DECISION: Used do-while so menu always display at least once before checking exit
    // TRACE: choice is declared outside loop so while condition can read it
    static void main() {
        int choice;
        do {
            printSeparator();
            IO.println("     2D SHAPES CALCULATOR     ");
            printSeparator();
            IO.println("1. Square");
            IO.println("2. Rectangle");
            IO.println("3. Circle");
            IO.println("4. Ellipse");
            IO.println("5. Triangle");
            IO.println("6. Exit");
            printSeparator();
            IO.print("Enter your choice (1 - 6): ");
            choice = Integer.parseInt(IO.readln().trim());

            switch (choice) {
                case 1 -> handleSquare();
                case 2 -> handleRectangle();
                case 3 -> handleCircle();
                case 4 -> handleEllipse();
                case 5 -> handleTriangle();
                case 6 -> {
                    printSeparator();
                    IO.println("Exiting... Goodbye!");
                    printSeparator();
                }
                default -> IO.println("Invalid choice. Please enter 1-6.");
            }
        } while (choice != 6);
    }

    static void handleSquare() {
        IO
    }
}
