import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lab2_1 {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many elements in the list: ");
        int size = getInt(scanner);
        int[] array = new int[size];
        initRand(array);
        System.out.print("The list is: ");
        print(array);

        while (true) {
            int option = menu(scanner);
            switch (option) {
                case 1:
                    if (isAllEven(array)) {
                        System.out.println("All values are even.");
                    } else {
                        System.out.println("Some values are odd.");
                    }
                    break;
                case 2:
                    if (isUnique(array)) {
                        System.out.println("All values are unique.");
                    } else {
                        System.out.println("Some values appear multiple times.");
                    }
                    break;
                case 3:
                    System.out.println("The minimum gap between 2 adjacent values is " + minGap(array));
                    break;
                case 4:
                    System.out.println("The mean for this list is: " + String.format("%.2f", getMean(array)));
                    System.out.println("The variance for this list is: " + String.format("%.2f", getVariance(array)));
                    System.out.println("The standard deviation for this list is: " + String.format("%.2f", Math.sqrt(getVariance(array))));
                    break;
                case 5:
                    top_20(array);
                    break;
                case 0:
                    System.out.println("Testing completed.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static int getInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not an integer! Try again!");
                scanner.next();
            }
        }
    }

    public static void initRand(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

    public static boolean isAllEven(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUnique(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int minGap(int[] array) {
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            int gap = array[i + 1] - array[i];
            if (gap < minGap) {
                minGap = gap;
            }
        }
        return minGap;
    }

    public static int menu(Scanner scanner) {
        while (true) {
            System.out.println("Your options are:");
            System.out.println("-----------------");
            System.out.println("1) All even values?");
            System.out.println("2) All unique values?");
            System.out.println("3) Print min gap between values");
            System.out.println("4) Statistics");
            System.out.println("5) Print 80% percentile");
            System.out.println("0) EXIT");
            System.out.print("Please enter your option: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not an integer! Try again!");
                scanner.next();
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void copy(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

    public static void top_20(int[] array) {
        int[] copy = new int[array.length];
        copy(array, copy);
        bubbleSort(copy);
        int start = (int) (copy.length * 0.8);
        System.out.print("80%-percentile from this list: ");
        for (int i = start; i < copy.length; i++) {
            System.out.print(copy[i] + " ");
        }
        System.out.println();
    }

    public static double getMean(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / array.length;
    }

    public static double getVariance(int[] array) {
        double mean = getMean(array);
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.pow(array[i] - mean, 2);
        }
        return sum / array.length;
    }

}