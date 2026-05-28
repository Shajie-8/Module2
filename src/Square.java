// UNDERSTAND: This class models a geometric square
// AI-CHECK: Verified class design follows standard Javabeans patterns (getters/setters)

class Square {
    // Data field (attribute)
    // Understand: Private access restricts direct modification from outside the class
    // DECISION: side is stored as double (not int) to support fractional measurements
    private double side;

    // Constructor
    // UNDERSTAND: Called when a new Square object is created - initializes object state
    // Decision: Delegates to setter for validation (reuses existing validation logic)
    // AI-CHECK: Confirmed with textbook that setter delegation is a standard pattern
    Square(double side) {
        setSide(side); // Using setter for validation
    }

    // Getter for side
    // UNDERSTAND: Provides controlled access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getSide() {
        return side;
    }

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
}
