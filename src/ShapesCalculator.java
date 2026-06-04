import java.util.PrimitiveIterator;

class ShapesCalculator {

    // UNDERSTAND: Reusable separator line for consistent formatting
    // DECISION: Extracted to method to follow DRY (Don't Repeat Yourself)
    static void printSeparator() {
        IO.println("========================================");
    }

    // UNDERSTAND: Entry point
    // DECISION: Used do-while so menu always display at least once before checking exit
    // TRACE: choice is declared outside loop so while condition can read it
    static void main() {
        int choice;
        do {
            printSeparator();
            IO.println("       2D SHAPES CALCULATOR       ");
            printSeparator();
            IO.println("1. Square");
            IO.println("2. Rectangle");
            IO.println("3. Circle");
            IO.println("4. Ellipse");
            IO.println("5. Triangle");
            IO.println("6. Exit");
            printSeparator();
            IO.print("Enter your choice (1 - 6): ");
            choice = Integer.parseInt(IO.readln().trim());

            switch (choice) {
                case 1 -> handleSquare();
                case 2 -> handleRectangle();
                case 3 -> handleCircle();
                case 4 -> handleEllipse();
                case 5 -> handleTriangle();
                case 6 -> {
                    printSeparator();
                    IO.println("Exiting... Goodbye!");
                    printSeparator();
                }
                default -> IO.println("Invalid choice. Please enter 1-6.");
            }
        } while (choice != 6);
    }

    // UNDERSTAND: Handles all Square-related input, object creation, and output
    // DECISION: Separated from main() to follow Single Responsibility Principle
    // TRACE: Reads side -> reads filled -> creates Square -> prints results -> calls display()
    static void handleSquare() {
        IO.println();
        printSeparator();
        IO.println("SQUARE");
        printSeparator();
        IO.print("Enter side: ");
        // TRACE: side value passed directly to Square constructor
        double side = Double.parseDouble(IO.readln().trim());

        // TRACE: filled=true -> display() renders solid block; false -> border only
        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());
        Square square = new Square(side, filled);

        // UNDERSTAND: Display computed results using getters and calculation methods
        // DECISION: Used String.format("%.4f") for consistent 4 decimal place output
        printSeparator();
        IO.println("Side: " + square.getSide() + "units");
        IO.println("Area: " + String.format("%4f", square.calculateArea()) + " sq. units");
        IO.println("Area: " + String.format("%4f", square.calculatePerimeter()) + " units");
        printSeparator();

