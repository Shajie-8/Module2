public class Cylinder extends Shape3D {

    // UNDERSTAND: Stores the radius and height
    private double radius;
    private double height;

    // UNDERSTAND: Default constructor
    public Cylinder() {
        super("red");
        radius = 1.0;
        height = 1.0;
    }

    // UNDERSTAND: Creates a cylinder with given dimensions
    public Cylinder(double radius, double height, String color) {
        super(color);
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
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
