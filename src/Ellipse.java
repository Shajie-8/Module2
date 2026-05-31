// UNDERSTAND: This class models a geometric ellipse
class Ellipse {
    // UNDERSTAND: Private fields restrict direct modification from outside the class
    // DECISION: Both stored as double to support fractional measurements
    private double semiMajorAxis;
    private double semiMinorAxis;

   // UNDERSTAND: Called when a new Ellipse object is created
   // DECISION: Delegates to setters for validation
    Ellipse(double semiMajorAxis, double semiMinorAxis) {
        setSemiMajorAxis(semiMajorAxis);
        setSemiMinorAxis(semiMinorAxis);
    }

    // UNDERSTAND: Provides controlled read access to private fields
    // DECISIONS: No validation needed in getter
    double getSemiMajorAxis() {
        return semiMajorAxis;
    }
    double getSemiMinorAxis() {
        return semiMinorAxis;
    }
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

}
}