// UNDERSTAND: Models a concrete geometric circle extending the 2D shape category.
// DECISION: Inherits filled and color states from Shape2D.
public class Circle extends Shape2D {
    private double radius;

    // UNDERSTAND: Default state fallback constructor.
    // TRACE: Chains red color and hollow status to Shape2D parent.
    public Circle() {
        super("red", false);
        this.radius = 1.0;
    }

    // UNDERSTAND: Called when a new Circle object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    Circle(double radius, boolean filled) {
    setRadius (radius);
    setFilled(filled);
    }

    // UNDERSTAND: Provides controlled read access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getRadius() {
        return radius;
    }
    boolean isFilled() { return filled; }

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
    void setFilled(boolean filled) { this.filled = filled; }

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

    // UNDERSTAND: Approximates a circle on a character grid using distance from center.
    // DECISION: Each cell is 2 chars wide to compensate for character aspect ratio.
    // TRACE: radius=4 -> roughly circular outline of '*' chars on an 8x8 grid.
    void display() {
        int r = Math.max(3, (int) Math.round(radius));
        for (int row = -r; row <= r; row++) {
            for (int col = -r; col <= r; col++) {
                double dist = Math.sqrt(row * row + col * col);
                boolean onBorder = (dist >= r - 0.7 && dist <= r + 0.7);
                boolean inside   = (dist < r - 0.7);
                IO.print((filled && inside) || onBorder ? "* " : "  ");
            }
            IO.println("");
        }
    }
    static void main() {
        IO.println("Filled Circle, RADIUS = 5:");
        Circle c1 = new Circle(5, true);
        c1.display();

        IO.println("\nHollow Circle, RADIUS = 5:");
        Circle c2 = new Circle(5, false);
        c2.display();
    }
}

