Write a boolean generic non-static method named isEqualTo that compares two argument passed to it using the equals method of the Object class and returns true if they are equal and false otherwise.  Write only one statement in the method body.  You will not get credit for the question if you write more than one statement.
```java
//Selected Answer:	 - WRONG 2/4
    Predicate<T> isEqualTo = (item1, item2) -> {
        return item1.equals(item2)
    }
    
```


```java
//Corrected
public <T> boolean isEqualTo(T a, T b) {
    return a.equals(b);
}
```

