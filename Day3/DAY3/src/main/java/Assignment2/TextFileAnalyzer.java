package Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TextFileAnalyzer {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the name of the file: ");
//        String fileName = sc.nextLine();
//        String[] lines=readLinesFromFile(fileName);

        String[] lines = {
                "This is a sample text file.",
                "It contains multiple lines with different lengths.",
                "Each line will be analyzed by your app."

        };
        analyzeText(lines);
    }

    private static String[] readLinesFromFile(String fileName) {
        try (FileReader reader = new FileReader(fileName+".txt");
             BufferedReader in = new BufferedReader(reader)) {
            return in.lines().toArray(String[]::new);
        } catch (FileNotFoundException e1) {
            System.err.println("File not found: " + e1.getMessage());
        } catch (IOException e2) {
            System.err.println("IOException: " + e2.getMessage());
        }
        return null;
    }

    public static void analyzeText(String[] lines) {
        String longestLine = findLongestLine(lines);
        String shortestLine = findShortestLine(lines);

        System.out.println("Longest line:");
        System.out.println(longestLine);
        System.out.println("Shortest line:");
        System.out.println(shortestLine);

        int[] wordCounts = countWords(lines);

        System.out.println("Word count for each line:");
        for (int i = 0; i < lines.length; i++) {
            System.out.println("Line " + (i + 1) + ": " + wordCounts[i] + " words");
        }

        sortWordCount(wordCounts);
        System.out.println("Sorted word count:");
        for (int count : wordCounts) {
            System.out.println(count + " words");
        }
    }




    public static String findLongestLine(String[] lines) {
        String longestLine = "";
        for (String line : lines) {
            if (line.length() > longestLine.length()) {
                longestLine = line;
            }
        }
        return longestLine;
    }


    public static String findShortestLine(String[] lines) {
        String shortestLine = lines[0];
        for (String line : lines) {
            if (line.length() < shortestLine.length()) {
                shortestLine = line;
            }
        }
        return shortestLine;
    }


    public static int[] countWords(String[] lines) {
        int[] wordCounts = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s+");
            wordCounts[i] = words.length;
        }
        return wordCounts;
    }


    public static void sortWordCount(int[] wordCounts) {
        Arrays.sort(wordCounts);
        for (int i = 0; i < wordCounts.length / 2; i++) {
            int temp = wordCounts[i];
            wordCounts[i] = wordCounts[wordCounts.length - 1 - i];
            wordCounts[wordCounts.length - 1 - i] = temp;
        }
    }
}
