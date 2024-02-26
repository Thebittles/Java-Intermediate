//********************************************************************
//  Developer:    Brittany Sifford
//
//  Program #:    Two
//
//  File Name:    ThreeDimensionalShape.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  ThreeDimensionalShape class represents an abstract three-dimensional shape, providing methods to calculate its area and volume.
//
//********************************************************************

public abstract class ThreeDimensionalShape extends Shape {

    // ***************************************************************
    //
    // Method: getArea
    //
    // Description: Abstract method to calculate the surface area of the shape.
    //
    // Parameters: None
    //
    // Returns: double - The surface area of the shape.
    //
    // ***************************************************************

    public abstract double getArea();

    // ***************************************************************
    //
    // Method: getVolume
    //
    // Description: Abstract method to calculate the volume of the shape.
    //
    // Parameters: None
    //
    // Returns: double - The volume of the shape.
    //
    // ***************************************************************

    public abstract double getVolume();

    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the three-dimensional shape.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string indicating the dimension of the
    // shape.
    //
    // ***************************************************************
    @Override
    public String toString() {
        return String.format("%s", "Dimension: Three-Dimensional");
    }

}