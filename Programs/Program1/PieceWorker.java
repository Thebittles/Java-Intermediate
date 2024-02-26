//********************************************************************
//
//  Developer:    Textbook Authors
//
//  Program #:    One
//
//  File Name:    PieceWorker.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Instructor:   Prof. Fred Kumi 
//
//  Chapter:      10
//
//  Description:  PieceWorker class represents an employee paid based on pieces produced, 
//  validates wage and piece information and stores, overrides earnings method from superclass.
//
//
//********************************************************************

public class PieceWorker extends Employee {

    private double wage; // Wage per piece
    private int pieces; // numbers of pieces produced - cannot be partial thus int vs double

    // Constructor
    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
        // Super Constructor
        super(firstName, lastName, socialSecurityNumber);

        if (wage < 0.0) { //Validate Wage
            throw new IllegalArgumentException("Wage per piece must be >= 0.0");
        }
        this.wage = wage;
        
        if (pieces < 0) { //Validate Pieces
            throw new IllegalArgumentException("Number of pieces must be >= 0");
        }
        this.pieces = pieces;


    }

//=========== Getters ===========//

//***************************************************************
//
//  Method:  getWage 
// 
//  Description:  Gets the wage per piece for the employee.
//
//  Parameters:   None
//
//  Returns:      double - The wage per piece.
//
//***************************************************************
    public double getWage() {
        return wage;
    }

//***************************************************************
//
//  Method:  getPieces 
// 
//  Description:  Gets the number of pieces produced by the employee.
//
//  Parameters:   None
//
//  Returns:      int - The number of pieces.
//
//***************************************************************

    // Getter - Return Pieces
    public int getPieces() {
        return pieces;
    }

//=========== Setters ===========//

//***************************************************************
//
//  Method:  setWage 
// 
//  Description:  Sets the wage per piece for the employee.
//
//  Parameters: wage (double) - The new wage per piece.
//
//  Returns:      N/A
//
//***************************************************************

    //Setter
    public void setWage(double wage){
        if (wage < 0.0) { //Validate Wage
            throw new IllegalArgumentException("Wage per piece must be >= 0.0");
        }
        this.wage = wage;
    }

//***************************************************************
//
//  Method: setPieces
// 
//  Description:  Sets the number of pieces produced by the employee.
//
//  Parameters: pieces (int) - The new number of pieces.
//
//  Returns:      N/A
//
//***************************************************************
    //Setter
    public void setPieces(int pieces){
        if (pieces < 0) { //Validate Pieces
            throw new IllegalArgumentException("Number of pieces must be >= 0");
        }
        this.pieces = pieces;

    }

    //=========== Overrides ===========//

//***************************************************************
//
//  Method:  earnings
// 
//  Description:  Calculates the earnings of the PieceWorker based on the wage per piece and the number of pieces produced.
//                override abstract method earnings in Employee
//  Parameters:   None
//
//  Returns:      double - The earnings of the PieceWorker.
//
//***************************************************************

    @Override
    public double earnings() {
        return getWage() * getPieces();
    }

//***************************************************************
//
//  Method:  toString 
// 
//  Description:  Returns a string representation of the PieceWorker object.
//
//  Parameters:   None
//
//  Returns:      String - A formatted string with employee information, pay per piece, and number of pieces produced.
//
//***************************************************************
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f%n%s: %d",
                "Piece Worker employee", super.toString(),
                "Pay per piece", getWage(),
                "Number of pieces produced", getPieces());
    }

}
