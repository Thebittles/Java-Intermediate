//*************************************************************
//
//  Developer:     Brittany Sifford
//
//  Program #:     Three
//
//  File Name:     Program3.java
//
//  Course:        ITSE 2317 Java Programming (Intermediate)
//
//  Due Date:      2/14/2024
//
//  Instructor:    Prof. Fred Kumi 
//
//  Chapter:       3
//
//  Description:   This program displays the attributes of each
//                 shape type, including type, dimension type,
//                 area, and volume if applicable. 
//
//                 You are allowed to modify only line 84. If you
//                 modify any other part of the class, you will
//                 not receive credit for this project.
//
//******************************************************************

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Program3 {
    // ***************************************************************
    //
    // Method: main
    //
    // Description: The main method of the program
    //
    // Parameters: String array
    //
    // Returns: N/A
    //
    // **************************************************************
    public static void main(String[] args) {
        // Create an instance of the Program3 class
        Program3 program = new Program3();

        // Display developer information
        program.developerInfo();

        // Create a map to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Create map based on user input
        program.createWordCountMap(wordCountMap);

        // Display map content
        program.displayWordCountMap(wordCountMap);
    } // End of the main method

    // ***************************************************************
    //
    // Method: developerInfo (Non Static)
    //
    // Description: The developer information method of the program
    //
    // Parameters: None
    //
    // Returns: N/A
    //
    // **************************************************************
    public void developerInfo() {
        System.out.println("Name:   ");
        System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Project: Three\n");
    } // End of the developerInfo method




    
    // ***************************************************************
    //
    // Method: createWordCountMap
    //
    // Description: Creates a map based on user input
    //
    // Parameters: Map<String, Integer> map - The map to store word counts
    //
    // Returns: N/A
    //
    // **************************************************************
    private void createWordCountMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = scanner.nextLine();
        String strippedString = input.replaceAll("\\s+", "");

        String[] tokens = strippedString.split("");

        for (String token : tokens) {
            String letter = token.toLowerCase();

            if (map.containsKey(letter)) {
                int count = map.get(letter);
                map.put(letter, count + 1);
            } else
                map.put(letter, 1);
        }
        scanner.close();
    }

    // ***************************************************************
    //
    // Method: displayWordCountMap
    //
    // Description: Displays the content of the word count map
    //
    // Parameters: Map<String, Integer> map - The map to display
    //
    // Returns: N/A
    //
    // **************************************************************
    private void displayWordCountMap(Map<String, Integer> map) {
        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        for (String key : map.keySet())
            System.out.printf("%-10s%10s%n", key, map.get(key));
        System.out.printf("%nsize: %d%nisEmpty; %b%n", map.size(), map.isEmpty());
    }
} // End of test class Program3