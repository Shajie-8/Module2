public class Cube {

    // UNDERSTAND: Stores the side length of the cube
    private double side;

    // UNDERSTAND: Default constructor
    Cube() {
        side = 1.0;
    }

    // UNDERSTAND: Creates a cube with a given side length
    Cube(double side) {
        this.side = side;
    }

    // UNDERSTAND: Returns the side length
    double getSide() {
        return side;
    }

    // UNDERSTAND: Updates the side length
    void setSide(double side) {
        this.side = side;
    }

    // UNDERSTAND: Surface Area = 6 × side²
    double calculateSurfaceArea() {
        return 6 * side * side;
    }

    // UNDERSTAND: Volume = side³
    double calculateVolume() {
        return side * side * side;
    }
}
