//********************************************************************
//  Developer:    Brittany Sifford
//
//  Program #:    Two
//
//  File Name:    Tetrahedron.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  Tetrahedron class represents a three-dimensional tetrahedron shape, calculates its area and volume.
//
//********************************************************************

public class Tetrahedron extends ThreeDimensionalShape {
    private double edge;

    // ***************************************************************
    //
    // Method: Tetrahedron
    //
    // Description: Constructor to initialize a Tetrahedron object with a given edge
    // length.
    //
    // Parameters: edge (double) - The edge length of the tetrahedron.
    //
    // Returns: N/A
    //
    // ***************************************************************

    public Tetrahedron(double edge) {
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
    // Description: Sets the edge length of the tetrahedron.
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
    // Description: Retrieves the edge length of the tetrahedron.
    //
    // Parameters: None
    //
    // Returns: double - The edge length of the tetrahedron.
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
    // Description: Calculates the surface area of the tetrahedron.
    //
    // Parameters: None
    //
    // Returns: double - The surface area of the tetrahedron.
    //
    // ***************************************************************

    @Override
    public double getArea() {
        return Math.sqrt(3) * edge * edge;
    }
    // ***************************************************************
    //
    // Method: getVolume
    //
    // Description: Calculates the volume of the tetrahedron.
    //
    // Parameters: None
    //
    // Returns: double - The volume of the tetrahedron.
    //
    // ***************************************************************

    @Override
    public double getVolume() {
        return Math.pow(edge, 3) / (6 * Math.sqrt(2));
    }
    // ***************************************************************
    //
    // Method: toString
    //
    // Description: Overrides the toString method to return a string representation
    // of the tetrahedron.
    //
    // Parameters: None
    //
    // Returns: String - A formatted string representing the tetrahedron's details.
    //
    // ***************************************************************
    
    @Override
    public String toString() {
        return String.format("%s%nShape: %s %nEdge Length = %.2f %nArea = %.2f %nVolume = %.2f",
                super.toString(), getClass().getSimpleName(), getEdge(), getArea(), getVolume());
    }
}
