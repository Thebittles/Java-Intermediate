import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//https://www.youtube.com/watch?v=tklkyVa7KZo&t=276s
public class Demo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 6, 7);

        Stream<Integer> data = nums.stream();

        data.forEach(n -> System.out.println(n));
    }
}
