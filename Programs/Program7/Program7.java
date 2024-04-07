//********************************************************************
//
//  Developer:     Instructor
//
//  Program #:     Seven
//
//  File Name:     Program7.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      4/06/2024
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       20
//
//  Description:   Printing array elements using generic
//                 method printArray.
//
//********************************************************************



public class Program7
{
   //***************************************************************
   //
   //  Method:       main
   // 
   //  Description:  The main method of the program
   //
   //  Parameters:   String array
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   
   public static void main(String[] args)
   {	   
	  // Create an object of the main class and use it to call
	  // the non-static developerInfo method
	  Program7 obj = new Program7();

      // create arrays of Integer, Double and Character
      Integer[] integerArray = {1, 2, 3, 4, 5};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
      Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};

	  obj.developerInfo();
	  
      System.out.printf("Print Integer Array: ");
      obj.printArray(integerArray, 1, 3); // Print elements from index 1 to 3

      System.out.printf("Print Entire Integer Array: ");
      obj.printArray(integerArray, 0, 4); 

      System.out.printf("Print Double Array: ");
      obj.printArray(doubleArray, 2, 5); // Print elements from index 2 to 5
  
      System.out.printf("Print Entire Double Array: ");
      obj.printArray(doubleArray, 0, 6); 

      System.out.printf("Print Character Array: ");
      obj.printArray(characterArray, 0, 2); // Print elements from index 0 to 2

      System.out.printf("Print Entire Character Array: ");
      obj.printArray(characterArray, 0, 4); 

      //Intentionally getting errors to throw passing invalid subscripts
        try {
            System.out.printf("Print Double Array: ");
            obj.printArray(doubleArray, 6, 5); 
        } catch (InvalidSubscriptException e) {
              System.out.println("Caught InvalidSubscriptException: " + e.getMessage() + "\n");
          }

          try {
            System.out.printf("Print Character Array: ");
            obj.printArray(characterArray, 0, 10); 
        } catch (InvalidSubscriptException e) {
              System.out.println("Caught InvalidSubscriptException: " + e.getMessage() + "\n");
          }

          try {
            System.out.printf("Print Integer Array: ");
            obj.printArray(characterArray, 3, 7); 
        } catch (InvalidSubscriptException e) {
              System.out.println("Caught InvalidSubscriptException: " + e.getMessage() + "\n");
          }
   }

   //***************************************************************
   //
   //  Method:       printArray (Non Static)
   // 
   //  Description:  A generic method to print the elements of an array
   //
   //  Parameters:   Array
   //
   //  Returns:      (int) - number of elements printed
   //
   //**************************************************************


   
    public <T> int printArray(T[] inputArray, int lowSub, int highSub) {
        int numElementsPrinted = 0;

        // Validate subscripts
        if (lowSub < 0 || lowSub >= inputArray.length || highSub < 0 || highSub >= inputArray.length || lowSub > highSub) {
            throw new InvalidSubscriptException("Error: Invalid subscripts provided.");
        }

        // display elements within the specified range           
        for (int i = lowSub; i <= highSub; i++) {
            System.out.printf("%s ", inputArray[i]);
            numElementsPrinted++;
        }
        System.out.println();
        System.out.println("Number of elements printed: " + numElementsPrinted);
        System.out.println();
        return numElementsPrinted;
    }




   //***************************************************************
   //
   //  Method:       developerInfo (Non Static)
   // 
   //  Description:  The developer information method of the program
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public void developerInfo()
   {
      System.out.println("Name:    Brittany Sifford");
      System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
      System.out.println("Project: Seven\n");
   } // End of the developerInfo method
 
} 