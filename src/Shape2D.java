public abstract class Shape2D extends Shape implements Measurable2D {
    protected boolean filled;

    public Shape2D() {
        super();
        this.filled = false;
    }

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