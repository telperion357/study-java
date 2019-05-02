package ua.hillel.java.enterprise.test;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WordsExampleTest {

    private final String TEST_FILE = "src/main/resources/test.txt";

    @Before
    public void setupTestFile() {
        // Create test file if not exist;
        File testFile = new File(TEST_FILE);
        File fileDir = testFile.getParentFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if (!testFile.exists()) {
            try {
                testFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Failed to create test file");
            }
        }

        // Write test content, rewriting the previous file content
        try(FileWriter fWriter = new FileWriter(testFile)) {
            BufferedWriter writer = new BufferedWriter(fWriter);
            writer.write("Puma, Lion; cat... ");
            writer.newLine();
            writer.write("CAT!!!,,, tiger::lynx++ LyNX panther--leopard" );
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write test file");
        }
    }

    @Test
    public void findDistinctWords() {
        Set<String> testSet = new HashSet<>(
                Arrays.asList("puma", "lion", "leopard",
                        "cat", "tiger", "panther", "lynx")
        );
        WordsExample example = new WordsExample();
        // Compare the test set and the set, returned by the tested method.
        // Equals defined in the java.util.Set interface
        assertTrue(testSet.equals(example.findDistinctWords(TEST_FILE)));
    }
}