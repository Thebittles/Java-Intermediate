	
Write a generic non-static method named largestDataInSubArray that returns the largest value in a subarray of a wrapper class. The method should accept an array, a lowSubscript, and a highSubscript.  Validate the subscripts.  A call to the method should return the largest value in the subarray.

Here is a test class for the method largestDataInSubArray.
```java

public class LargestDataInSubArrayTest
{
   public static void main(String[] args)
   {
       LargestDataInSubArrayTest obj = new LargestDataInSubArrayTest();
      
       // create arrays of Integer, Double and Character
       Integer[] integerArray = {99, 2, 31, 4, 45, 7, 15, 24, 20};
       Double[] doubleArray = {21.1, 12.2, 3.3, 44.4, 15.5, 6.6, 17.7};
       Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

       Integer test1 = obj.largestDataInSubArray(integerArray, 0, 5);
       System.out.printf("Largest in integerArray is %s%n", test1);
      
       Double test2 = obj.largestDataInSubArray(doubleArray, 1, 5);
       System.out.printf("Largest in doubleArray is %s%n", test2);

       Character test3 = obj.largestDataInSubArray(characterArray, 1, 3);
       System.out.printf("Largest in characterArray is %s%n", test3);
   }
  
      // Your method goes here (Write only the method)

}
```

```java

public <T extends Comparable<T>> T largestDataInSubArray(T[] array, int lowSubscript, int highSubscript) {
    // Validate the subscripts
    if (lowSubscript < 0 || highSubscript >= array.length || lowSubscript > highSubscript) {
        throw new IllegalArgumentException("Invalid subscripts");
    }

    // Start with the first element in the subarray
    T largest = array[lowSubscript];

    // Loop through the subarray and find the largest element
    for (int i = lowSubscript + 1; i <= highSubscript; i++) {
        if (array[i].compareTo(largest) > 0) {
            largest = array[i];
        }
    }

    return largest;
}

```