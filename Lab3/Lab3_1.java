import java.util.Scanner;
import java.util.Random;

public class Lab3_1 {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Start (y/n): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("y")) {
                int size = getInt(scanner, "How many elements in the list: ");
                int[] originalArray = initRand(random, size);
                print(originalArray, size, "The original array is: ");
                int[] duplicatedArray = twice(originalArray, size);
                print(duplicatedArray, size * 2, "The second array is: ");
                System.out.print("Continue (y/n): ");
                response = scanner.next();
                if (response.equalsIgnoreCase("n")) {
                    break;
                }else{
                     size = getInt(scanner, "How many elements in the list: ");
                 originalArray = initRand(random, size);
                print(originalArray, size, "The original array is: ");
                 duplicatedArray = twice(originalArray, size);
                print(duplicatedArray, size * 2, "The second array is: ");
                }
            } else {
                break;
            }
        }
    }

    public static int getInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Not an integer! Try again!");
                scanner.next();
            }
        }
    }

    public static int[] initRand(Random random, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        }
        return array;
    }

    public static void print(int[] array, int size, String message) {
        System.out.printf(message);
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

    public static int[] twice(int[] originalArray, int size) {
        int[] duplicatedArray = new int[size * 2];
        for (int i = 0; i < size; i++) {
            duplicatedArray[i * 2] = originalArray[i];
            duplicatedArray[i * 2 + 1] = originalArray[i];
        }
        return duplicatedArray;
    }
}