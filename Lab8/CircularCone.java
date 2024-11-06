public class CircularCone extends CircularShapeWithHeight {
    public CircularCone() {
        super(0, 0);
    }

    public CircularCone(double radius, double height) {
        super(radius, height);
    }

    public double getArea() {
        double r = getRadius();
        double h = getHeight();
        return Math.PI * r * Math.sqrt(r * r + h * h);
    }

    public double getVolume() {
        return getCrossSectionArea() * getHeight() / 3.0;
    }

    public String toString() {
        return "CircularCone(radius=" + getRadius() + ", height=" + getHeight() + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CircularCone)) return false;
        CircularCone other = (CircularCone) obj;
        return getRadius() == other.getRadius() && getHeight() == other.getHeight();
    }
}
