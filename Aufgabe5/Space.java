package Aufgabe5;
/**
 * Represents areas inside and outside buildings
 * Implements the Approvable interface with Path<Space<P>> as T.
 */
public class Space<P> implements Approvable<P, Path<Space<P>>>{
    private String name;
    private Map<P, Path<Space<P>>> approvals;
    public Space(String name) {
        this.name = name;
        this.approvals = new Map<>();
    }
    /**
     * Gets the approved path for the given criterion in this space.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns a Path<Space<P>> object if approved for p.
     * - Postcondition: Returns null if no value has been approved for p.
     *
     * @param p the criterion for which the path is approved
     * @return a Path<RCounter> object
     */
    public Path<Space<P>> approved(P p){
        return approvals.get(p);
    }

    /**
     * Sets the approved path for the given criterion in this space.
     *
     * Design by Contract (DbC):
     * - Precondition: `p` must not be null and must not equal zero.
     *
     * @param p the criterion for which the path is approved
     * @param t the path to approve for the given criterion
     */
    public void approve(P p, Path<Space<P>> t) {
        approvals.put(p, t);
    }

    /**
     * Returns a textual description of the area
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns a string describing the space
     *
     * @return a string representation of the space.
     */
    @Override
    public String toString() {
        return name;
    }
}
