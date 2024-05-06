
import java.util.Arrays;

public class SimpleArray {
   private final int[] array; // the shared integer array
   private int writeIndex = 0; // index of next element to be written
   private long arrTotal = 0;
   private long writeTime; 

   // construct a SimpleArray of a given size
   public SimpleArray(int size) {
      array = new int[size];
   } 


   // Add a value to the shared array
   public synchronized void add(int value) {
   if (writeIndex < array.length) {
         array[writeIndex] = value; // Write value to the shared array
         arrTotal += value; // Update the total sum
         writeIndex++; // Increment the write index
   }
}
   
    // get the total sum of the elements in the array
    public long getArrTotal() {
      return this.arrTotal;
  }

   //Set time to write to array  in milliseconds
   public void setWriteTime(long time){
      this.writeTime = time;
   }

   //Get write time in milliseconds
   public long getWriteTime(){
      return this.writeTime;
   }

   
   public int getSize() {
      return this.array.length;
   } 

   // used for outputting the contents of the shared integer array
   @Override
   public synchronized String toString() {
      return Arrays.toString(array);
   }


}

