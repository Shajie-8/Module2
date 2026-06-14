// UNDERSTAND: Models a concrete Square that inherits structural attributes from Rectangle.
// AI-CHECK: Solves Liskov Substitution Principle (LSP) violations directly by refusing to override
public class Square extends Rectangle {
    // Default Constructors
    // UNDERSTAND: Default constructor leverages parent defaults.
    public Square() {
        super(1.0, 1.0, "red", false);
    }

    // Constructor
    // UNDERSTAND: Called when a new Square object is created - initializes object state
    // Decision: Delegates to setter for validation (reuses existing validation logic)
    // AI-CHECK: Confirmed with textbook that setter delegation is a standard pattern
    Square(double side, boolean filled) {
        setSide(side); // Using setter for validation
        setFilled(filled);
    }


    // Getter for side
    // UNDERSTAND: Provides controlled access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getSide() { return side; }
    boolean isFilled() { return  filled; }

    // Setter for side with validation
    // UNDERSTAND: Allows modification of side with input validation (positive numbers only)
    // DECISION: Used early return pattern for invalid input (instead of throwing exception)
    // because this is designed for beginner learning control flow
    void setSide(double side){
        if (side <= 0) {
            // TRACE: Validation error occurs when side <= 0
            IO.println("Error: Side must be positive.");
            IO.println("Side remains: " + this.side);
            return; // UNDERSTAND: Early returns prevents invalid assignment
        }
        this.side = side;
    }

    void setFilled(boolean filled) {this.filled = filled;}
    // Method to calculate area
    // UNDERSTAND: Returns area of square = side * side
    // DECISION: No input parameters needed (side already stored in object state)
    // Result is always non-negative
    double calculateArea() {
        return side * side;
    }
    // Method to calculate perimeter
    // UNDERSTAND: Returns perimeter of square = 4 * side
    // DECISION: Separated from calculateArea() to follow Single Responsibility Principle
    double calculatePerimeter() {
        return 4 * side;
    }

    // UNDERSTAND: Renders a square using "*" in ACII
    // DECISION: Scales output by rounding side to nearest integer for display.
    // TRACE: side=5, filled=true -> 5x5 block of "*"
    void display() {
        int s = Math.max(2, (int) Math.round(side));
        for (int r = 0; r < s; r++) {
            for (int c = 0; c < s; c++) {
                boolean border = (r == 0 || r == s - 1 || c == 0 || c == s-1);
                IO.print((filled || border) ? "* " : "  ");
            }
            IO.println("");
        }
    }
    static void main() {
        IO.println("Filled Square:");
        Square s1 = new Square(6, true);
        s1.display();

        IO.println("\nHollow Square:");
        Square s2 = new Square(6, false);
        s2.display();
    }
}
