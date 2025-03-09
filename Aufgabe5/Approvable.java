package Aufgabe5;

/**
 * A generic interface that provides methods for approval mechanisms.
 *
 * @param <P> the type of the approval criterion
 * @param <T> the type of the result object upon approval
 */
public interface Approvable<P, T> {

    /**
     * Returns an object of type T that is approved based on the criterion of type P.
     *
     * Design by Contract (DbC):
     * - Precondition: `p` must not be null.
     * - Postcondition: If an object satisfying the criterion `p` exists, it is returned.
     * - Postcondition: If no such object exists, the method returns null.
     * - Result depends only on `this` and `p`.
     *
     * @param p the approval criterion
     * @return an approved object of type T, or null if no such object exists
     */
    T approved(P p);

    /**
     * Approves a specific object based on the criterion and updates the internal state.
     *
     * Design by Contract (DbC):
     * - Precondition: `p` must not be null and must not equal zero.
     * - Precondition: `t` can be null or a valid object of type T.
     * - Postcondition: Calls to `approved(p)` return the value `t` after this method is executed.
     * - Postcondition: Calls to `approved` with arguments other than `p` are unaffected by this operation.
     *
     * @param p the approval criterion
     * @param t the object to approve
     */
    void approve(P p, T t);

    /**
     * Returns a string representation of the Approvable object.
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
