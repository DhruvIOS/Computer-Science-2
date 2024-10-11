
import java.util.Scanner;

public class ComplexNumberClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            while (!sc.hasNextInt()) {
                System.out.println("WRONG TYPE! Not an integer! REENTER.");
                sc.next(); 
            }
            option = sc.nextInt();

            switch (option) {
                case 1: 
                    ComplexNumber c1 = new ComplexNumber();
                    ComplexNumber c2 = new ComplexNumber();
                    c1.readComplex(sc);
                    c2.readComplex(sc);
                    ComplexNumber sum = c1.add(c2);
                    System.out.print("First complex number is: ");
                    c1.printComplex();
                    System.out.print("Second complex number is: ");
                    c2.printComplex();
                    System.out.print("Result: ");
                    sum.printComplex();
                    break;

                case 2: 
                    c1 = new ComplexNumber();
                    c2 = new ComplexNumber();
                    c1.readComplex(sc);
                    c2.readComplex(sc);
                    ComplexNumber difference = c1.subtract(c2);
                    System.out.print("First complex number is: ");
                    c1.printComplex();
                    System.out.print("Second complex number is: ");
                    c2.printComplex();
                    System.out.print("Result: ");
                    difference.printComplex();
                    break;

                case 3: 
                    c1 = new ComplexNumber();
                    c2 = new ComplexNumber();
                    c1.readComplex(sc);
                    c2.readComplex(sc);
                    ComplexNumber product = c1.multiply(c2);
                    System.out.print("First complex number is: ");
                    c1.printComplex();
                    System.out.print("Second complex number is: ");
                    c2.printComplex();
                    System.out.print("Result: ");
                    product.printComplex();
                    break;

                case 4: 
                    c1 = new ComplexNumber();
                    c2 = new ComplexNumber();
                    c1.readComplex(sc);
                    c2.readComplex(sc);
                    ComplexNumber quotient = c1.divide(c2);
                    System.out.print("First complex number is: ");
                    c1.printComplex();
                    System.out.print("Second complex number is: ");
                    c2.printComplex();
                    System.out.print("Result: ");
                    quotient.printComplex();
                    break;

                case 5:
                    c1 = new ComplexNumber();
                    c1.readComplex(sc);
                    System.out.print("The complex number is: ");
                    c1.printComplex();
                    System.out.printf("Result: |%.2f|\n", c1.cAbs());
                    break;

                case 6: 
                    c1 = new ComplexNumber();
                    c2 = new ComplexNumber();
                    c1.readComplex(sc);
                    c2.readComplex(sc);
                    System.out.print("First complex number is: ");
                    c1.printComplex();
                    System.out.print("Second complex number is: ");
                    c2.printComplex();
                    if (c1.equals(c2)) {
                        System.out.println("The complex numbers are equal.");
                    } else {
                        System.out.println("The complex numbers are NOT equal.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        } while (option != 0);

        sc.close();
    }


    private static void displayMenu() {
        System.out.println("\nYour options for Complex arithmetic are:");
        System.out.println("----------------------------------------");
        System.out.println("1) Add 2 complex numbers");
        System.out.println("2) Subtract 2 complex numbers");
        System.out.println("3) Multiply 2 complex numbers");
        System.out.println("4) Divide 2 complex numbers");
        System.out.println("5) Absolute value of a complex number");
        System.out.println("6) Compare 2 complex numbers");
        System.out.println("0) EXIT");
        System.out.print("Please enter your option: ");
    }
}
