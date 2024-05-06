//********************************************************************
//
//  Developer:     Brittany Sifford 
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

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;

public class Program9 {
   //This line retrieves the number of processor cores available to the JVM and stores it in a static variable. 
   // useful for creating a multi-threaded executor with the same number of threads as processor cores to utilize parallel processing effectively.
   private static int cpuCores = Runtime.getRuntime().availableProcessors();
   private static final int ARRAY_SIZE = 15_000_000;

   public static void main(String[] arg) {
      Program9 program = new Program9();
      program.developerInfo(); // Call Dev info to display

      System.err.println();
      //Prints the number of available processor cores. The %d placeholder is replaced with the cpuCores value, and %n is used for a newline character.
      System.out.printf("Number of Cores:   %d%n", cpuCores);
      // Calls the singleThreadExecutor method to get an instance of SimpleArray that represents data manipulated by a single-threaded executor.
      SimpleArray singleThreadArr = program.singleThreadExecutor(); // Single thread
      //Calls the multiThreadExecutor method to get an instance of SimpleArray that uses a multi-threaded executor to manipulate data.
      SimpleArray multiThreadArr = program.multiThreadExecutor(); // Multi thread
   
      // Initializes an ExecutorService with a single thread to ensure sequential processing for some tasks, like handling output or comparisons.
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      //Shuts down the ExecutorService. Once shutdown, it won't accept new tasks but will complete any ongoing tasks.
      executorService.shutdown();

      try {
         // Waits for a maximum of one minute for all tasks in the executorService to complete. The result (tasksEnded) indicates whether all tasks completed within the given time.
         boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
         if (tasksEnded) {
            //Checks if the tasks finished within the specified time limit.
            System.err.println();// Creating space
            //Calls the compareTimes method to compare the execution times of single-threaded and multi-threaded operations. It passes the times from the SimpleArray instances obtained earlier.
            program.compareTimes(singleThreadArr.getWriteTime(), multiThreadArr.getWriteTime());
            System.err.println();// Creating space
            // Outputs the sum of elements in the multiThreadArr and Single Threaded with commas for thousands separation.
            System.out.printf("Multi-Threaded Sum:   %,d%n", multiThreadArr.getArrTotal());
            System.out.printf("Single-Threaded Sum:  %,d%n%n", singleThreadArr.getArrTotal());
         } else {
            System.out.println(
                  "Timed out while waiting for tasks to finish.");
         }
      } catch (InterruptedException ex) {
         ex.printStackTrace();
      }
   }

   /// construct shared obj
   public SimpleArray threadExecutor(ExecutorService executorService) {
      SimpleArray sharedSimpleArray = new SimpleArray(ARRAY_SIZE);
      executorService.execute(new ArrayWriter(sharedSimpleArray));

      return sharedSimpleArray;
   }

   // Single thread executer
   // the program creates a new ExecutorService with a single thread. Then, it calls threadExecutor(executorService) to create a SimpleArray and execute the ArrayWriter task with this single-threaded executor. After that, it shuts down the executor and waits for the task to complete.
   public SimpleArray singleThreadExecutor() {
      Instant start = Instant.now();
      ExecutorService executorService = Executors.newSingleThreadExecutor();// Init ExecutorService with single thread
      SimpleArray singleThreadArr = this.threadExecutor(executorService); // Pass to thread exector 
      executorService.shutdown();//shut down
      while (!executorService.isTerminated())
      ;// wait for executor to finish b/f ending timer
      Instant end = Instant.now();
      singleThreadArr.setWriteTime(Duration.between(start, end).toMillis()); // Calculate time b/w and set write time
      return singleThreadArr;

   }

   // Multi thread executer
   // Same idea as single but this time multithreaded
   // fixed-thread-pool ExecutorService with cpuCores threads is created. It similarly uses threadExecutor(executorService) to create a SimpleArray and submit the ArrayWriter task to this multi-threaded executor. Like the single-threaded case, it then shuts down the executor and waits for all tasks to complete.
   public SimpleArray multiThreadExecutor() {
      Instant start = Instant.now();
      ExecutorService executorService = Executors.newFixedThreadPool(cpuCores);// pass available cores
      SimpleArray multiThreadArr = this.threadExecutor(executorService);
      executorService.shutdown();
      while (!executorService.isTerminated())
         ;
      Instant end = Instant.now();
      multiThreadArr.setWriteTime(Duration.between(start, end).toMillis());// Calculate time b/w and set write time
      return multiThreadArr;
   }

   public void compareTimes(long singleTime, long multiTime) {
      if (singleTime > multiTime) {
         System.out.printf("%n%s%n%n", "Single-Thread took longer than Multi-Thread");
      } else if (multiTime > singleTime) {
         System.out.printf("%n%s%n%n", "Multi-Thread took longer than Single-Thread");
      } else {
         System.out.printf("%s%n", "Single & Multi took same amount of time.");
      }

      System.out.printf("Single-Threaded Time:  %,d milliseconds%n", singleTime);
      System.out.printf("Multi-Threaded Time:   %,d milliseconds%n", multiTime);
      System.out.println();
   }

   // Developer info method
   public void developerInfo() {
      System.out.println("Name: Brittany Sifford");
      System.out.println("Course: ITSE 2317 Intermediate Java Programming");
      System.out.println("Program: Nine");
   }
}