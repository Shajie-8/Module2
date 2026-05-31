// UNDERSTAND: Models a geometric rectangle with height, width, area, perimeter, and ASCII display
// AI-CHECK: Verified class design follow standard JavaBeans patterns (getters/setters)
class Rectangle {
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: height and width stored as double to support fraction
    private double height;
    private double width;

    // UNDERSTAND: Called when a new Rectangle object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    Rectangle(double width, double height) {
        setWidth(width);
        setheight(height);
    }
    // UNDERSTAND: Provides controlled read access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getWidth() {
        return width;
    }

    double getheight(){
        return height;
    }

    // UNDERSTAND: Allows modification of width with input validation (positive numbers only)
    // DECISION: Used early return pattern for invalid input (instead of throwing exception)
    // because this is designed for beginners learning control flow
    void setWidth(double width) {
        if (width <= 0) {
            // TRACE: Validation error occurs when width <=0
            IO.println("Error: Width must be positive.");
            IO.println("Width remains: " + this.width);
            return;
        }
        this.width = width;
    }

    void setheight(double height) {
        if (height <= 0) {
            // TRACE: Validation error occurs when width <=0
            IO.println("Error: height must be positive.");
            IO.println("height remains: " + this.height);
            return;
        }
        this.height = height;
    }

    double calculateArea() {
        return width * height;
    }

    // UNDERSTAND: Returns perimeter of rectangle = 2 * (width + height)
    // DECISION: Separated from calculateArea() to follow Single Responsibility Principle
    double calculatePerimeter() {
        return 2 * (width + height);
    }
}
