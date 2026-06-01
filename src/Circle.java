// UNDERSTAND: This class models a geometric circle
class Circle {
    // UNDERSTAND: Private field restricts direct modification from outside the class
    // DECISION: radius stored as double to support fractional measurements
    private double radius;
    private boolean filled;

    // Default Constructors
    Circle() {
        this.radius = 1.0;
        this.filled = false;
    }

    // UNDERSTAND: Called when a new Circle object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    Circle(double radius, boolean filled) {
    setRadius (radius); setFilled(filled);
    }

    // UNDERSTAND: Provides controlled read access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getRadius() {
        return radius;
    }

    // UNDERSTAND: Allows modifications of radius with input validation
    // DECISION: Used early return pattern for invalid input
    void setRadius(double radius) {
        if (radius <= 0) {
            // TRACE: Validation error occurs when radius <= 0
            IO.println("Error: Radius must be positive.");
            IO.println("Radius remains: " + this.radius);
            return;
        }
        this.radius = radius;
    }

    // UNDERSTAND: Returns area of circle = π * radius²
    // DECISION: Uses Math.PI for precision instead of hardcoding 3.14
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // UNDERSTAND: Returns circumference of circle = 2 * π * radius
    // DECISION: Separated from calculateArea() to follow Single Responsibility Principle
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

