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

        System.out.println("Sorted by Age:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        // Sort by length of last name
        Collections.sort(employeeList, Comparator.comparingInt(emp -> emp.getLastName().length()));

        System.out.println("\nSorted by Length of Last Name:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}