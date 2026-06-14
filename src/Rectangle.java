// UNDERSTAND: Models a concrete rectangle extending 2D classification.
public class Rectangle extends Shape2D {
    private double height;
    private double width;

    // Default Constructors
    public Rectangle() {
        super("red", false);
        this.height = 1.0;
        this.width = 1.0;
    }
    // UNDERSTAND: Called when a new Rectangle object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        setWidth(width);
        setHeight(height);
    }
    // UNDERSTAND: Provides controlled read access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    public double getWidth() {
        return width;
    }

    public double getHeight(){
        return height;
    }

    // UNDERSTAND: Allows modification of width with input validation (positive numbers only)
    // DECISION: Used early return pattern for invalid input (instead of throwing exception)
    // because this is designed for beginners learning control flow
    public void setWidth(double width) {
        if (width <= 0) {
            // TRACE: Validation error occurs when width <=0
            IO.println("Error: Width must be positive.");
            IO.println("Width remains: " + this.width);
            return;
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            // TRACE: Validation error occurs when width <=0
            IO.println("Error: Height must be positive.");
            IO.println("Height remains: " + this.height);
            return;
        }
        this.height = height;
    }


    double calculateArea() {
        return width * height;
    }

    // UNDERSTAND: Returns perimeter of rectangle = 2 * (width + height)
    // DECISION: Separated from calculateArea() to follow Single Responsibility Principle
    double calculatePerimeter() {
        return 2 * (width + height);
    }

    // TRACE: length=6, width=3, filled=false -> border-only 6x3 rectangle
    void display() {
        int h = Math.max(2, (int) Math.round(height));
        int w = Math.max(2, (int) Math.round(width));
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                boolean border = (r == 0 || r == h - 1 || c == 0 || c == w - 1);
                IO.print((filled || border) ? "* " : "  ");
            }
            IO.println("");
        }
    }
    static void main() {
        IO.println("Filled Rectangle (8 x 5):");
        Rectangle r1 = new Rectangle(8, 5, true);
        r1.display();

        IO.println("\nHollow Rectangle (8 x 5):");
        Rectangle r2 = new Rectangle(8, 5, false);
        r2.display();
    }
}
