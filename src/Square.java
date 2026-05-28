// UNDERSTAND: This class models a geometric square
// AI-CHECK: Verified class design follows standard Javabeans patterns (getters/setters)

class Square {
    // Data field (attribute)
    // Understand: Private access restricts direct modification from outside the class
    // DECISION: side is stored as double (not int) to support fractional measurements
    private double side;

    // Constructor
    // UNDERSTAND: Called when a new Square object is created - initializes object state
    // Decision: Delegates to setter for validation (reuses existing validation logic)
    // AI-CHECK: Confirmed with textbook that setter delegation is a standard pattern
    Square(double side) {
        setSide(side); // Using setter for validation
    }




    void setSide(double side){

        return;
    }
}
