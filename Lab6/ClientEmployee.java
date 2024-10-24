import java.util.Scanner;

public class ClientEmployee {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        String last, first, dept;
        double pay_rate;
        int hours;


        Employee prof = new Employee("John", "Doe", 25.50, 50, "COSC");
        Employee newEmp = new Employee();


        System.out.println("--- Record for both employees with overridden .toString from subclass ---");
        System.out.println(prof.toString());


        System.out.print("Enter employee last name: ");
        last = input.nextLine();
        System.out.print("Enter employee first name: ");
        first = input.nextLine();
        System.out.print("Enter department: ");
        dept = input.nextLine();
        System.out.print("Enter employee pay rate: ");
        pay_rate = input.nextDouble();
        System.out.print("Enter employee hours worked: ");
        hours = input.nextInt();


        newEmp.setAll(first, last, pay_rate, hours, dept);


        System.out.println("--- Record for both employees with overridden .toString from subclass ---");
        System.out.println(newEmp.toString());


        System.out.println("--- Output with calls to overridden method print from subclass ---");
        prof.print();
        newEmp.print();


        System.out.println("--- Output with calls to getters from the superclass ---");
        System.out.println(newEmp.toString());


        if (prof.equals(newEmp)) {
            System.out.println("Found an employee with the same record.");
        } else {
            System.out.println("Couldn't find an employee with the same record.");
        }

        input.close();
    }
}