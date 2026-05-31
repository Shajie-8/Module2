// UNDERSTAND: This class models a geometric circle
class Circle {
    // UNDERSTAND: Private field restricts direct modification from outside the class
    // DECISION: radius stored as double to support fractional measurements
    private double radius;

    // UNDERSTAND: Called when a new Circle object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    Circle(double radius) {
    setRadius (radius);
    }

    // UNDERSTAND: Provides controlled read access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getRadius() {
        return radius;
    }



}

