package Aufgabe5;

import java.util.Iterator;

public interface ApprovableSet<X extends Approvable<P, T>, P, T> extends Iterable<X>{

    /**
     * Adds an entry of type X to the container, ensuring that the entry is present in the container
     * only if it has not already been added. If an identical entry is already present,
     * the method does nothing.
     *
     * Design by Contract (DbC):
     * - Preconditions: The argument `x` must not be `null`.
     * - Postcondition:
     *   * The container will contain the argument `x` as an entry if it was not already present.
     *   * If an identical object already exists in the container, no changes are made.
     *
     * @param x the entry to be added to the container
     */
    void add(X x);

    /**
     * Adds an entry of type P to the container, ensuring that the entry is present in the container
     * only if it has not already been added. If an identical entry is already present,
     * the method does nothing.
     *
     * Design by Contract (DbC):
     * - Preconditions: The argument `p` must not be `null`.
     * - Postcondition:
     *   * The container will contain the argument `p` as an entry if it was not already present.
     *   * If an identical object already exists in the container, no changes are made.
     *
     * @param p the criterion to be added to the container
     */
    void addCriterion(P p);

    /**
     * Returns an iterator that iterates over all entries in the container in an arbitrary order.
     * The entries included in the iteration are those that were added to the container using the `add` method.
     *
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition:
     *   * The returned iterator allows traversal over all entries of type `X` currently in the container.
     *   * Only entries added via the `add` method will be included in the iteration.
     *   * The order of iteration is not guaranteed.
     *
     * @return an iterator over all entries of type `X` in the container
     */
    Iterator<X> iteratorAll();

    /**
     * Returns an iterator that iterates over all entries `x` in the container in an arbitrary order.
     * The entries included are those that were added to the container using the `add` method
     * and for which `x.approved(p)` returns a non-null result.
     *
     * Design by Contract (DbC):
     * - Precondition: The argument `p` must not be `null`.
     * - Postcondition: The returned iterator includes only entries of type `X` where `x.approved(p)`
     *   produces a non-null result. The order of iteration is not guaranteed.
     *
     * @param p the criterion used to filter entries of type `X`
     * @return an iterator over the filtered entries of type `X`
     */
    Iterator<X> iterator(P p);

    /**
     * Returns an iterator that iterates over all entries `x` in the container in an arbitrary order.
     * The entries included are those that were added to the container using the `add` method
     * and for which `x.approved(p)` returns `null`.
     *
     * Design by Contract (DbC):
     * - Precondition: The argument `p` must not be `null`.
     * - Postcondition: The returned iterator includes only entries of type `X` where `x.approved(p)`
     *   produces a `null` result. The order of iteration is not guaranteed.
     *
     * @param p the criterion used to filter entries of type `X`
     * @return an iterator over the filtered entries of type `X`
     */
    Iterator<X> iteratorNot(P p);

    /**
     * Returns an iterator that iterates over all entries `x` in the container in an arbitrary order.
     * The entries included are those that were added to the container using the `add` method
     * and for which `x.approved(p)` produces a non-null result for every entry `p` added via `addCriterion`.
     *
     * Design by Contract (DbC):
     * - Precondition: No specific preconditions.
     * - Postcondition: The returned iterator includes only entries of type `X` where `x.approved(p)`
     *   produces a non-null result for every `p` of type `P` in the container. The order of iteration is not guaranteed.
     *
     * @return an iterator over the filtered entries of type `X`
     */
    Iterator<X> iterator();

    /**
     * Returns an iterator that iterates over all entries in the container in an arbitrary order.
     * The entries included are those that were added to the container using the `addCriterion` method.
     *
     * Design by Contract (DbC):
     * - Precondition: No specific preconditions.
     * - Postcondition: The returned iterator includes all entries of type `P` that were added using
     *   the `addCriterion` method. The order of iteration is not guaranteed.
     *
     * @return an iterator over all entries of type `P` in the container
     */
    Iterator<P> criterions();

    /**
     * Returns a textual representation of the contents of the ApprovableSet.
     * The string includes all entries of type `X` added using `add`,
     * and all entries of type `P` added using `addCriterion`.
     *
     * Design by Contract (DbC):
     * - Precondition: No specific preconditions.
     * - Postcondition: The returned string includes:
     *   * A representation of all elements of type `X` added via `add`.
     *   * A representation of all criteria of type `P` added via `addCriterion`.
     *   * The order of the elements may not be guaranteed but must be consistent.
     *   * The format should clearly separate and distinguish entries of types `X` and `P`.
     *
     * @return a string describing the contents of the ApprovableSet
     */
    String toString();

}
