package ua.hillel.java.enterprise.test;

// Task 2. Write a generic method that takes an array of objects and a collection,
// and puts all objects in the array into the collection.

import java.util.Collection;
import java.util.Collections;

/**
 * @Author Oleg Kosenkov
 * @Date   2019.04.09
 */
public class CopyArrayToCollection {

    // The task is slightly ambiguous concerning the type of array elements.
    // Let's consider two options:
    // 1) when the type of array is the same with the collection.
    // 2) when the array is of type Object

    /**
     * Takes the collection and the array of the same type,
     * and adds all the elements from the array to the collection.
     *
     * @param collection - The collection of type T,
     *                   to which the elements from the array should be added.
     * @param array - The array of type T, which elements should be added to the collection.
     * @param <T> - The type of the collection and array elements.
     * @return the collection with added elements.
     */
    public <T> Collection<T> copyCompatibleArrayToCollection(Collection<T> collection, T[] array) {
        Collections.addAll(collection, array);
        return collection;
    }

    /**
     * Takes the collection of type T and the array of type Object[],
     * and adds all the elements from the array to the collection.
     * <p>
     * <b>This method has an unchecked cast and does not guarantee type-safety.</b>
     * </p>
     * @param collection  The collection of type T,
     *                   to which the elements from the array should be added.
     * @param array  The array of objects, which elements should be added to the collection.
     * @param <T>  The type of the collection elements.
     * @return The collection with the added elements.
     */
    public <T> Collection<T> copyObjectArrayToCollection(Collection<T> collection, Object[] array) {
        for (Object element : array) {
            collection.add((T) element);
        }
        return collection;
    }
}
