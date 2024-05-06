   // add a value to the shared array
   public synchronized void add(int value) {
    int position = writeIndex; // store the write index

    
    // put value in the appropriate element
    array[position] = value;             
   

    arrTotal += value; // increment the total of elements
    ++writeIndex; // increment index of element to be written next
    
 } 
