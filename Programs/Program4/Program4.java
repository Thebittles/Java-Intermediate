// *************************************************************
//
// Developer: Brittany Sifford
//
// Program #: Four
//
// File Name: Program4.java
//
// Course: ITSE 2317 Java Programming (Intermediate)
//
// Due Date: 03/02/2024
//
// Instructor: Prof. Fred Kumi
//
// Chapter: Sixteen
//
// Description: 
//
//
// ******************************************************************

import java.util.HashMap; //hashmap 
import java.util.Scanner; //User Input
import java.io.File; //Working with files
import java.io.FileNotFoundException; //Handling errors

public class Program4 {

    private HashMap<Integer, String> yearTeamMap; // Key: Year Value: Name of Team
    private HashMap<String, Integer> teamWinMap; // Key: Name Of Team Value: # of wins

    // Constructor
    public Program4() {
        yearTeamMap = new HashMap<>();
        teamWinMap = new HashMap<>();

    }

    // Main
    public static void main(String[] args) {
        Program4 program = new Program4(); // Initialize Program4
        developerInfo();
        program.readData();
        if (!program.readData()) { // If read data returns false
            System.out.println("Error occurred while reading data. Exiting program.");
            return;
        }
        Scanner scanner = new Scanner(System.in); // New scanner for using input
        int requestedYear;

        do {
            System.out.print("Enter a year 1903-2023 or 0 to exit: "); // Promp user for year
            requestedYear = scanner.nextInt();
            if (requestedYear != 0 && requestedYear >= 1903 && requestedYear <= 2023) { // Checking if the year is
                                                                                        // within the valid range.
                program.displayData(requestedYear); // Display data with requested year
            } else if (requestedYear != 0) {
                System.out.println("Invalid year. Please enter a year between 1903 and 2023."); // Displaying error message for invalid year
            }
        } while (requestedYear != 0); // Looping until the user enters zero to exit.
        scanner.close();

    }


private boolean readData() {
    try {
        File file = new File("Program4.txt");
        Scanner scanner = new Scanner(file);
        int year = 1903;
        while (scanner.hasNextLine()) {
            String team = scanner.nextLine();
            if (year == 1904 || year == 1994) {
                year++;
            }
            if (!yearTeamMap.containsKey(year)) {
                yearTeamMap.put(year, team);
                teamWinMap.put(team, 0);
            } else {
                // If the year already exists in the map, update the team name if necessary
                if (!yearTeamMap.get(year).equals(team)) {
                    System.out.println("Error: Data inconsistency at year " + year);
                    return false;
                }
                // Increment the win count for the team only if it hasn't been counted for this year
                teamWinMap.put(team, teamWinMap.get(team) + 1);
            }
            year++;
        }
        scanner.close();
        return true;
    } catch (FileNotFoundException e) {
        System.out.println("Error: Data file not found.");
        return false;
    }
}

    public void displayData(int year) {
        String winningTeam = yearTeamMap.getOrDefault(year, "No Data For Year"); // Get team for given year or display no data for year 
        int wins = teamWinMap.getOrDefault(winningTeam, 0); // Get num of wins for team doesn't exist 0
        System.out.println("Year: " + year);
        System.out.println("Winning Team: " + winningTeam);
        System.out.println("Number of Wins: " + wins);
        System.out.println();// Creating space b/w runs
    }

    // Display Developer Info
    public static void developerInfo() {
        System.out.println("Name:   Brittany Sifford");
        System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Project: Four\n");
    }

}
