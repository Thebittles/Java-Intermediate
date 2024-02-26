//********************************************************************
//  Developer:    Brittany Sifford
//
//  Program #:    Two
//
//  File Name:    Sphere.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  Sphere class represents a three-dimensional sphere shape, calculates its surface area and volume.
//
//********************************************************************

public class Sphere extends ThreeDimensionalShape {
    private double radius;

    // ***************************************************************
    //
    // Method: Sphere
    //
    // Description: Constructor to initialize a Sphere object with a given radius.
    //
    // Parameters: radius (double) - The radius of the sphere.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public Sphere(double radius) {
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
    // Description: Sets the radius of the sphere.
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
    // Description: Retrieves the radius of the sphere.
    //
    // Parameters: None
    //
    // Returns: double - The radius of the sphere.
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
    // Description: Calculates the surface area of the sphere.
    //
    // Parameters: None
    //
    // Returns: double - The surface area of the sphere.
    //
    // ***************************************************************

    @Override
    public double getArea() {
        return 4 * PI * Math.pow(radius, 2);
    }

    // ***************************************************************
    //
    // Method: getVolume
    //
    // Description: Calculates the volume of the sphere.
    //
    // Parameters: None
    //
    // Returns: double - The volume of the sphere.
    //
    // ***************************************************************

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * PI * Math.pow(radius, 3);
        
    }

    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the sphere.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string representing the sphere's details.
    //
    // ***************************************************************
    
    @Override
    public String toString() {
        return String.format("%s%nShape: %s %nRadius = %.2f %nArea = %.2f %nVolume = %.2f",
                super.toString(), getClass().getSimpleName(), getRadius(), getArea(), getVolume());
    }
}
