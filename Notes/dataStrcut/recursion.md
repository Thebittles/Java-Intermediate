
# Recursion

**Assignment is on 18.5** - use long for time

- Capable of solving only the simplest cases(s) or base cases(s)
- If the method is called with more complex problem, divids prob into two conceptual pieces


- Two type of recursive calls
    - Indirect recursive call 
    - Indirect recursion


```java
public class FactorialCalculator {
    //recursive method factorial (assumes its parameter is >= 0)
    public static long factorial(long number){
        if(number <= 1){ //test for base case
            return 1; //base cases: 0! = 1 and 1! = 1
        } else { //recursion step
            return number * factorial(number - 1);
        }
    }
}
```

```java 

public static void main(String[] args){
    //calculate the factorials of 0 through 21
    for (int counter = 0; counter <= 21; counter++){
        System.out.printf("%d! = %d%n", counter, facrotiral(counter))
    }
}

// 0! = 1
// 1! = 1
// 2! = 2
// 3! = 6
// 4! = 24
// 5! = 120
//....
//....
// 12! = 479001600  12! causes overflow for int variables
//....
// 20! = 2432902008176640000
// 21! =  //causes overflow for long variables



```


```java

import java.math.BigInteger;

public class FactorialCalculator {
    //recursive method factorial (assumes its parameter is >= 0)
    public static BigInteger factorial(BigInteger number){
        if(number.compareTo(BigInteger.ONE) <= 0){ //test for base case
            return BigInteger.ONE; //base cases: 0! = 1 and 1! = 1
        } else { //recursion step
            return number.multiply(factorial(number.subtract())); //Need to finish writing thigs
        }
    }
}
```




```java



```