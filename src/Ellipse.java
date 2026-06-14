// UNDERSTAND: This class models a geometric ellipse
public class Ellipse extends Shape2D {
    // UNDERSTAND: Private fields restrict direct modification from outside the class
    // DECISION: Both stored as double to support fractional measurements
    private double semiMajorAxis;
    private double semiMinorAxis;

    // Default Constructors
    Ellipse() {
        super("red", false);
        this.semiMajorAxis = 2.0;
        this.semiMinorAxis = 1.0;
    }

    // UNDERSTAND: Called when a new Ellipse object is created
    // DECISION: Delegates to setters for validation
    Ellipse(double semiMajorAxis, double semiMinorAxis, String color, boolean filled) {
        super(color, filled);
        setSemiMajorAxis(semiMajorAxis);
        setSemiMinorAxis(semiMinorAxis);
    }

    // UNDERSTAND: Provides controlled read access to private fields
    // DECISIONS: No validation needed in getter
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }
    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    // UNDERSTAND: Allow modification of semiMajorAxis with input validations
    // DECISION: Used early return pattern for valid input
    public void setSemiMajorAxis(double semiMajorAxis) {
        if (semiMajorAxis <= 0) {
            //TRACE: Validation error occurs when semiMajorAxis <= 0
            IO.println("Error: Semi-major axis must be positive.");
            IO.println("Semi-major axis remains: " + this.semiMajorAxis);
            return;
        }
        this.semiMajorAxis = semiMajorAxis;
    }

    public void setSemiMinorAxis(double semiMinorAxis) {
        if (semiMinorAxis <= 0) {
            IO.println("Error: Semi-minor axis must be positive.");
            IO.println("Semi-minor axis remains: " + this.semiMinorAxis);
            return;
        }
        this.semiMinorAxis = semiMinorAxis;
    }

    // UNDERSTAND: Returns area of ellipse
    // DECISION: Uses Math.PI for precision instead of hardcoding 3.14
    @Override
    public double calculateArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    @Override
    // UNDERSTAND: Returns approximate perimeter using Ramanujan's formula
    // DECISION: Exact ellipse perimeter requires infinite series
    // TRACE: h = ((a - b) / (a + b))^2 is a intermediate value used in the formula
    public double calculatePerimeter() {
        double a = semiMajorAxis;
        double b = semiMinorAxis;
        double h = Math.pow((a - b) / (a + b), 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    // UNDERSTAND: Point (col, row) is inside/on ellipse if (col/a)^2 + (row/b)^2 <= 1.
    // TRACE: a=6, b=3 -> horizontally stretched ellipse shape in ASCII chars.
    public void display() {
        int a = Math.max(3, (int) Math.round(semiMajorAxis));
        int b = Math.max(2, (int) Math.round(semiMinorAxis));
        for (int row = -b; row <= b; row++) {
            for (int col = -a; col <= a; col++) {
                double val = (double)(col * col) / (a * a) + (double)(row * row) / (b * b);
                boolean onBorder = (val >= 0.75 && val <= 1.25);
                boolean inside   = (val < 0.75);
                IO.print((filled && inside) || onBorder ? "* " : "  ");
            }
            IO.println("");
        }
    }

    @Override
    public String toString() {
        return "Ellipse[semiMajorAxis=" + semiMajorAxis + ", semiMinorAxis=" + semiMinorAxis + ", " + super.toString() + "]";
    }
}
