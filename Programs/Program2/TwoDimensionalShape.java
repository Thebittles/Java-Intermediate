//********************************************************************
//  Developer:    Brittany Sifford 
//
//  Program #:    Two
//
//  File Name:    TwoDimensionalShape.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  TwoDimensionalShape class represents an abstract two-dimensional shape, providing a method to calculate its area.
//
//********************************************************************

public abstract class TwoDimensionalShape extends Shape {

    // ***************************************************************
    //
    // Method: getArea
    //
    // Description: Abstract method to calculate the area of the shape.
    //
    // Parameters: None
    //
    // Returns: double - The area of the shape.
    //
    // ***************************************************************

    public abstract double getArea();

    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the two-dimensional shape.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string indicating the dimensionality of the
    // shape.
    //
    // ***************************************************************

    @Override
    public String toString() {
        return String.format("%s", "Dimension: Two-Dimensional");
    }

}