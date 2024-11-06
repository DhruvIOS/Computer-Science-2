public class Cylinder extends CircularShapeWithHeight {
    public Cylinder() {
        super(0, 0);
    }

    public Cylinder(double radius, double height) {
        super(radius, height);
    }

    public double getArea() {
        return getCrossSectionPerimeter() * getHeight() + 2 * getCrossSectionArea();
    }

    public double getVolume() {
        return getCrossSectionArea() * getHeight();
    }

    public String toString() {
        return "Cylinder(radius=" + getRadius() + ", height=" + getHeight() + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cylinder)) return false;
        Cylinder other = (Cylinder) obj;
        return getRadius() == other.getRadius() && getHeight() == other.getHeight();
    }
}
