// UNDERSTAND: Serves as the intermediate abstract parent class specifically for all 3D solid shapes.
// DECISION: Extends Shape and implements Measurable3D to guarantee surface area and volume metrics.
// AI-CHECK: Verified that 3D shapes do not hold or inherit the 2D 'filled' attribute, maintaining a clean state separation.
public abstract class Shape3D extends Shape implements Measurable3D {
    // UNDERSTAND: Chains up to Shape default constructor.
    public Shape3D() {
        super();
    }

    // UNDERSTAND: Passes the color state directly up to the base Shape constructor.
    public Shape3D(String color) {
        super(color);
    }
}
