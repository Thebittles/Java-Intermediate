//********************************************************************
//  Developer:    Brittany Sifford
//
//  Program #:    Two
//
//  File Name:    Triangle.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  Triangle class represents a two-dimensional triangle shape, calculates its area.
//
//********************************************************************

public class Triangle extends TwoDimensionalShape {
    private double base;
    private double height;

    // ***************************************************************
    //
    // Method: Triangle
    //
    // Description: Constructor to initialize a Triangle object with a given base
    // and height.
    //
    // Parameters: base (double) - The base length of the triangle.
    // height (double) - The height of the triangle.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public Triangle(double base, double height) {
        if (base > 0 && height > 0) {
            this.base = base;
            this.height = height;
        } else {
            throw new IllegalArgumentException("Base and height must be positive");
        }
    }

    // =========== Setters ===========//

    // ***************************************************************
    //
    // Method: setBase
    //
    // Description: Sets the base length of the triangle.
    //
    // Parameters: base (double) - The new base length value.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public void setBase(double base) {
        if (base > 0) {
            this.base = base;
        } else {
            throw new IllegalArgumentException("Base must be positive");
        }
    }

    // ***************************************************************
    //
    // Method: setHeight
    //
    // Description: Sets the height of the triangle.
    //
    // Parameters: height (double) - The new height value.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            throw new IllegalArgumentException("Height must be positive");
        }
    }

    // =========== Getters ===========//

    // ***************************************************************
    //
    // Method: getBase
    //
    // Description: Retrieves the base length of the triangle.
    //
    // Parameters: None
    //
    // Returns: double - The base length of the triangle.
    //
    // ***************************************************************

    public double getBase() {
        return this.base;
    }

    // ***************************************************************
    //
    // Method: getHeight
    //
    // Description: Retrieves the height of the triangle.
    //
    // Parameters: None
    //
    // Returns: double - The height of the triangle.
    //
    // ***************************************************************

    public double getHeight() {
        return this.height;
    }

      // =========== Overrides ===========//

    // ***************************************************************
    //
    // Method: getArea
    //
    // Description: Calculates the area of the triangle.
    //
    // Parameters: None
    //
    // Returns: double - The area of the triangle.
    //
    // ***************************************************************

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the triangle.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string representing the triangle's details.
    //
    // ***************************************************************
    
    @Override
    public String toString() {
        return String.format("%s%nShape: %s %nBase = %.2f %nHeight = %.2f %nArea = %.2f",
                super.toString(), getClass().getSimpleName(), getBase(), getHeight(), getArea());
    }
}
