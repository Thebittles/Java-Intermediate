//********************************************************************
//
//  Developer:     Brittany Sifford
//
//  Program #:     Eight
//
//  File Name:     InfixToPostFix.java
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

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostFix {
    private Stack<Character> stack;
    private StringBuffer infix;
    private StringBuffer postfix;
    private static final Map<Character, Integer> precedenceMap;

    // Created hash map instead of using switch statement
    // Key is operator value is precedence ^ has the highest precedence followed by
    // * / % etc...
    static {
        precedenceMap = new HashMap<>();
        precedenceMap.put('^', 3);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('%', 2);
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
    }

    // Constructor
    public InfixToPostFix(String infixExpression) {
        stack = new Stack<>();
        infix = new StringBuffer(infixExpression);
        postfix = new StringBuffer();
    }

    // Method to convert infix to postfix
    public StringBuffer convertToPostfix() {
        stack.push('('); // Push a left parenthesis '(' onto the stack.
        infix.append(')'); // Append a right parenthesis ')' to the end of infix.

        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            // If the current character in infix is a digit, append it to postfix.
            if (Character.isDigit(currentChar)) {
                postfix.append(currentChar);
                postfix.append(" "); // Creating space b/w characters
            }
            // If the current character in infix is a left parenthesis, push it onto the
            // stack.
            else if (currentChar == '(') {
                stack.push(currentChar);
            }
            // If the current character in infix is an operator:
            else if (isOperator(currentChar)) {

            // Pop operators (if there are any) at the top of the stack while they have equal
            // or higher precedence than the current operator, and append the popped operators to postfix.
            while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(currentChar)) {
                postfix.append(stack.pop());
                postfix.append(" ");
            }
            // Push current operator onto stack
            stack.push(currentChar);
            }
            // If right parenthesis
            else if (currentChar == ')') {
                // Pop operators until matching left parenthesis is found
                while (stack.peek() != '(') {
                    postfix.append(stack.pop());
                    postfix.append(" ");
                }
                // Discard left parenthesis
                stack.pop();
            }
        }

        return postfix;
    }

    // Check if char is an operator
    private boolean isOperator(char c) {
        return precedenceMap.containsKey(c);
    }

    // Get precedence of an operator
    private int precedence(char c) {
        return precedenceMap.getOrDefault(c, 0);
    }
}