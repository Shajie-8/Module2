// UNDERSTAND: This class models a geometric ellipse
class Ellipse {
    // UNDERSTAND: Private fields restrict direct modification from outside the class
    // DECISION: Both stored as double to support fractional measurements
    private double semiMajorAxis;
    private double semiMinorAxis;
    private boolean filled;

    // Default Constructors
    Ellipse() {
        this.semiMajorAxis = 2.0;
        this.semiMinorAxis = 1.0;
        this.filled    = false;
    }

    // UNDERSTAND: Called when a new Ellipse object is created
   // DECISION: Delegates to setters for validation
    Ellipse(double semiMajorAxis, double semiMinorAxis) {
        setSemiMajorAxis(semiMajorAxis);
        setSemiMinorAxis(semiMinorAxis);
        setFilled(filled);
    }

    // UNDERSTAND: Provides controlled read access to private fields
    // DECISIONS: No validation needed in getter
    double getSemiMajorAxis() {
        return semiMajorAxis;
    }
    double getSemiMinorAxis() {
        return semiMinorAxis;
    }
    boolean isFilled() { return filled; }

    // UNDERSTAND: Allow modification of semiMajorAxis with input validations
    // DECISION: Used early return pattern for valid input
    void setSemiMajorAxis(double semiMajorAxis) {
        if (semiMajorAxis <= 0) {
            //TRACE: Validation error occurs when semiMajorAxis <= 0
            IO.println("Error: Semi-major axis must be positive.");
            IO.println("Semi-major axis remains: " + this.semiMajorAxis);
            return;
        }
        this.semiMajorAxis = semiMajorAxis;
    }
    void setSemiMinorAxis(double semiMinorAxis) {
        if (semiMinorAxis <= 0) {
            IO.println("Error: Semi-minor axis must be positive.");
            IO.println("Semi-minor axis remains: " + this.semiMinorAxis);
            return;
        }
        this.semiMinorAxis = semiMinorAxis;
    }

    void setFilled(boolean filled) { this.filled = filled; }

    // UNDERSTAND: Returns area of ellipse
    // DECISION: Uses Math.PI for precision instead of hardcoding 3.14
    double calculateArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    // UNDERSTAND: Returns approximate perimeter using Ramanujan's formula
    // DECISION: Exact ellipse perimeter requires infinite series
    // TRACE: h = ((a - b) / (a + b))^2 is a intermediate value used in the formula
    double calculatePerimeter() {
        double a = semiMajorAxis;
        double b = semiMinorAxis;
        double h = Math.pow((a - b) / (a + b), 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }
}
