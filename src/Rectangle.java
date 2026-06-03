// UNDERSTAND: Models a geometric rectangle with height, width, area, perimeter, and ASCII display
// AI-CHECK: Verified class design follow standard JavaBeans patterns (getters/setters)
class Rectangle {
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: height and width stored as double to support fraction
    private double height;
    private double width;
    private boolean filled;

    // Default Constructors
    Rectangle() {
        this.height = 1.0;
        this.width = 1.0;
        this.filled = false;
    }
    // UNDERSTAND: Called when a new Rectangle object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    Rectangle(double width, double height, boolean filled) {
        setWidth(width);
        setHeight(height);
        setFilled(filled);
    }
    // UNDERSTAND: Provides controlled read access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getWidth() {
        return width;
    }

    double getHeight(){
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

    void setHeight(double height) {
        if (height <= 0) {
            // TRACE: Validation error occurs when width <=0
            IO.println("Error: Height must be positive.");
            IO.println("Height remains: " + this.height);
            return;
        }
        this.height = height;
    }

    void setFilled(boolean filled) { this.filled = filled; }

    double calculateArea() {
        return width * height;
    }

    // UNDERSTAND: Returns perimeter of rectangle = 2 * (width + height)
    // DECISION: Separated from calculateArea() to follow Single Responsibility Principle
    double calculatePerimeter() {
        return 2 * (width + height);
    }

    // TRACE: length=6, width=3, filled=false -> border-only 6x3 rectangle
    void display() {
        int l = Math.max(2, (int) Math.round(height));
        int w = Math.max(2, (int) Math.round(width));
        for (int r = 0; r < w; r++) {
            for (int c = 0; c < l; c++) {
                boolean border = (r == 0 || r == w - 1 || c == 0 || c == l - 1);
                IO.print((filled || border) ? "* " : "  ");
            }
            IO.println("");
        }
    }
}
