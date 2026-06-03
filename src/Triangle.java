class Triangle {

    private double base;
    private double height;
    private boolean filled;

    // Default Constructors
    Triangle() {
        this.base = 3.0;
        this.height = 4.0;
        this.filled = false;
    }

    Triangle(double base, double height, boolean filled) {
        setBase(base);
        setHeight(height);
        setFilled(filled);
    }

    // Getters
    double getBase() { return base; }
    double getHeight() { return height; }
    boolean isFilled() { return filled; }

    // Setters
    void setBase (double base) {
        if (base <= 0) {
            IO.println("Error: Base must be positive.");
            IO.println("Base remains: " + this.base);
            return;
        }
        this.base = base;
    }
    void setHeight (double height) {
        if (height <= 0) {
            IO.println("Error: Height must be positive.");
            IO.println("Height remains: " + this.height);
            return;
        }
        this.height = height;
    }
    void setFilled(boolean filled) { this.filled = filled; }

    // Calculations
    double getHypotenuse() { return Math.sqrt(base *  + height * height); }
    double calculateArea() { return 0.5 * base * height; }
    double calculatePerimeter() { return base + height + getHypotenuse(); }

    // ASCII Art
    // UNDERSTAND: Draws a right triangle with the right angle at bottom-left.
    // TRACE: base=5, height=5 -> staircase-like triangle pointing right and down.
    void display() {
        int h = Math.max(2, (int) Math.round(height));
        for (int row = 0; row < h; row++) {
            int cols = (int) Math.round((row + 1) * ((double) Math.round(base) / h));
            cols = Math.max(1, cols);
            for (int col = 0; col < cols; col++) {
                boolean border = (row == h - 1 || col == 0 || col == cols - 1);
                IO.print((filled || border) ? "* " : "  ");
            }
            IO.println("");
        }
    }
    static void main() {
        IO.println("Filled Triangle (base=6, height=5):");
        Triangle t1 = new Triangle(6, 6, true);
        t1.display();

        IO.println("\nHollow Triangle (base=6, height=5):");
        Triangle t2 = new Triangle(6, 6, false);
        t2.display();
    }
}
