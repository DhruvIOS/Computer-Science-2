public class Person {
    private String firstName;
    private String lastName;


    public Person() {
        this.firstName = "";
        this.lastName = "";
    }


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void printLastFirst() {
        System.out.println(lastName + ", " + firstName);
    }

    public void print() {
        System.out.println(firstName + " " + lastName);
    }


    
    public String toString() {
        return firstName + " " + lastName;
    }


 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }


    public Person getCopy() {
        return new Person(this.firstName, this.lastName);
    }

    public void copy(Person p) {
        this.firstName = p.firstName;
        this.lastName = p.lastName;
    }
}