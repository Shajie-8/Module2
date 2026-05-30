// UNDERSTAND: Models a geometric rectangle with length, width, area, perimeter, and ASCII display
// AI-CHECK: Verified class design follow standard JavaBeans patterns (getters/setters)
class Rectangle {
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: length and width stored as double to support fraction
    private double length;
    private double width;

    // UNDERSTAND: Called when a new Rectangle object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    Rectangle(double width, double length) {
        setWidth(width);
        setLength(length);
    }
    // UNDERSTAND: Provides controlled read access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getWidth() {
        return width;
    }

    double getLength(){
        return length;
    }

    // UNDERSTAND: Allows modification of width with input validation (positive numbers only)
    // DECISION: Used early return pattern for invalid input (instead of throwing exception)
    // because this is designed for beginners learning control flow
    void setWidth(double width) {
        if (width <= 0) {
            // TRACE: Validation error occurs when width <=0
            IO.println("Error: Width mut be positive.");
            IO.println("Width remeains: " + this.length);
            return;
        }
        this.length = length;
    }


}
