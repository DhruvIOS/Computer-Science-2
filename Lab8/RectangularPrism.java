public class RectangularPrism implements Shape3D {
    private double length;
    private double width;
    private double height;

    public RectangularPrism() {
        length = 0;
        width = 0;
        height = 0;
    }

    public RectangularPrism(double l, double w, double h) {
        length = l;
        width = w;
        height = h;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return 2 * (length * width + width * height + length * height);
    }

    public double getVolume() {
        return length * width * height;
    }

    public String toString() {
        return "RectangularPrism(length=" + length + ", width=" + width + ", height=" + height + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RectangularPrism)) return false;
        RectangularPrism other = (RectangularPrism) obj;
        return length == other.length && width == other.width && height == other.height;
    }
}
