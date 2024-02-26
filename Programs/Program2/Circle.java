//********************************************************************
//  Developer:    Brittany Sifford
//
//  Program #:    Two
//
//  File Name:    Circle.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  Circle class represents a circle shape, validates radius information and calculates area.
//
//
//********************************************************************

public class Circle extends TwoDimensionalShape {
    private double radius;

    // ***************************************************************
    //
    // Method: Circle
    //
    // Description: Constructor to initialize a Circle object with a given radius.
    //
    // Parameters: radius (double) - The radius of the circle.
    //
    // Returns: N/A
    //
    // ***************************************************************
    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be positive");
        }
    }

    // =========== Setters ===========//

    // ***************************************************************
    //
    // Method: setRadius
    //
    // Description: Sets the radius of the circle.
    //
    // Parameters: radius (double) - The new radius value.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be positive");
        }
    }

    // =========== Getters ===========//

    // ***************************************************************
    //
    // Method: getRadius
    //
    // Description: the radius of the circle.
    //
    // Parameters: None
    //
    // Returns: double - The radius of the circle.
    //
    // ***************************************************************

    public double getRadius() {
        return this.radius;
    }

    // =========== Overrides ===========//

    // ***************************************************************
    //
    // Method: getArea
    //
    // Description: Calculates the area of the circle.
    //
    // Parameters: None
    //
    // Returns: double - The area of the circle.
    //
    // ***************************************************************

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the circle.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string representing the circle's details.
    //
    // ***************************************************************
    @Override
    public String toString() {
        return String.format("%s%nShape: %s %nRadius = %.2f %nArea = %.2f", super.toString(),
                getClass().getSimpleName(), getRadius(), getArea());

    }
}
