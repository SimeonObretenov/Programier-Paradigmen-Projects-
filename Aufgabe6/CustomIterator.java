package Aufgabe6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface CustomIterator extends Iterator<Object> {

    /**
     * Returns the next element of the iteration. Throws a 'java.util.NoSuchElementException'
     * with the detail message "There are no elements to get." if the iteration has no more elements.
     *
     * @return the next element of the iteration.
     * @throws NoSuchElementException if the iteration has no more elements. The detail message
     * is "There are no elements to get.".
     */
    Object next();

    /**
     * Returns 'true' if the iteration has more elements, 'false' otherwise.
     *
     * @return 'true' if the iteration has more elements, 'false' otherwise.
     */
    boolean hasNext();

    /**
     * Removes from the underlying collection the last element returned by
     * this iterator. This method can be called only once per call to next.
     * @throws NoSuchElementException if removed is called for a second time in a row. The detail message
     * is "Cannot remove element before calling next().".
     * */
    void remove();
}
