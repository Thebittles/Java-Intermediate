Complete the program below. Use Lambdas and Streams to remove all the empty Strings from list and print the new stream.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Question4
{
   public static void main(String[] args)
   {

      List<String> list = Arrays.asList("abc", "", "bcdf", "", "defgh", "ijk");

      // Removes all empty Strings from List
      System.out.printf("%nStrings with more with 1 or more characters: %s%n",

             // Your code goes here

   }
}
```

```java
// Selected Answer:  WRONG 3/5
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Question4
{
   public static void main(String[] args)
   {

      List<String> list = Arrays.asList("abc", "", "bcdf", "", "defgh", "ijk");

          // Your code goes here
          List<String> stringsMoreThanOne = list.stream()
          .filter(s -> s.length() > 1)
          .collect(Collectors.toList());
      // Removes all empty Strings from List
      System.out.printf("%nStrings with more with 1 or more characters: %s%n", stringsMoreThanOne);



   }
}
```

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Question4 {
   public static void main(String[] args) {
      List<String> list = Arrays.asList("abc", "", "bcdf", "", "defgh", "ijk");

      // Removes all empty strings from the list
      Stream<String> nonEmptyStrings = list.stream() // create a stream from the list
                                           .filter(s -> !s.isEmpty()); // filter out empty strings

      // Output the non-empty strings
      System.out.printf("Strings with one or more characters: %s%n", nonEmptyStrings.collect(Collectors.toList()));
   }
}


```
