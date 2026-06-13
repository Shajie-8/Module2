public abstract class Shape2D extends Shape implements Measurable2D {
    protected boolean filled;

    public Shape2D() {
        super();
        this.filled = false;
    }
