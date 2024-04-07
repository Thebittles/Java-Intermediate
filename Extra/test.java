import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Joe", "King", 48));
        employeeList.add(new Employee("Jane", "Doe", 30));
        employeeList.add(new Employee("Joel", "Smith", 40));
        employeeList.add(new Employee("Bill", "Peterson", 27));
        employeeList.add(new Employee("David", "Calvin", 61));
        employeeList.add(new Employee("Frank", "Abraham", 53));

        // Sort by age
        Collections.sort(employeeList);

        // Print sorted by age
        System.out.println("Sorted by age:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        // Sort by length of last name
        Collections.sort(employeeList, new LastNameLengthComparator());

        // Print sorted by length of last name
        System.out.println("\nSorted by length of last name:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private int age;

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

class LastNameLengthComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Integer.compare(emp1.getLastName().length(), emp2.getLastName().length());
    }
}