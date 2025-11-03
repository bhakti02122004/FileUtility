/*
 * Internship Task 1 - File Handling Utility
 * Author: Bhakti Sharma
 * Date: 03-11-2025
 *
 * Description:
 * A simple Java utility to perform basic file operations:
 * - Read from file
 * - Write to file
 * - Modify (append) file
 */

import java.io.*;
import java.util.Scanner;

public class FileUtility {
    private static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== FILE HANDLING UTILITY ===");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1 -> writeToFile(sc);
                case 2 -> readFromFile();
                case 3 -> modifyFile(sc);
                case 4 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }

    // Method 1: Write content to file
    private static void writeToFile(Scanner sc) {
        System.out.print("Enter text to write into the file: ");
        String data = sc.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(data);
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }

    // Method 2: Read content from file
    private static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("--------------------");
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please write something first.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method 3: Modify file (append)
    private static void modifyFile(Scanner sc) {
        System.out.print("Enter text to append: ");
        String newText = sc.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.newLine();
            writer.write(newText);
            System.out.println("File modified successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }
}
