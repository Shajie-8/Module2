// UNDERSTAND: Models a right triangle using base and height.
// DECISION: Used right triangle (base, height) since hypotenuse is derivable via Pythagoras.
//           Area = 0.5*base*height; Perimeter = base + height + hypotenuse.

class Triangle {

    private double base;
    private double height;
    private boolean filled;

    // Default Constructors
    Triangle() {
        this.base = 3.0;
        this.height = 4.0;
        this.filled = false;
    }

    Triangle(double base, double height, boolean filled) {
        setBase(base);
        setHeight(height);
        setFilled(filled);
    }

    // Getters
    double getBase() { return base; }
    double getHeight() { return height; }
    boolean isFilled() { return filled; }

    // Setters
    void setBase (double base) {
        if (base <= 0) {
            IO.println("Error: Base must be positive.");
            IO.println("Base remains: " + this.base);
            return;
        }
        this.base = base;
    }
    void setHeight (double height) {
        if (height <= 0) {
            IO.println("Error: Height must be positive.");
            IO.println("Height remains: " + this.height);
            return;
        }
        this.height = height;
    }
}
