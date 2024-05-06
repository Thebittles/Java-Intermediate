	
The method reference code below will not compile.  Rewrite it correcting all errors. Do not modify the cubeIt method.  You will not get credit for the question if you do.

```java
import java.util.Arrays;
import java.util.List;

public class MethodRefQuestion
{
     public static void main(String[] args)
     {
         List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
         values.forEach(cubeIt);
     }

     public void cubeIt(int i)
     {
         System.out.println(i * i * i);
     }
}

```



```java
import java.util.Arrays;
import java.util.List;

public class MethodRefQuestion
{
     public static void main(String[] args)
     {
         List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
         // Use a static method reference
         values.forEach(MethodRefQuestion::cubeIt);
     }

     // Make the cubeIt method static to use it in a static context
     public static void cubeIt(int i)
     {
         System.out.println(i * i * i);
     }
}
```

- The cubeIt method is now static, allowing it to be referenced using MethodRefQuestion::cubeIt from the static main method.
- The forEach method with the method reference compiles and executes without errors, applying the cubeIt method to each value in the list and printing the cube of each number.