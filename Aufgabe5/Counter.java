package Aufgabe5;

/**
 * Represents a counter that increments specific variables upon approval operations.
 * Implements the Approvable interface with Counter</T> as P.
 */
public class Counter<T> implements Approvable<Counter<T>, T>  {
    private int counter;
    private Map<Counter<T>, T> approvals;

    public Counter () {
        counter = 0;
        approvals = new Map<>();
    }
    /**
     * Gets the approved value for the given counter, while incrementing counters.
     *
     * Design by Contract (DbC):
     * - Postcondition: Increments the counter variable of 'this' by 1000.
     * - Postcondition: Increments the counter variable of 'p' by 1.
     *
     * @param p the criterion for which the path is approved
     * @return the approved value of type T, or null if no value has been approved.
     */
    public T approved(Counter<T> p){
        this.counter += 1000;
        p.counter += 1;

        // Return the approved value if it exists, or null if not
        return approvals.get(p);
    }

    /**
     * Sets the approved value for the given counter.
     *
     * Design by Contract (DbC):
     * - Precondition: The parameter `p` must not be null.
     *
     * @param p the Counter object for which the value is approved
     * @param t the value to approve for the given counter
     */
    public void approve(Counter<T> p, T t){
        approvals.put(p, t);
    }

    /**
     * Return the content of the counter variable as text
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the counter's value as a string
     *
     * @return a string representation of the counter's value.
     */
    @Override
    public String toString(){
        return "The value of this counter is: " + counter;
    }
}
