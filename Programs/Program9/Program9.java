//********************************************************************
//
//  Developer:     
//
//  Program #:     Nine
//
//  File Name:     Program9.java
//
//  Course:        ITSE 2317 Intermediate Java Programming
//
//  Due Date:      4/24/2024
//
//  Instructor:    Fred Kumi 
//
//  Chapter:       23
//
//  Description:   
// 
//
//********************************************************************


// Fig. 23.7: SharedArrayTest.java
// Executing two Runnables to add elements to a shared SimpleArray.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public class Program9 {
   public static void main(String[] arg) {
      // construct the shared object
      SimpleArray sharedSimpleArray = new SimpleArray(15_000_000);

      // create two tasks to write to the shared SimpleArray
      ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
      ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);

      // execute the tasks with an ExecutorService
      ExecutorService executorService = Executors.newCachedThreadPool();
      executorService.execute(writer1);
      executorService.execute(writer2);

      executorService.shutdown();

      try {
         // wait 1 minute for both writers to finish executing
         boolean tasksEnded =                                     
            executorService.awaitTermination(1, TimeUnit.MINUTES);

         if (tasksEnded) {
            System.out.printf("%nContents of SimpleArray:%n");
            System.out.println(sharedSimpleArray); // print contents
         }   
         else {
            System.out.println(
               "Timed out while waiting for tasks to finish.");
         } 
      } 
      catch (InterruptedException ex) {
         ex.printStackTrace();
      }
   }
}

/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/