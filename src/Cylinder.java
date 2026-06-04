public class Cylinder {

    // UNDERSTAND: Stores the radius and height
    private double radius;
    private double height;

    // UNDERSTAND: Default constructor
    Cylinder() {
        radius = 1.0;
        height = 1.0;
    }

    // UNDERSTAND: Creates a cylinder with given dimensions
    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // UNDERSTAND: Surface Area = 2πr(r + h)
    double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    // UNDERSTAND: Volume = πr²h
    double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}
