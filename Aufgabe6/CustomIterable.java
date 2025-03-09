package Aufgabe6;

public interface CustomIterable extends Iterable<Object>{

    /**
     * Returns an iterator over elements of type 'Object'.
     *
     * @return an iterator over elements of type 'Object'.
     */
    CustomIterator iterator();
}
