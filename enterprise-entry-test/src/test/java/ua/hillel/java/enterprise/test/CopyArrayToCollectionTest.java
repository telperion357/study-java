package ua.hillel.java.enterprise.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CopyArrayToCollectionTest {

    private List<Integer> tested;
    private List<Integer> expected;
    private CopyArrayToCollection  copy;

    @Before
    public void setup() {
        tested = new ArrayList<>(Arrays.asList(5, 10, 15, 20));
        expected = Arrays.asList(5, 10, 15, 20, 30 , 40 ,50);
        copy = new CopyArrayToCollection();
    }

    @Test
    public void copyCompatibleArrayToCollection() {
        tested = (List<Integer>) copy.copyCompatibleArrayToCollection(tested, new Integer[] {30, 40, 50});
        // Equals defined in the List interface.
        assertTrue(expected.equals(tested));
    }


    @Test
    public void copyObjectArrayToCollection() {
        CopyArrayToCollection copy = new CopyArrayToCollection();
        tested = (List<Integer>) copy.copyObjectArrayToCollection(tested, new Object[] {30, 40, 50});
        // Equals defined in the List interface.
        assertTrue(expected.equals(tested));
    }

    @Test
    public void copyObjectArrayToCollectionMisconduct() {
        // Nothing prevents at runtime to add strings to the list of Integers
        tested = (List<Integer>) copy.copyObjectArrayToCollection(tested, new String[] {"one", "two"});
        assertTrue(Arrays.asList(5, 10, 15, 20 ,"one", "two").equals(tested));
    }
}