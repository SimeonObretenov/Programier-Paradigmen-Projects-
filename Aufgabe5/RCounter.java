package Aufgabe5;

/**
 * Represents a counter that increments specific variables upon approval operations.
 * Implements the Approvable interface with RCounter as P and Path<RCounter> as T.
 */
public class RCounter implements Approvable<RCounter, Path<RCounter>> {
    private int counter;
    private Map<RCounter, Path<RCounter>> approvals;

    public RCounter() {
        counter = 0;
        approvals = new Map<>();
    }

    /**
     * Approves an operation based on the provided RCounter criterion and generates a Path<RCounter>.
     *
     * Design by Contract (DbC):
     * - Postcondition: The count variable associated with `this` is incremented by 1000.
     * - Postcondition: A new Path<RCounter> is generated or modified based on the approval logic.
     * - Postcondition: If `p` does not meet the approval conditions, the method may return null.
     *
     * @param p the RCounter object used as the criterion for approval
     * @return a Path<RCounter> object representing the result of the approval, or null if no approval is possible
     */
    public Path<RCounter> approved(RCounter p) {
        this.counter += 1000;
        p.counter += 1;

        // Return the approved path if it exists, or null if not
        return approvals.get(p);
    }


    /**
     * Approves the provided RCounter object using the given Path object, updating their states.
     *
     * Design by Contract (DbC):
     * - Precondition: Both `p` must not be null.
     * - Postcondition: The count variable of `p` is incremented by 1000.
     * - Postcondition: The count variable of the Path object `t` is incremented by 1.
     *
     * @param p the RCounter object to approve
     * @param t the Path<RCounter> object associated with the approval
     */
    public void approve(RCounter p, Path<RCounter> t) {
        approvals.put(p, t);
    }

    /**
     * Returns a string representation of the RCounter, including its count variables.
     *
     * Design by Contract (DbC):
     * - No specific preconditions.
     * - Postcondition: The returned string includes the current state of the count variables.
     *
     * @return a string representation of the RCounter
     */
    @Override
    public String toString() {
        return "The count is " + counter;
    }
}
