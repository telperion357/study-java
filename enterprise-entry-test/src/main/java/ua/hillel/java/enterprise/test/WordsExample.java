package ua.hillel.java.enterprise.test;

// Task 1.
// Write a program to find all distinct words from a text file.
// Ignore chars like ".,/-;:" and ignore case sensitivity.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author Oleg Kosenkov
 * @Date   2019.04.09
 */
public class WordsExample {

    /**
     * Finds in the given text file all distinct words,
     * separated by non-alphanumeric characters.
     *
     * @param filename - the name of the text file,
     *                 including relative or full path.
     *
     * @return the set of all distinct words (case-insensitive) from the given file.
     *
     */
    public Set<String> findDistinctWords(String filename){

        // Check arg not null.
        if (filename == null) {
            throw new IllegalArgumentException("File name can not be null");
        }

        // Check if the file exists.
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("Please check " +
                    "if the given file exists : " + filename);
        }

        // The set helps us to choose only unique words.
        // Using sorted set vs hash set makes the output more meaningful,
        // as it is sorted in alphabetic order.
        Set<String> wordSet = new TreeSet<>();

        // Read the file line by line.
        // Split each line into words by non-alphanumeric characters.
        // Turn all words to lowercase.
        // Collect all distinctive words into a set.
        //
        try (FileReader fReader = new FileReader(filename)) {
            BufferedReader reader = new BufferedReader(fReader);

            String line;
            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\W+");
                for (String word : words) {
                    wordSet.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + filename, e);
        }
        return wordSet;
    }

    /**
     * Takes the name of a text file as the command-line argument and prints to the system out
     * the set of all distinct words (case-insensitive) from the given file.
     *
     * Run example: java WordsExample src/main/resources/test.txt
     *
     * @param args - the args[0] is the name of the text file,
     *             including relative or full path.
     */
    public static void main(String[] args) {

        // Read the filename from command-line args
        if (args.length == 0 || args[0] == null) {
            System.out.println("Please provide the name of a text file " +
                    "in command-line arguments");
            return;
        }
        String filename = args[0];

        WordsExample example = new WordsExample();

       Set<String> wordSet = example.findDistinctWords(filename);
        // Print all distinctive words.
        for (String word : wordSet) {
            System.out.println(word);
        }
    }
}
