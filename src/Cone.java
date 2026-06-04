public class Cone {

    // UNDERSTAND: Stores the radius and height
    private double radius;
    private double height;

    // UNDERSTAND: Default values
    Cone() {
        radius = 1.0;
        height = 1.0;
    }

    // UNDERSTAND: Creates a cone with given dimensions
    Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // UNDERSTAND: Finds the slant height using Pythagorean Theorem
    double getSlantHeight() {
        return Math.sqrt(radius * radius + height * height);
    }
}
