// UNDERSTAND: Serves as the intermediate abstract parent class specifically for all 2D shapes.
// DECISION: Extends the Shape base class and implements the Measurable2D contract.
// AI-CHECK: Verified that abstract intermediate classes do not need to implement interface methods, deferring them to concrete classes.
public abstract class Shape2D extends Shape implements Measurable2D {
    // UNDERSTAND: State representing whether the 2D wireframe is visually filled or hollow.
    protected boolean filled;

    // UNDERSTAND: Default constructor initializes the 2D properties.
    public Shape2D() {
        super();
        this.filled = false;
    }

    // UNDERSTAND: Parameterized constructor coordinates both parent and intermediate initialization.
    public Shape2D(String color, boolean filled) {
        super(color);
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}