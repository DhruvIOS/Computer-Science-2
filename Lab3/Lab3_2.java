import java.util.Scanner;
import java.util.Random;

public class Lab3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Do you want to start(Y/N): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("y")) {
                int rows = getInt(scanner, "How many rows: ");
                int cols = getInt(scanner, "How many columns: ");
                int[][] matrix = initRand(random, rows, cols);
                print(matrix, "The matrix is: ");
                findFlippedRows(matrix, rows, cols);
                System.out.print("Do you want to continue(Y/N): ");
                response = scanner.next();
                if (response.equalsIgnoreCase("n")) {
                    break;
                } else {
                    rows = getInt(scanner, "How many rows: ");
                    cols = getInt(scanner, "How many columns: ");
                    matrix = initRand(random, rows, cols);
                    print(matrix, "The matrix is: ");
                    findFlippedRows(matrix, rows, cols);
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

    public static int[][] initRand(Random random, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix, String message) {
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("[%d] ", i);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void findFlippedRows(int[][] matrix, int rows, int cols) {
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                if (isFlipped(matrix, i, j, cols)) {
                    System.out.printf("Rows index %d and %d are flipped.%n", i, j);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No flipped rows in this matrix.");
        }
    }

    public static boolean isFlipped(int[][] matrix, int row1, int row2, int cols) {
        for (int i = 0; i < cols; i++) {
            if (matrix[row1][i] != matrix[row2][cols - i - 1]) {
                return false;
            }
        }
        return true;
    }
}