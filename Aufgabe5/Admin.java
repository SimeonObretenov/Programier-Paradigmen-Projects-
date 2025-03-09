package Aufgabe5;

/**
 * Represents a generic interface that allows adding and removing elements
 * while adhering to certain constraints and guarantees.
 *
 * @param <X> the type of elements that can be added or removed
 * @param <T> the type of the resulting object after operations
 */
public interface Admin<X, T> {

    /**
     * Adds an element of type X and returns an updated object of type T.
     *
     * Design by Contract (DbC):
     * - Precondition: The parameter `x` must not be null.
     * - Postcondition: The returned object is an extension of `this` by `x`.
     * - Postcondition: If `this` cannot be extended by `x`, the result is identical to `this`.
     *
     * @param x the element to be added
     * @return an updated object of type T
     */
    T add(X x);

    /**
     * Removes an element of type X and returns an updated object of type T.
     *
     * Design by Contract (DbC):
     * - Precondition: The parameter `x` must not be null.
     * - Postcondition: The returned object corresponds to `this` with `x` removed.
     * - Postcondition: If `x` cannot be removed from `this`, the result is identical to `this`.
     *
     * @param x the element to be removed
     * @return an updated object of type T
     */
    T remove(X x);

    /**
     * Returns a string representation of the object.
     *
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: The returned string provides a meaningful representation of the object.
     *
     * @return a string representation of the object
     */
    @Override
    String toString();
}

