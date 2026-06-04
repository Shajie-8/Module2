public class Cuboid {

    // UNDERSTAND: Stores the dimensions of the cuboid
    private double length;
    private double width;
    private double height;

    // UNDERSTAND: Default values
    Cuboid() {
        length = 1.0;
        width = 1.0;
        height = 1.0;
    }

    // UNDERSTAND: Creates a cuboid with given dimensions
    Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // UNDERSTAND: Surface Area = 2(lw + lh + wh)
    double calculateSurfaceArea() {
        return 2 * (length * width +
                length * height +
                width * height);
    }

    // UNDERSTAND: Volume = l × w × h
    double calculateVolume() {
        return length * width * height;
    }
}
