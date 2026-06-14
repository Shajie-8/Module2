class GeometryCalculator {

    // UNDERSTAND: Reusable separator line for consistent formatting
    // DECISION: Extracted to method to follow DRY (Don't Repeat Yourself)
    static void printSeparator() {
        IO.println("========================================");
    }

    // UNDERSTAND: Entry point
    // DECISION: Used do-while so menu always display at least once before checking exit
    // TRACE: choice is declared outside loop so while condition can read it
    static void main() {
        IO.println(" Welcome to the Geometry Calculator!    ");
        IO.println(" This program calculates area/perimeter ");
        IO.println(" for 2D shapes and surface area/volume  ");
        IO.println(" for 3D solid shapes.                   ");

        int choice;
        do {
            printSeparator();
            IO.println("       GEOMETRY CALCULATOR MENU       ");
            printSeparator();
            IO.println("1. 2D Shapes Calculator");
            IO.println("2. 3D Solids Calculator");
            IO.println("3. Exit");
            printSeparator();
            IO.print("Enter your choice (1 - 3): ");
            choice = Integer.parseInt(IO.readln().trim());

            switch (choice) {
                case 1 -> handle2D();
                case 2 -> handle3D();
                case 3 -> {
                    printSeparator();
                    IO.println("Exiting... Goodbye!");
                    printSeparator();
                }
                default -> IO.println("Invalid choice. Please enter 1-6.");
            }
        } while (choice != 3);
    }

    // 2D SHAPES SUB-MENU
    // UNDERSTAND: Nested menu for all 2D shape options
    // DECISION: Returns to main menu on option 6
    static void handle2D() {
        int choice;
        do {
            printSeparator();
            IO.println("         2D SHAPES CALCULATOR         ");
            printSeparator();
            IO.println(("1. Square"));
            IO.println("2. Rectangle");
            IO.println("3. Circle");
            IO.println("4. Ellipse");
            IO.println("5. Triangle");
            IO.println("6. Return to Main Menu");
            printSeparator();
            IO.print("Enter your choice (1-6): ");
            choice = Integer.parseInt(IO.readln().trim());

            switch (choice) {
                case 1 -> handleSquare();
                case 2 -> handleRectangle();
                case 3 -> handleCircle();
                case 4 -> handleEllipse();
                case 5 -> handleTriangle();
                case 6 -> IO.println("Returning to Main Menu...");
                default -> IO.println("Invalid choice. Please enter 1-6.");
            }
        } while (choice != 6);
    }

    // 3D SOLIDS SUB-MENU
    // UNDERSTAND: Nested menu for all 3D solid options
    // DECISION: Returns to main menu on option 6
    static  void  handle3D() {
        int choice;
        do {
            printSeparator();
            IO.println("         3D SOLIDS CALCULATOR         ");
            printSeparator();
            IO.println("1. Cube");
            IO.println("2. Cuboid (Rectangular Box)");
            IO.println("3. Sphere");
            IO.println("4. Right Circular Cone");
            IO.println("5. Right Circular Cylinder");
            IO.println("6. Return to Main Menu");
            printSeparator();
            IO.print("Enter your choice (1 - 6): ");
            choice = Integer.parseInt(IO.readln().trim());
            switch (choice) {
                case 1 -> handleCube();
                case 2 -> handleCuboid();
                case 3 -> handleSphere();
                case 4 -> handleCone();
                case 5 -> handleCylinder();
                case 6 -> IO.println("Returning to Main Menu...");
                default -> IO.println("Invalid choice. Please enter 1-6.");
            }
        } while (choice != 6);
    }

    // 2D Shape Handlers
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

        IO.print("Enter color: ");
        String color = IO.readln().trim();

        // TRACE: filled=true -> display() renders solid block; false -> border only
        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());
        Square square = new Square(side, color, filled);

        // UNDERSTAND: Display computed results using getters and calculation methods
        // DECISION: Used String.format("%.2f") for consistent 2 decimal place output
        printSeparator();
        IO.println("Side: " + square.getSide() + "units");
        IO.println("Color: " + square.getColor());
        IO.println("Area: " + String.format("%.2f", square.calculateArea()) + " sq. units");
        IO.println("Area: " + String.format("%.2f", square.calculatePerimeter()) + " units");
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

        IO.print("Enter color: ");
        String color = IO.readln().trim();

        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());

        // TRACE: Creates Rectangle - constructor delegates to setWidth(), setHeight(), setFilled()
        Rectangle rect = new Rectangle(width, height, color, filled);

        // UNDERSTAND: getWidth() and getHeight() return validated stored values
        // DECISION: Display stored values (not raw input) to show setter validation worked
        printSeparator();
        IO.println("Width: " + rect.getWidth() + " units");
        IO.println("Height: " + rect.getHeight() + " units");
        IO.println("Color     : " + rect.getColor());
        IO.println("Area: " + String.format("%.2f", rect.calculateArea()) + " sq. units");
        IO.println("Perimeter: " + String.format("%.2f", rect.calculatePerimeter()) + " units");
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

        IO.print("Enter color: ");
        String color = IO.readln().trim();

        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());

        // TRACE: Creates Circle - constructor delegates to setRadius() and setFilled()
        Circle circle = new Circle(radius, color, filled);

        // UNDERSTAND: calculateArea() returns PI * r^2
        // UNDERSTAND: calculatePerimeter() returns 2 * PI * r (circumference)
        // DECISION: Used "Circumference" label since that is the correct term for circles
        printSeparator();
        IO.println("Radius: " + circle.getRadius() + " units");
        IO.println("Color         : " + circle.getColor());
        IO.println("Area: " + String.format("%.2f", circle.calculateArea()) + " sq. units");
        IO.println("Circumference: " + String.format("%.2f", circle.calculatePerimeter()) + " units");
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

        IO.print("Enter color: ");
        String color = IO.readln().trim();

        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());

        // TRACE: Creates Ellipse - constructor delegates to setSemiMajorAxis(), setSemiMinorAxis()
        Ellipse ellipse = new Ellipse(semiMajor, semiMinor, color, filled);

        // UNDERSTAND: calculateArea() returns PI * a * b
        // UNDERSTAND: calculatePerimeter() uses Ramanujan's approximation formula
        // DECISION: Labeled perimeter as "approx" to clarify it is not mathematically exact
        printSeparator();
        IO.println("Semi-Major Axis: " + ellipse.getSemiMajorAxis() + " units");
        IO.println("Semi-Minor Axis: " + ellipse.getSemiMinorAxis() + " units");
        IO.println("Color: " + ellipse.getColor());
        IO.println("Area: " + String.format("%.2f", ellipse.calculateArea()) + " sq. units");
        IO.println("Perimeter (approx): " + String.format("%.2f", ellipse.calculatePerimeter()) + " units");
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

    // UNDERSTAND: base is the horizontal leg of the right triangle
    // UNDERSTAND: height is the vertical leg of the right triangle
    // TRACE: Both passed to Triangle(double base, double height, boolean filled) constructor
        IO.print("Enter base: ");
        double base = Double.parseDouble(IO.readln().trim());
        IO.print("Enter height: ");
        double height = Double.parseDouble(IO.readln().trim());

        IO.print("Enter color: ");
        String color = IO.readln().trim();

        IO.print("Filled? (true/false): ");
        boolean filled = Boolean.parseBoolean(IO.readln().trim());

        // TRACE: Creates Triangle - constructor delegates to setBase(), setHeight(), setFilled()
        Triangle triangle = new Triangle(base, height, color, filled);

        // UNDERSTAND: getHypotenuse() computes sqrt(base^2 + height^2) internally
        // UNDERSTAND: calculateArea() returns 0.5 * base * height
        // UNDERSTAND: calculatePerimeter() returns base + height + hypotenuse
        // DECISION: Displayed hypotenuse separately since it is a unique Triangle feature
        // DECISION: Used String.format("%.2f") for all doubles for consistent formatting
        // TRACE: All values retrieved via getters to confirm setter validation was applied
        printSeparator();
        IO.println("Base: " + triangle.getBase() + " units");
        IO.println("Height: " + triangle.getHeight() + " units");
        IO.println("Hypotenuse: " + String.format("%.2f", triangle.getHypotenuse()) + " units");
        IO.println("Color: " + triangle.getColor());
        IO.println("Area: " + String.format("%.2f", triangle.calculateArea()) + " sq. units");
        IO.println("Perimeter: " + String.format("%.2f", triangle.calculatePerimeter()) + " units");
        printSeparator();

        // TRACE: display() renders ASCII art row by row using stored base, height, filled
        IO.println("ASCII Art:");
        triangle.display();
        printSeparator();
    }

    // 3D Solid Handlers
    // UNDERSTAND: Handles Cube input/output
    // TRACE: side -> new Cube -> surface area -> volume -> print results
    static void handleCube() {
        IO.println();
        printSeparator();
        IO.println("               CUBE:                 ");
        printSeparator();
        IO.print("Enter side length: ");
        double side = Double.parseDouble(IO.readln().trim());

        Cube cube = new Cube(side);
        printSeparator();
        IO.println("RESULTS");
        IO.println("Surface Area: " + String.format("%.2f", cube.calculateSurfaceArea()));
        IO.println("Volume: " + String.format("%.2f", cube.calculateVolume()));
        printSeparator();
    }

    // UNDERSTAND: Handles Cuboid input/output
    // TRACE: length -> width -> height -> new Cuboid -> surface area -> volume
    static void handleCuboid() {
        IO.println();
        printSeparator();
        IO.println("       CUBOID (Rectangular Box):     ");
        printSeparator();
        IO.print("Enter length: ");
        double length = Double.parseDouble(IO.readln().trim());
        IO.print("Enter width: ");
        double width = Double.parseDouble(IO.readln().trim());
        IO.print("Enter height: ");
        double height = Double.parseDouble(IO.readln().trim());

        Cuboid cuboid = new Cuboid(length, width, height);
        printSeparator();
        IO.println("RESULTS:");
        IO.println("Surface Area: " + String.format("%.2f", cuboid.calculateSurfaceArea()));
        IO.println("Volume: " + String.format("%.2f", cuboid.calculateVolume()));
        printSeparator();
    }

    // UNDERSTAND: Handles Sphere input/output
    // TRACE: radius -> new Sphere -> surface area -> volume
    static void handleSphere() {
        IO.println();
        printSeparator();
        IO.println("              SPHERE:                ");
        printSeparator();
        IO.print("Enter radius: ");
        double radius = Double.parseDouble(IO.readln().trim());

        Sphere sphere = new Sphere(radius);
        printSeparator();
        IO.println("RESULTS:");
        IO.println("Surface Area: " + String.format("%.2f", sphere.calculateSurfaceArea()));
        IO.println("Volume: " + String.format("%.2f", sphere.calculateVolume()));
        printSeparator();
    }
    // UNDERSTAND: Handles Cone input/output
    // TRACE: baseRadius -> new Cone -> slant height -> surface area -> volume
    // DECISION: Slant height displayed separately as it is a useful value
    static void handleCone() {
        IO.println();
        printSeparator();
        IO.println("         RIGHT CIRCULAR CONE:        ");
        printSeparator();
        IO.print("Enter base radius: ");
        double baseRadius = Double.parseDouble(IO.readln().trim());
        IO.print("Enter height: ");
        double height = Double.parseDouble(IO.readln().trim());

        Cone cone = new Cone(baseRadius, height);
        printSeparator();
        IO.println("RESULTS:");
        IO.println("Slant Height: " + String.format("%.2f", cone.getSlantHeight()));
        IO.println("Surface Area: " + String.format("%.2f", cone.calculateSurfaceArea()));
        IO.println("Volume: " + String.format("%.2f", cone.calculateVolume()));
        printSeparator();
    }

    // UNDERSTAND: Handles Cylinder input/output
    // TRACE: baseRadius -> height -> new cylinder -> surface area -> volume
    static void handleCylinder() {
        IO.println();
        printSeparator();
        IO.println("      RIGHT CIRCULAR CYLINDER:       ");
        printSeparator();
        IO.print("Enter base radius: ");
        double baseRadius = Double.parseDouble(IO.readln().trim());
        IO.print("Enter height: ");
        double height = Double.parseDouble(IO.readln().trim());

        Cylinder cylinder = new Cylinder(baseRadius, height);
        printSeparator();
        IO.println("RESULTS:");
        IO.println("Surface Area: " + String.format("%.2f", cylinder.calculateSurfaceArea()));
        IO.println("Volume: " + String.format("%.2f", cylinder.calculateVolume()));
        printSeparator();
    }
}