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

    // Getters
    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    // Setters
    public void setRadius(double radius) {
        if (radius <= 0) {
            IO.println("Error: Radius must be positive.");
            IO.println("Radius remains: " + this.radius);
            return;
        }
        this.radius = radius;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            IO.println("Error: Height must be positive.");
            IO.println("Height remains: " + this.height);
            return;
        }
        this.height = height;
    }

    // UNDERSTAND: Surface Area = 2πr(r + h)
    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    // UNDERSTAND: Volume = πr²h
    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return "Cylinder[radius=" + radius + ", height=" + height + ", " + super.toString() + "]";
    }
}
