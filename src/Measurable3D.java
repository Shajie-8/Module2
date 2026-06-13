// UNDERSTAND: Defines the behavioral contract for all three-dimensional geometric calculations.
// DECISION: Kept independent of Measurable2D to prevent design pollution in solid shapes.
public interface Measurable3D {
    double calculateSurfaceArea();
    double calculateVolume();
}
