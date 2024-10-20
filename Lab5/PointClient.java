import java.util.InputMismatchException;
import java.util.Scanner;

public class PointClient {
    public static void main(String[] args) {

        Point point1 = new Point();
        Point point2 = new Point(7, 13);
        Point point3 = new Point(7, 15);


        System.out.println("---After declaration, constructors invoked---");
        System.out.println("Using toString():");
        System.out.println("First point is " + point1.toString());
        System.out.println("Second point is " + point2.toString());
        System.out.println("Third point is " + point3.toString());


        if (point2.isVertical(point3)) {
            System.out.println("Second point (" + point2.getX() + ", " + point2.getY() + ") lines up vertically with third point (" + point3.getX() + ", " + point3.getY() + ")");
        } else {
            System.out.println("Second point (" + point2.getX() + ", " + point2.getY() + ") doesn't line up vertically with third point (" + point3.getX() + ", " + point3.getY() + ")");
        }

        if (point2.isHorizontal(point3)) {
            System.out.println("Second point (" + point2.getX() + ", " + point2.getY() + ") lines up horizontally with third point (" + point3.getX() + ", " + point3.getY() + ")");
        } else {
            System.out.println("Second point (" + point2.getX() + ", " + point2.getY() + ") doesn't line up horizontally with third point (" + point3.getX() + ", " + point3.getY() + ")");
        }


        Scanner scanner = new Scanner(System.in);
        int x, y;
        while (true) {
            try {
                System.out.print("Enter the x-coordinate for first point: ");
                x = scanner.nextInt();
                if (x <= 0) {
                    System.out.println("ERROR! Should be positive.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Not an integer! Try again!");
                scanner.next();
            }
        }

        while (true) {
            try {
                System.out.print("Enter the y-coordinate for first point: ");
                y = scanner.nextInt();
                if (y <= 0) {
                    System.out.println("ERROR! Should be positive.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Not an integer! Try again!");
                scanner.next();
            }
        }


        point1.set(x, y);
        System.out.println("First point (after call to set) is (" + point1.getX() + ", " + point1.getY() + ")");


        System.out.println("Distance from origin for first point = " + point1.distanceFromOrigin());
        System.out.println("Distance from origin for second point = " + point2.distanceFromOrigin());
        System.out.println("Distance between first point and second point = " + point1.distance(point2));


        point1.translate(5, 10);
        point2.translate(5, 10);
        System.out.println("First point (after call to translate (5, 10)) is (" + point1.getX() + ", " + point1.getY() + ")");
        System.out.println("Second point (after call to translate (5, 10)) is (" + point2.getX() + ", " + point2.getY() + ")");


        if (point1.equals(point2)) {
            System.out.println("---Call to equals: The 2 points are equal.");
        } else {
            System.out.println("---Call to equals: The 2 points are NOT equal.");
        }


        Point point4 = new Point();
        point4.copy(point1);
        Point point5 = new Point();
        point5.copy(point1);
        System.out.println("---Calls to copy and print---");
        System.out.println("First point (after call to copy) is (" + point4.getX() + ", " + point4.getY() + ")");
        System.out.println("Second point (after call to copy) is (" + point5.getX() + ", " + point5.getY() + ")");


        if (point4.equals(point5)) {
            System.out.println("---Call to equals after call to copy: The 2 points are equal.");
        } else {
            System.out.println("---Call to equals after call to copy: The 2 points are NOT equal.");
        }
    }
}