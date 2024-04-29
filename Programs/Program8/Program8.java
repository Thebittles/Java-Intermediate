//********************************************************************
//
//  Developer:     Brittany Sifford
//
//  Program #:     Eight
//
//  File Name:     Program8.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      4/17/2024
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       21
//
//  Description:   Converts infix expression to postfix expression allows user
//                 to enter as many expressions as they like until entering 0 to terminate program.
//
//********************************************************************

import java.util.Scanner;

public class Program8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Store user input
        boolean continueRunning = true; //Sentinel val

        Program8 program = new Program8();
        program.developerInfo();


        // Loop until the user enters 0 
        while (continueRunning) {
            // Prompt the user to enter the infix expression
            System.out.print("Enter an infix expression (or 0 to exit): ");
            String infixExpression = scanner.nextLine();

            // Check if user entered  0
            if (infixExpression.equals("0")) {
                System.out.println("Exiting the program...");
                continueRunning = false; // Set the flag false to exit the loop
            } else {
                // Create an instance of InfixToPostFix and pass the expression
                InfixToPostFix converter = new InfixToPostFix(infixExpression);

                // Convert the infix expression to postfix
                StringBuffer postfixExpression = converter.convertToPostfix();

                // Print the postfix expression
                System.out.println("Postfix expression: " + postfixExpression);
                //Creating space between runs
                System.out.println();
            }
        }

        scanner.close();
    }

    // ***************************************************************
    //
    // Method: developerInfo (Non Static)
    //
    // Description: The developer information method of the program
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public void developerInfo() {
        System.out.println("Name:    Brittany Sifford");
        System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Project: Eight\n");
    }

}