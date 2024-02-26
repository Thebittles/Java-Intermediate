//********************************************************************
//  Developer:    Brittany Sifford
//
//  Program #:    Two
//
//  File Name:    Square.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  Square class represents a two-dimensional square shape, calculates its area.
//
//********************************************************************

public class Square extends TwoDimensionalShape {
    private double length;

    // ***************************************************************
    //
    // Method: Square
    //
    // Description: Constructor to initialize a Square object with a given side
    // length.
    //
    // Parameters: length (double) - The length of the square's side.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public Square(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be positive");
        }
    }

    // =========== Setters ===========//

    // ***************************************************************
    //
    // Method: setLength
    //
    // Description: Sets the length of the square's side.
    //
    // Parameters: length (double) - The new length value.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length must be positive");
        }
    }

    // =========== Getters ===========//

    // ***************************************************************
    //
    // Method: getLength
    //
    // Description: Retrieves the length of the square's side.
    //
    // Parameters: None
    //
    // Returns: double - The length of the square's side.
    //
    // ***************************************************************

    public double getLength() {
        return this.length;
    }
    // =========== Overrides ===========//

    // ***************************************************************
    //
    // Method: getArea
    //
    // Description: Calculates the area of the square.
    //
    // Parameters: None
    //
    // Returns: double - The area of the square.
    //
    // ***************************************************************

    @Override
    public double getArea() {
        return length * length;
    }

    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the square.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string representing the square's details.
    //
    // ***************************************************************
    @Override
    public String toString() {
        return String.format("%s%nShape: %s %nLength = %.2f %nArea = %.2f",
                super.toString(), getClass().getSimpleName(), getLength(), getArea());
    }
}
