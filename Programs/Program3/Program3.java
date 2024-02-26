// *************************************************************
//
// Developer: Brittany Sifford
//
// Program #: Three
//
// File Name: Program3.java
//
// Course: ITSE 2317 Java Programming (Intermediate)
//
// Due Date: 2/24/2024
//
// Instructor: Prof. Fred Kumi
//
// Chapter: 3
//
// Description: Determines & prints the number of duplicate words in a sentence along with their counts. 
// It utilizes a HashMap to store word counts, ignoring case sensitivity and punctuation. 
// The program prompts the user for input and continues to run until the user enters "No" to quit.
//
// ******************************************************************


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program3 {
    private Scanner scanner;

    public static void main(String[] args) {
        Program3 program = new Program3(); // Initialize program3
        program.developerInfo(); // Call developer method display output
        program.start();
    }

    public void start() {
        scanner = new Scanner(System.in); //create a new scanner input
        String userInput;
        do {
            System.out.println("Enter a sentence, or 'No' to quit: ");
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("No")) {
                Map<String, Integer> wordCountMap = createWordMap(userInput); // User helper method to create map
                displayDuplicateWords(wordCountMap); // Helper method to display
            }
        } while (!userInput.equalsIgnoreCase("No")); // While the user has NOT entered no/No/NO

        scanner.close();
    }

    private Map<String, Integer> createWordMap(String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = input.toLowerCase().split(" ");// Convert to lowercase and split

        for (String word : words) {
            if (!word.isEmpty()) {
                // Check if the word already exists in the map
                if (map.containsKey(word)) {
                    // If it exists, increment its count by 1
                    int count = map.get(word);
                    map.put(word, count + 1);
                } else {
                    // If it doesn't exist, add it to the map with a count of 1
                    map.put(word, 1);
                }
            }
        }

        return map;
    }

    private void displayDuplicateWords(Map<String, Integer> wordCountMap) {
        // create space between input and display
        System.out.println();
        // Display
        System.out.println("Duplicate words and their counts:");

        // Iterate through each entry
        for (Map.Entry<String, Integer> word : wordCountMap.entrySet()) {
            // Check to see if its a duplicate - where the value is greater than 1
            if (word.getValue() > 1) {
                System.out.println(word.getKey() + ": " + word.getValue()); // print the duplicate word
            }
        }
        // create space between display and input
        System.out.println();
    }

    public void developerInfo() {
        System.out.println("Name:   Brittany Sifford");
        System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Project: Three\n");
    }
}
