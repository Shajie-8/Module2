// UNDERSTAND: Models a concrete Cube extending Cuboid features.
// AI-CHECK: Analogous to the Square extending Rectangle fix, Cube uses symmetric constructor forwarding to propagate identical length, width, and height to the Cuboid superclass, preventing structural violations.
public class Cube extends Cuboid {

    // UNDERSTAND: Default constructor
    public Cube() {
        super(1.0, 1.0, 1.0, "red");
    }

    // UNDERSTAND: Creates a cube with a given side length
    public Cube(double side, String color) {
        super(side, side, side, color);
    }

    // UNDERSTAND: Returns the side length
    public double getSide() {
        return getLength();
    }

    @Override
    public String toString() {
        return "Cube[side=" + getSide() + ", " + super.toString() + "]";
    }
}
