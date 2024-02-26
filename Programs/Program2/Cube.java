//********************************************************************
//  Developer:    Brittany Sifford
//
//  Program #:    Two
//
//  File Name:    Cube.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  Cube class represents a three-dimensional cube shape, calculates its area and volume.
//
//********************************************************************

public class Cube extends ThreeDimensionalShape {
    private double edge;

    // ***************************************************************
    //
    // Method: Cube
    //
    // Description: Constructor to initialize a Cube object with a given edge
    // length.
    //
    // Parameters: edge (double) - The edge length of the cube.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public Cube(double edge) {
        if (edge > 0) {
            this.edge = edge;
        } else {
            throw new IllegalArgumentException("Edge length must be positive");
        }
    }

    // =========== Setters ===========//

    // ***************************************************************
    //
    // Method: setEdge
    //
    // Description: Sets the edge length of the cube.
    //
    // Parameters: edge (double) - The new edge length value.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public void setEdge(double edge) {
        if (edge > 0) {
            this.edge = edge;
        } else {
            throw new IllegalArgumentException("Edge length must be positive");
        }
    }
    // =========== Getters ===========//

    // ***************************************************************
    //
    // Method: getEdge
    //
    // Description: Retrieves the edge length of the cube.
    //
    // Parameters: None
    //
    // Returns: double - The edge length of the cube.
    //
    // ***************************************************************

    public double getEdge() {
        return this.edge;
    }

    // =========== Overrides ===========//

    // ***************************************************************
    //
    // Method: getArea
    //
    // Description: Calculates the area of the cube.
    //
    // Parameters: None
    //
    // Returns: double - The area of the cube.
    //
    // ***************************************************************

    @Override
    public double getArea() {
        return 6 * Math.pow(edge, 2);
    }

    // ***************************************************************
    //
    // Method: getVolume
    //
    // Description: Calculates the volume of the cube.
    //
    // Parameters: None
    //
    // Returns: double - The volume of the cube.
    //
    // ***************************************************************

    @Override
    public double getVolume() {
        return Math.pow(edge, 3);
    }

    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the cube.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string representing the cube's details.
    //
    // ***************************************************************

    @Override
    public String toString() {
        return String.format("%s%nShape: %s %nEdge Length = %.2f %nArea = %.2f %nVolume = %.2f",
                super.toString(), getClass().getSimpleName(), getEdge(), getArea(), getVolume());
    }
}