// EmployeeTest class for Exam1 Question 32
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// EmployeeTest class
public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Joe", "King", 48));
        employeeList.add(new Employee("Jane", "Doe", 30));
        employeeList.add(new Employee("Joel", "Smith", 40));
        employeeList.add(new Employee("Bill", "Peterson", 27));
        employeeList.add(new Employee("David", "Calvin", 61));
        employeeList.add(new Employee("Frank", "Abraham", 53));

        // Sort by age (natural sorting)
        Collections.sort(employeeList);
        System.out.println("Sorted by age:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        // Sort by length of the last name
        Collections.sort(employeeList, new LastNameLengthComparator());
        System.out.println("\nSorted by the length of the last name:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}