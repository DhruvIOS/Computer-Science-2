public class Point {
    private int x;
    private int y;


    public Point() {
        this.x = 0;
        this.y = 0;
    }


    public Point(int x, int y) {
        this.x = validateCoordinate(x);
        this.y = validateCoordinate(y);
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public void set(int x, int y) {
        this.x = validateCoordinate(x);
        this.y = validateCoordinate(y);
    }


    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }


    public void copy(Point point) {
        this.x = point.x;
        this.y = point.y;
    }


    public Point getCopy() {
        return new Point(x, y);
    }


    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public double distance(Point point) {
        int dx = x - point.x;
        int dy = y - point.y;
        return Math.sqrt(dx * dx + dy * dy);
    }


    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }


    public boolean isHorizontal(Point point) {
        return y == point.y;
    }


    public boolean isVertical(Point point) {
        return x == point.x;
    }


    public double slope(Point point) {
        if (x == point.x) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (y - point.y) / (x - point.x);
    }


    private int validateCoordinate(int coord) {
        return coord > 0 ? coord : 0;
    }
}