// *************************************************************
//
// Developer Brittany Sifford
//
// Program #: Six
//
// File Name: Program6.java
//
// Course: ITSE 2317 Java Programming (Intermediate)
//
// Due Date: 3/29/2024
//
// Instructor: Prof. Fred Kumi
//
// Chapter: 18 - Recursion 
//
// Description:  The program calculates Fibonacci values from 0 to 40 while measuring the elapsed
// time and the number of recursive calls made to the fibonacci method
//
//
//
// ******************************************************************


import java.math.BigInteger;

public class Program6 {


    public static void main(String[] args) {
        developerInfo();

        // Displays the Fibonacci values from 0-40
        for (int counter = 0; counter <= 40; counter++) {
            long startTime = System.currentTimeMillis(); // Start time
            int[] count = {0}; // count array to hold the count - Needs to be array to pass by ref (pass by value did not work)
            BigInteger result = fibonacci(BigInteger.valueOf(counter), count);
            long endTime = System.currentTimeMillis(); // End time
            long elapsedTime = endTime - startTime; // Calculate elapsed time
            System.out.printf("Fibonacci of %d is: %d%n took %d milliseconds%n took %d recursive calls%n%n",
                    counter, result, elapsedTime, count[0]); //Display output
        }
    }

    //Fibonacci Calculator 
    private static BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger fibonacci(BigInteger number, int[] count) {
        count[0]++; // Increment count of recursive calls
        if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
            return number;
        } else {
            return fibonacci(number.subtract(BigInteger.ONE), count).add(fibonacci(number.subtract(TWO), count));
        }
    }


    // Display Developer Info
    public static void developerInfo() {
        System.out.println("Name:   Brittany Sifford");
        System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Project: Six\n");
    }
}