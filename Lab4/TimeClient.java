import java.util.InputMismatchException;
import java.util.Scanner;

public class TimeClient {
    public static void main(String[] args) {
       
        Time t1 = new Time(8, 15, 30);

        // Print the initial time t1 in military and standard formats
        System.out.println("Initial time t1 (alternate constructor invoked) - military format: " + formatTime(t1, "military"));
        System.out.println("Initial time t1 (alternate constructor invoked) - standard format: " + formatTime(t1, "standard"));


        Time t2 = new Time();


        System.out.println("Initial time t2 (default constructor invoked) - military format: " + formatTime(t2, "military"));
        System.out.println("Initial time t2 (default constructor invoked) - standard format: " + formatTime(t2, "standard"));


        t2.set(9, 45, 35);


        System.out.println("t2 after call to setTime - military format: " + formatTime(t2, "military"));
        System.out.println("t2 after call to setTime - standard format: " + formatTime(t2, "standard"));


        System.out.println("After call to equals: " + (t1.equals(t2) ? "times are equal" : "times are NOT equal"));

        // Compare t1 and t2 using the lessThan method
        System.out.println("After call to lessThan: " + (t1.lessThan(t2) ? "t1 is less than t2" : "t1 is not less than t2"));


        Scanner scanner = new Scanner(System.in);
        int hrs, mins, secs;
        while (true) {
            try {
                System.out.print("Enter hours (0-23): ");
                hrs = scanner.nextInt();
                if (hrs < 0 || hrs > 23) {
                    System.out.println("Invalid hour. Please enter a value between 0 and 23.");
                    continue;
                }
                System.out.print("Enter minutes (0-59): ");
                mins = scanner.nextInt();
                if (mins < 0 || mins > 59) {
                    System.out.println("Invalid minute. Please enter a value between 0 and 59.");
                    continue;
                }
                System.out.print("Enter seconds (0-59): ");
                secs = scanner.nextInt();
                if (secs < 0 || secs > 59) {
                    System.out.println("Invalid second. Please enter a value between 0 and 59.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
                scanner.next();
            }
        }


        t1.set(hrs, mins, secs);


        System.out.println("New time t1 after call to setTime - standard format: " + formatTime(t1, "standard"));


        t1.advanceSecs();


        System.out.println("New time t1 after call to advanceSecs - standard format: " + formatTime(t1, "standard"));


        t2.copy(t1);


        System.out.println("New t2 after call to copy - standard format: " + formatTime(t2, "standard"));


        System.out.println("Test toString for t2: " + t2.toString());
    }


    private static String formatTime(Time time, String format) {
        if (format.equals("military")) {
            time.toMilitary();
            return String.format("%02d:%02d:%02d", time.getHrs(), time.getMins(), time.getSecs());
        } else if (format.equals("standard")) {
            time.toStandard();
            return time.toString();
        } else {
            return "";
        }
    }
}