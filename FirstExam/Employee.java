package FirstExam;
// 1.  Create a class named Employee which contains the following private attributes, firstName (String), lastName (String), and age
// (int).  Create a natural sort for the class such that when the sort method of the Collections class is called with an arraylist of employee objects as an argument, 
//the sort will sort the objects by age in ascending order.

public class Employee {
    private String firstName;
    private String lastName;
    private int age;

    //Constructor
    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    // Getters

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
    
}