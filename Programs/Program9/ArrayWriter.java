// Fig. 23.6: ArrayWriter.java
// Adds integers to an array shared with other Runnables
import java.lang.Runnable;
import java.security.SecureRandom;

public class ArrayWriter implements Runnable {
   private final SimpleArray sharedSimpleArray;

   private final SecureRandom secureRandom = new SecureRandom();

   public ArrayWriter(SimpleArray array) {
      sharedSimpleArray = array;
   }

   @Override
   public void run() {
      for (int i = 0; i < sharedSimpleArray.getSize(); i++) {
         int randomValue = 1 + secureRandom.nextInt(20); //generate random value (1-20)
         sharedSimpleArray.add(randomValue); // add random value to the shared array

      } 
   }
} 





