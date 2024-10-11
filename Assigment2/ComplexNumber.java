
import java.util.Scanner;
import java.util.InputMismatchException;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void readComplex(Scanner sc) {
        System.out.print("Enter the real part: ");
        this.real = getValidDouble(sc);
        System.out.print("Enter the imaginary part: ");
        this.imaginary = getValidDouble(sc);
    }

    private static double getValidDouble(Scanner sc) {
        while (true) {
            try {
                double value = sc.nextDouble();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next();
            }
        }
    }

    public void printComplex() {
        System.out.printf("(%.2f, %.2f)\n", real, imaginary);
    }

    public boolean equals(ComplexNumber compNum) {
        return this.real == compNum.real && this.imaginary == compNum.imaginary;
    }

    public ComplexNumber copy() {
        return new ComplexNumber(this.real, this.imaginary);
    }

    public ComplexNumber add(ComplexNumber compNum) {
        return new ComplexNumber(this.real + compNum.real, this.imaginary + compNum.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber compNum) {
        return new ComplexNumber(this.real - compNum.real, this.imaginary - compNum.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber compNum) {
        double newReal = this.real * compNum.real - this.imaginary * compNum.imaginary;
        double newImaginary = this.real * compNum.imaginary + this.imaginary * compNum.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber compNum) {
        double denominator = compNum.real * compNum.real + compNum.imaginary * compNum.imaginary;
        double newReal = (this.real * compNum.real + this.imaginary * compNum.imaginary) / denominator;
        double newImaginary = (this.imaginary * compNum.real - this.real * compNum.imaginary) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    public double cAbs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
}
