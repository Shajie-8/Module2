public class Cone extends Shape3D {

    // UNDERSTAND: Stores the radius and height
    private double radius;
    private double height;

    // UNDERSTAND: Default values
    public Cone() {
        super("red");
        radius = 1.0;
        height = 1.0;
    }

    // UNDERSTAND: Creates a cone with given dimensions
    public Cone(double radius, double height, String color) {
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

    // UNDERSTAND: Finds the slant height using Pythagorean Theorem
    double getSlantHeight() {
        return Math.sqrt(radius * radius + height * height);
    }

    // UNDERSTAND: Surface Area = πr(r + slant height)
    double calculateSurfaceArea() {
        return Math.PI * radius * (radius + getSlantHeight());
    }

    // UNDERSTAND: Volume = (1/3)πr²h
    double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
}
