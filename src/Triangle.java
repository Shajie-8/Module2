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
}