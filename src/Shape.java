// UNDERSTAND: Serves as the ultimate base parent class for the entire shape hierarchy.
// DECISION: Declared abstract to prevent direct instantiation of a generic "Shape" object.
public abstract class Shape {
    // UNDERSTAND: Protected access modifier allows direct read/write by extending subclasses.
    // DECISION: Declared color as a shared attribute across both 2D and 3D sub-types.
    protected String color;

    // UNDERSTAND: Default constructor provides a safe fallback state.
    // TRACE: Automatically assigns default color "red" if no arguments are passed.
    public Shape() {
        this.color = "red";
    }

    // UNDERSTAND: Parameterized constructor for custom color assignment.
    public Shape(String color) {
        this.color = color;
    }

    // UNDERSTAND: Provides read access to the encapsulated color field.
    public String getColor() {
        return color;
    }

    // UNDERSTAND: Allows controlled mutation of the color property.
    public void setColor(String color) {
        this.color = color;
    }

    // UNDERSTAND: Polymorphically displays general state details.
    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }
}