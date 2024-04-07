//********************************************************************
//
//  Developer:     Brittany Sifford
//
//  Program #:     Seven
//
//  File Name:     InvalidSubscriptionException.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      4/06/2024
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       20
//
//  Description:    Custom exception class InvalidSubscriptException which inherits from RuntimeException
//                  used for handling invalid array subscript errors
//
//********************************************************************



class InvalidSubscriptException extends RuntimeException {
    public InvalidSubscriptException(String message) {
        super(message);
    }
}