public class Cube extends RectangularPrism {
    public Cube() {
        super(0, 0, 0);
    }

    public Cube(double size) {
        super(size, size, size);
    }

    public String toString() {
        return "Cube(size=" + getLength() + ")";
    }
}