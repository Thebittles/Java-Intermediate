import java.util.concurrent.*;
import java.util.*;

public class ArraySumExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Example array to be summed
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Number of threads to use for concurrent processing
        int numThreads = 3;
        
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        
        // List to hold Future objects for later retrieval of results
        List<Future<Integer>> futures = new ArrayList<>();
        
        // Divide the array into sections for each thread to sum
        int chunkSize = (int) Math.ceil(array.length / (double) numThreads);
        
        // Submit tasks to the executor
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);
            
            // Submit a Callable task that sums a section of the array
            Future<Integer> future = executor.submit(() -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            });
            
            futures.add(future);
        }
        
        // Collect the results from the Future objects
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get(); // Wait for the result and add to the total sum
        }
        
        System.out.println("Total sum of array: " + totalSum); // Output the total sum
        
        // Shutdown the executor
        executor.shutdown();
    }
}
