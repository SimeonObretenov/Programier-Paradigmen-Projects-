package Aufgabe5;

import java.util.Iterator;

/**
 * Represents a path (e.g., escape routes) as a list of elements of type X.
 * Implements Admin and Iterable interfaces.
 *
 * @param <X> the type of elements contained in the path
 */
public class Path<X> implements Admin<X, Path<X>>, Iterable<X> {

    private SinglyLinkedList<X> list;

    public Path() {
        list = new SinglyLinkedList();
    }

    /**
     * Adds the parameter as the first list entry if the parameter is not already present.
     *
     * Design by Contract (DbC):
     * - Precondition: `x` must not be null.
     * - Postcondition: If `x` is not already present, it is added as the first element in the list.
     * - Postcondition: If `x` is already present, the list remains unchanged.
     *
     * @param x the element to add
     * @return the updated Path object
     */
    public Path<X> add(X x) {
        list.addFirst(x);
        return this;
    }

    /**
     * Removes the parameter from the list if it is identical to an existing element.
     *
     * Design by Contract (DbC):
     * - Precondition: `x` must not be null.
     * - Postcondition: If `x` exists in the list, it is removed.
     * - Postcondition: If `x` does not exist, the list remains unchanged.
     *
     * @param x the element to remove
     * @return the updated Path object
     */
    public Path<X> remove(X x) {
        list.remove(list.indexOf(x));
        return this;
    }

    /**
     * Returns a string representation of the Path object.
     *
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: The returned string provides a meaningful representation of the path elements.
     *
     * @return a string representation of the Path
     */
    @Override
    public String toString() {
        return list.toString();
    }

    /**
     * Returns an iterator over the elements of type X in the Path.
     *
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: The iterator traverses the elements in the list from front to back.
     *
     * @return an iterator over elements of type X
     */
    @Override
    public Iterator<X> iterator() {
        return list.iterator();
    }
}
