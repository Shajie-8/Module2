public class Triangle extends Shape2D {

    private double base;
    private double height;

    // Default Constructors
    public Triangle() {
        this.base = 3.0;
        this.height = 4.0;
    }

    public Triangle(double base, double height, String color boolean filled) {
        super(color, filled);
        setBase(base);
        setHeight(height);
    }

    // Getters
    public double getBase() { return base; }
    public double getHeight() { return height; }

    // Setters
    public void setBase (double base) {
        if (base <= 0) {
            IO.println("Error: Base must be positive.");
            IO.println("Base remains: " + this.base);
            return;
        }
        this.base = base;
    }

    public void setHeight (double height) {
        if (height <= 0) {
            IO.println("Error: Height must be positive.");
            IO.println("Height remains: " + this.height);
            return;
        }
        this.height = height;
    }

    // Calculations
    public double getHypotenuse() {
        return Math.sqrt(base * base + height * height);
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return base + height + getHypotenuse();
    }


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

    @Override
    public String toString() {
        return "Triangle[base=" + base + ", height=" + height + ", " + super.toString() + "]";
    }
}