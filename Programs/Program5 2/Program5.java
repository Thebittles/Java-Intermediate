// *************************************************************
//
// Developer: Brittany Sifford
//
// Program #: Five
//
// File Name: Program4.java
//
// Course: ITSE 2317 Java Programming (Intermediate)
//
// Due Date: 3/22/2024
//
// Instructor: Prof. Fred Kumi
//
// Chapter: Seventeen
//
// Description:  program reads invoice data from a file, creates a list of invoices, and performs
// operations on the invoices such as sorting, mapping, filtering, and finding based on criteria.
//
//
// ******************************************************************


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program5 {

    public static void main(String[] args) {
        Program5 program = new Program5();
        developerInfo();
        List<Invoice> invoices = program.readData("Program5.txt");

        // Sort the Invoice objects by partDescription, then display the results.
        System.out.println("a. - Invoices sorted by part description:");
        program.sortByPartDescription(invoices);

        // b. Sort the Invoice objects by pricePerItem, then display the results.
        System.out.println("\nb. - Invoices Sorted by price:");
        program.sortByPricePerItem(invoices);

        // c. Map to partDescription and quantity, then sort by quantity
        System.out.println("\nc. - Invoices mapped to description and quantity:");
        program.mapPartDescAndQuantity(invoices);

        // d. Map each Invoice to its partDescription and the value of the Invoice
        System.out.println("\nd. - Invoices mapped to description and invoice amount: ");
        program.mapPartDescAndVal(invoices);

        // e. Select the Invoice values in the range $200.00 to $500.00.
        System.out.println("\ne. - Invoice mapped to description and invoice amount for invoices in the range 200-500:");
        program.invoiceValuesByRange(invoices);

        // f. Find any one Invoice in which the partDescription contains the word "Saw"
        System.out.println("\nf. - Find any one invoice which description contains Saw");
        program.findInvoiceByDescription(invoices);
    }


// ***************************************************************
//
// Method: readData
//
// Description: Reads invoice data from a file and creates a list of invoices.
//
// Parameters: filename (String) - The name of the file
//
// Returns: List<Invoice> - A list of Invoice objects read from file.
//
// ***************************************************************
    private List<Invoice> readData(String filename) {
        List<Invoice> invoices = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Array to hold each line and split on ,
                if (parts.length == 4) {
                    String partNumber = parts[0];
                    String partDescription = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    double pricePerItem = Double.parseDouble(parts[3]);
                    invoices.add(new Invoice(partNumber, partDescription, quantity, pricePerItem));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return invoices;
    }


// ***************************************************************
//
// Method: sortByPartDescription
//
// Description: Sorts a list by part description.
//
// Parameters: invoices (List<Invoice>) - The list of Invoice objects to be sorted.
//
// Returns: N/A
//
// ***************************************************************
    public void sortByPartDescription(List<Invoice> invoices) {
        invoices.stream()
                .sorted((inv1, inv2) -> inv1.getPartDescription().compareTo(inv2.getPartDescription()))
                .forEach(System.out::println);
    }


// ***************************************************************
//
// Method: sortByPricePerItem
//
// Description: Sorts a list of objects by pricePerItem.
//
// Parameters: invoices (List<Invoice>) - The list of Invoice objects to be sorted.
//
// Returns: N/A
//
// ***************************************************************
    public void sortByPricePerItem(List<Invoice> invoices) {
        invoices.stream()
                .sorted(Comparator.comparingDouble(Invoice::getPricePerItem))
                .forEach(System.out::println);
    }


// ***************************************************************
//
// Method: mapPartDescAndQuantity
//
// Description: Maps each Invoice to part description & invoice amount and sorts by invoice amount.
//
// Parameters: invoices (List<Invoice>) - The list of Invoice objects to be mapped and sorted.
//
// Returns: N/A
//
// ***************************************************************
    public void mapPartDescAndQuantity(List<Invoice> invoices) {
        invoices.stream()
                .map(inv -> String.format("Description: %-15s Quantity: %d", inv.getPartDescription(),
                        inv.getQuantity()))
                .sorted(Comparator.comparingInt(inv -> Integer.parseInt(inv.split("Quantity: ")[1])))
                .forEach(System.out::println);
    }


// ***************************************************************
//
// Method: mapPartDescAndVal
//
// Description: Maps each Invoice to its part description and invoice amount, then sorts by invoice amount.
//
// Parameters: invoices (List<Invoice>) - The list of Invoice objects to be mapped and sorted.
//
// Returns: N/A
//
// ***************************************************************
    public void mapPartDescAndVal(List<Invoice> invoices) {
        invoices.stream()
                .map(inv -> String.format("Description: %-15s Invoice amount: $%.2f", inv.getPartDescription(),
                        inv.getQuantity() * inv.getPricePerItem()))
                .sorted(Comparator.comparingDouble(inv -> Double.parseDouble(inv.split("Invoice amount: \\$")[1])))
                .forEach(System.out::println);
    }

// ***************************************************************
//
// Method: invoiceValuesByRange
//
// Description: Filters  objects in the range of $200.00 to $500.00 then maps them to description & invoice amount and sorts by invoice amount.
//
// Parameters: invoices (List<Invoice>) - The list of Invoice objects to be filtered and mapped/sorted.
//
// Returns: N/A
//
// ***************************************************************
    public void invoiceValuesByRange(List<Invoice> invoices) {
        System.out.println("\nInvoice values in the range $200.00 to $500.00:");
        invoices.stream()
                .filter(inv -> inv.getValue() >= 200.0 && inv.getValue() <= 500.0)
                .map(inv -> String.format("Description: %-15s Invoice amount: $%.2f", inv.getPartDescription(),
                        inv.getQuantity() * inv.getPricePerItem()))
                .sorted(Comparator.comparingDouble(inv -> Double.parseDouble(inv.split("Invoice amount: \\$")[1])))
                .forEach(System.out::println);
    }


// ***************************************************************
//
// Method: findInvoiceByDescription
//
// Description: Find the first invoice w/ part description containing the word "Saw" and prints.
//
// Parameters: invoices (List<Invoice>) - The list of Invoice objects to be searched.
//
// Returns: N/A
//
// ***************************************************************
    public void findInvoiceByDescription(List<Invoice> invoices) {
        invoices.stream()
        .filter(inv -> inv.getPartDescription().contains("Saw"))
        .findFirst()
        .ifPresent(inv -> {
            System.out.printf("Part #: %s Description: %-15s Quantity: %d Price: $%.2f%n",
                    inv.getPartNumber(), inv.getPartDescription(), inv.getQuantity(), inv.getPricePerItem());
        });
    }

    // Display Developer Info
    public static void developerInfo() {
        System.out.println("Name:   Brittany Sifford");
        System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
        System.out.println("Project: Five\n");
    }

}

