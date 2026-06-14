// UNDERSTAND: Models a concrete Square that inherits structural attributes from Rectangle.
// AI-CHECK: Solves Liskov Substitution Principle (LSP) violations directly by refusing to override
public class Square extends Rectangle {
    // Default Constructors
    // UNDERSTAND: Default constructor leverages parent defaults.
    public Square() {
        super(1.0, 1.0, "red", false);
    }

    // Constructor
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }


    // Getter for side
    // UNDERSTAND: Convenience getter specifically exposing the uniform side length.
    // DECISION: Returns superclass width safely as width and height are guaGeometryCalculatorranteed equal.
    public double getSide() { return getWidth(); }

    // AI-CHECK: Since Square is initialized symmetrically and no setters are exposed, Rectangle's
    // display() implementation perfectly outputs a square grid, eliminating code redundancy.
    @Override
    public String toString() {
        return "Square[side=" + getSide() + ", " + super.toString() + "]";
    }
}
