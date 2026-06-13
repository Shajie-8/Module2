// UNDERSTAND: Defines the behavioral contract for all two-dimensional geometric calculations.
// DECISION: Segregated from 3D methods to adhere to the Interface Segregation Principle (ISP).
public interface Measurable2D {
    double calculateArea();
    double calculatePerimeter();
}
