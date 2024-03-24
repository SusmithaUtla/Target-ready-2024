package Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TextFileAnalyzer {

    public static void main(String[] args) {
        String filename = "example.txt";

        analyzeText(filename);
    }


    public static void analyzeText(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String[] lines = reader.lines().toArray(String[]::new);


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

        } catch (IOException e) {

            System.out.println("Error reading the file: " + e.getMessage());
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