        // TRACE: display() renders ASCII using stored side and filled values inside Square
        IO.println("ASCII Art");
        square.display();
        printSeparator();

    }

    // UNDERSTAND: Handles all Rectangle-related input, object creation, and output
    // DECISION: Reads width, height, filled before object creation to match constructor
    // TRACE: Reads width -> reads height -> reads filled -> creates Rectangle -> prints
    static void handleRectangle() {
        IO.println();
        printSeparator();
        IO.println("            RECTANGLE                ");
        printSeparator();

        // TRACE: width and height both read before object creation
        // DECISION: Matches Rectangle(double width, double height, boolean filled) signature
        IO.print("Enter width: ");
        double width = Double.parseDouble(IO.readln().trim());
        IO.print("Enter height: ");
        double height = Double.parseDouble(IO.readln().trim());

        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());

        // TRACE: Creates Rectangle - constructor delegates to setWidth(), setHeight(), setFilled()
        Rectangle rect = new Rectangle(width, height, filled);

        // UNDERSTAND: getWidth() and getHeight() return validated stored values
        // DECISION: Display stored values (not raw input) to show setter validation worked
        printSeparator();
        IO.println("Width: " + rect.getWidth() + " units");
        IO.println("Height: " + rect.getHeight() + " units");
        IO.println("Area: " + String.format("%.4f", rect.calculateArea()) + " sq. units");
        IO.println("Perimeter: " + String.format("%.4f", rect.calculatePerimeter()) + " units");
        printSeparator();

        // TRACE: display() renders ASCII using stored width, height, filled
        IO.println("ASCII Art:");
        rect.display();
        printSeparator();
    }

    // UNDERSTAND: Handles all Circle-related input, object creation, and output
    // DECISION: Named output label "Circumference" instead of "Perimeter" for accuracy
    // TRACE: Reads radius -> reads filled -> creates Circle -> prints results -> calls display()
    static void handleCircle() {
        IO.println();
        printSeparator();
        IO.println("              CIRCLE                 ");
        printSeparator();

        // TRACE: radius and filled passed to Circle(double radius, boolean filled) constructor
        IO.print("Enter radius: ");
        double radius = Double.parseDouble(IO.readln().trim());

        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());

        // TRACE: Creates Circle - constructor delegates to setRadius() and setFilled()
        Circle circle = new Circle(radius, filled);

        // UNDERSTAND: calculateArea() returns PI * r^2
        // UNDERSTAND: calculatePerimeter() returns 2 * PI * r (circumference)
        // DECISION: Used "Circumference" label since that is the correct term for circles
        printSeparator();
        IO.println("Radius: " + circle.getRadius() + " units");
        IO.println("Area: " + String.format("%.4f", circle.calculateArea()) + " sq. units");
        IO.println("Circumference: " + String.format("%.4f", circle.calculatePerimeter()) + " units");
        printSeparator();

        // TRACE: display() renders ASCII using stored radius and filled values
        IO.println("ASCII Art:");
        circle.display();
        printSeparator();
    }

    // UNDERSTAND: Handles all Ellipse-related input, object creation, and output
    // DECISION: Two separate prompts for semi-major and semi-minor axes
    // TRACE: Reads semiMajor -> reads semiMinor -> reads filled -> creates Ellipse -> prints
    static void handleEllipse() {
        IO.println();
        printSeparator();
        IO.println("             ELLIPSE                 ");
        printSeparator();

        // UNDERSTAND: Semi-major axis (a) is the longer radius of the ellipse
        // UNDERSTAND: Semi-minor axis (b) is the shorter radius of the ellipse
        // TRACE: Both passed to Ellipse(double semiMajorAxis, double semiMinorAxis, boolean filled)
        IO.print("Enter semi-major axis (a): ");
        double semiMajor = Double.parseDouble(IO.readln().trim());
        IO.print("Enter semi-minor axis (b): ");
        double semiMinor = Double.parseDouble(IO.readln().trim());

        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());

        // TRACE: Creates Ellipse - constructor delegates to setSemiMajorAxis(), setSemiMinorAxis()
        Ellipse ellipse = new Ellipse(semiMajor, semiMinor, filled);

        // UNDERSTAND: calculateArea() returns PI * a * b
        // UNDERSTAND: calculatePerimeter() uses Ramanujan's approximation formula
        // DECISION: Labeled perimeter as "approx" to clarify it is not mathematically exact
        printSeparator();
        IO.println("  Semi-Major Axis   : " + ellipse.getSemiMajorAxis() + " units");
        IO.println("  Semi-Minor Axis   : " + ellipse.getSemiMinorAxis() + " units");
        IO.println("  Area              : " + String.format("%.4f", ellipse.calculateArea()) + " sq. units");
        IO.println("  Perimeter (approx): " + String.format("%.4f", ellipse.calculatePerimeter()) + " units");
        printSeparator();

        // TRACE: display() renders ASCII using stored semiMajorAxis, semiMinorAxis, filled
        IO.println("ASCII Art:");
        ellipse.display();
        printSeparator();
    }

    // UNDERSTAND: Handles all Triangle-related input, object creation, and output
    // DECISION: Added hypotenuse display since Triangle uniquely has getHypotenuse()
    // DECISION: Triangle assumes right triangle - base and height are the two legs
    // TRACE: Reads base -> reads height -> reads filled -> creates Triangle -> prints
    static void handleTriangle() {
        IO.println();
        printSeparator();
        IO.println("            TRIANGLE                 ");
        printSeparator();

    }
