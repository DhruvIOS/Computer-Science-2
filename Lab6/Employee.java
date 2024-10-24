public class Employee extends Person {
    private double payRate;
    private double hoursWorked;
    private String department;
    public final int HOURS = 40;
    public final double OVERTIME = 1.5;


    public Employee() {
        super();
        this.payRate = 0.0;
        this.hoursWorked = 0.0;
        this.department = "";
    }


    public Employee(String firstName, String lastName, double payRate, double hoursWorked, String department) {
        super(firstName, lastName);
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.department = department;
    }

 
    public String toString() {
        return "The wages for " + getLastName() + ", " + getFirstName() + " from the " + department + " department are: $" + String.format("%.2f", calculatePay());
    }

    public void print() {
        System.out.println("The employee " + getFirstName() + " " + getLastName() + " from the " + department + " department worked " + hoursWorked + " hours with a pay rate of $" + String.format("%.2f", payRate) + ". The wages for " + getFirstName() + " " + getLastName() + " are $" + String.format("%.2f", calculatePay()));
    }

    public double calculatePay() {
        if (hoursWorked <= HOURS) {
            return payRate * hoursWorked;
        } else {
            double regularPay = payRate * HOURS;
            double overtimePay = payRate * OVERTIME * (hoursWorked - HOURS);
            return regularPay + overtimePay;
        }
    }

    public void setAll(String first, String last, double rate, double hours, String dep) {
        setName(first, last);
        this.payRate = rate;
        this.hoursWorked = hours;
        this.department = dep;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public String getDepartment() {
        return department;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.payRate, payRate) == 0 &&
               Double.compare(employee.hoursWorked, hoursWorked) == 0 &&
               department.equals(employee.department);
    }

    public Employee getCopy() {
        return new Employee(getFirstName(), getLastName(), payRate, hoursWorked, department);
    }

    public void copy(Employee e) {
        super.copy(e);
        this.payRate = e.payRate;
        this.hoursWorked = e.hoursWorked;
        this.department = e.department;
    }
}