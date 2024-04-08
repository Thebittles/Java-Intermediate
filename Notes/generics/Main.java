
public class Main {
    public static void main(String[] args) {
        MyComparator<Integer> intComparator = new MyComparator<>();
        int result = intComparator.compare(10, 5);
        System.out.println(result); // Output: 1 (because 10 > 5)
    }
}