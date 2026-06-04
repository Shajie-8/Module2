public class Sphere {

    // UNDERSTAND: Stores the radius of the sphere
    private double radius;

    // UNDERSTAND: Default constructor
    Sphere() {
        radius = 1.0;
    }

    // UNDERSTAND: Creates a sphere with a given radius
    Sphere(double radius) {
        this.radius = radius;
    }

    // UNDERSTAND: Returns the radius
    double getRadius() {
        return radius;
    }

    // UNDERSTAND: Updates the radius
    void setRadius(double radius) {
        this.radius = radius;
    }

    // UNDERSTAND: Surface Area = 4πr²
    double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    // UNDERSTAND: Volume = (4/3)πr³
    double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}
