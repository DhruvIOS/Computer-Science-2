/*
 * Darrien Jimenez, Dhruv Shah, Nate
 * Assignment 1
 *
 */

import java.util.*;

public class Assigment1_2 {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int option = menu(scanner);

            switch (option) {
                case 1:

                    int size = numInput("How many elements in the list: ", scanner);
                    int[] arr = new int[size];
                    initRand(arr);

                    System.out.println("The original list is ");

                    for (int i = 0; i < arr.length; i++) {
                        System.out.printf("%d ", arr[i]);

                    }

                    int[] rotatedLeftArray = shiftLeft(arr);
                    System.out.println();
                    System.out.println("Rotated array is:");
                    print(rotatedLeftArray, rotatedLeftArray.length);
                    break;
                case 2:
                    int kLeftsize = numInput("How many elements in the list: ", scanner);
                    int[] kLeftArr = new int[kLeftsize];
                    initRand(kLeftArr);

                    System.out.println("The original list is ");

                    for (int i = 0; i < kLeftArr.length; i++) {
                        System.out.printf("%d ", kLeftArr[i]);

                    }
                    int kLeft = numInput("Input k (step for shift left)", scanner);

                    int[] rotatedLeftArrayK = shiftLeft(kLeftArr, kLeft);
                    System.out.println();
                    System.out.println("Rotated array is:");

                    print(rotatedLeftArrayK, rotatedLeftArrayK.length);

                case 3:

                    int kSecondLeftsize = numInput("How many elements in the list: ", scanner);
                    int[] kSecondLeftarr = new int[kSecondLeftsize];
                    initRand(kSecondLeftarr);
                    System.out.println("The original list is ");

                    for (int i = 0; i < kSecondLeftarr.length; i++) {
                        System.out.printf("%d ", kSecondLeftarr[i]);

                    }
                    int kSecondLeft = numInput("Input k (step for shift left)", scanner);

                    int[] rotatedLeftArrayKSecond = shiftLeftK(kSecondLeftarr, kSecondLeftarr.length, kSecondLeft);
                    System.out.println();
                    System.out.println("Second array is:");
                    System.out.println("The second list after left rotation with " + kSecondLeft + " is:");

                    print(rotatedLeftArrayKSecond, rotatedLeftArrayKSecond.length);

                case 4:

                    int Rightsize = numInput("How many elements in the list: ", scanner);
                    int[] RIghtarr = new int[Rightsize];
                    initRand(RIghtarr);
                    System.out.println("The original list is ");

                    for (int i = 0; i < RIghtarr.length; i++) {
                        System.out.printf("%d ", RIghtarr[i]);

                    }
                    int[] rotatedRightArray = shiftRight(RIghtarr);
                    System.out.println();

                    System.out.println("Roated array is:");
                    print(rotatedRightArray, rotatedRightArray.length);
                    break;

                case 5:

                    int kRIghtsize = numInput("How many elements in the list: ", scanner);
                    int[] kRightarr = new int[kRIghtsize];
                    initRand(kRightarr);
                    System.out.println("The original list is ");

                    for (int i = 0; i < kRightarr.length; i++) {
                        System.out.printf("%d ", kRightarr[i]);

                    }
                    int kRight = numInput("Input k (step for right left)", scanner);

                    int[] rotatedRightArrayK = shiftLeft(kRightarr, kRight);
                    System.out.println("Rotated array is:");

                    print(rotatedRightArrayK, rotatedRightArrayK.length);

                case 6:

                    int kSecondRightsize = numInput("How many elements in the list: ", scanner);
                    int[] kSecondRihtarr = new int[kSecondRightsize];
                    initRand(kSecondRihtarr);
                    System.out.println("The original list is ");

                    for (int i = 0; i < kSecondRihtarr.length; i++) {
                        System.out.printf("%d ", kSecondRihtarr[i]);

                    }
                    int kSecondRIght = numInput("Input k (step for shift left)", scanner);

                    int[] rotatedRIghtArrayKSecond = shiftLeftK(kSecondRihtarr, kSecondRihtarr.length, kSecondRIght);
                    System.out.println();

                    System.out.println("Second array is:");
                    System.out.println("The second list after right rotation with " + kSecondRIght + " is:");

                    print(rotatedRIghtArrayKSecond, rotatedRIghtArrayKSecond.length);
                    break;
                case 0:
                    System.out.println("Testing completed.");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");

            }

        }

    }

    public static int numInput(String prompt, Scanner input) {

        System.out.println();
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return input.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Not an integer! Try again!");
                input.next();
            }
        }
    }

    public static int menu(Scanner scanner) {

        System.out.println();
        while (true) {
            System.out.printf("%s \n", "Your Options are: ");
            System.out.printf("%s \n", "--------------------------");
            System.out.printf("\t  %d) %s \n", 1, "Shift Left ");
            System.out.printf("\t  %d) %s \n", 2, "Shift Left (k steps)/ in place ");
            System.out.printf("\t  %d) %s \n", 3, "Shift Left (k steps)/ second array ");
            System.out.printf("\t  %d) %s \n", 4, "Shift RIght ");
            System.out.printf("\t  %d) %s \n", 5, "Shift Right (k steps)/ in place ");
            System.out.printf("\t  %d) %s \n", 6, "Shift RIght (k steps)/ second array ");
            System.out.printf("\t  %d) %s \n", 0, "Exit ");
            System.out.print("Please enter your option: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not an integer! Try again!");
                scanner.next();
            }
        }

    }

    public static void print(int[] array, int s) {
        if (s > array.length || s < 0)
            return;

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static int[] shiftLeft(int[] array) {
        if (array.length == 0)
            return array;

        int firstElement = array[0];

        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }

        array[array.length - 1] = firstElement;

        return array;
    }

    public static int[] shiftLeft(int[] array, int k) {
        if (array.length == 0)
            return array;

        k = k % array.length;

        for (int i = 0; i < k; i++) {

            int firstElement = array[0];

            for (int j = 1; j < array.length; j++) {
                array[j - 1] = array[j];
            }

            array[array.length - 1] = firstElement;
        }

        return array;
    }

    public static int[] shiftRight(int[] array) {
        if (array.length == 0)
            return array;

        int lastElement = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = lastElement;

        return array;
    }

    public static int[] shiftRight(int[] array, int k) {
        if (array.length == 0)
            return array;

        k = k % array.length;

        for (int i = 0; i < k; i++) {

            int lastElement = array[array.length - 1];

            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }

            array[0] = lastElement;
        }

        return array;
    }

    public static int[] shiftLeftK(int[] array, int s, int k) {

        int[] rotatedArray = new int[s];

        k = k % s;
        for (int i = 0; i < s; i++) {

            rotatedArray[i] = array[(i + k) % s];

        }

        return rotatedArray;
    }

    public static int[] shiftRightK(int[] array, int s, int k) {

        int[] rotatedArray = new int[s];

        k = k % s;

        for (int i = 0; i < s; i++) {

            rotatedArray[(i + k) % s] = array[i];
        }

        return rotatedArray;
    }

    public static void initRand(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        }
    }

}
