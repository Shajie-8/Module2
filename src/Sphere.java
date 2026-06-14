public class Sphere extends Shape3D {

    // UNDERSTAND: Stores the radius of the sphere
    private double radius;

    // UNDERSTAND: Default constructor
    public Sphere() {
        super("red");
        radius = 1.0;
    }

    // UNDERSTAND: Creates a sphere with a given radius
    public Sphere(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    // UNDERSTAND: Returns the radius
    public double getRadius() {
        return radius;
    }

    // UNDERSTAND: Updates the radius
    public void setRadius(double radius) {
        if (radius <= 0) {
            IO.println("Error: Radius must be positive.");
            IO.println("Radius remains: " + this.radius);
            return;
        }
        this.radius = radius;
    }

    // UNDERSTAND: Surface Area = 4πr²
    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    // UNDERSTAND: Volume = (4/3)πr³
    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }


}
