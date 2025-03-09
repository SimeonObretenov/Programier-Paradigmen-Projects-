package Aufgabe5;
/**
 * Represents an exterior area
 */
public class Exterior<P> extends Space<P> {
    private String name;
    private boolean isPublic;
    public Exterior(String name, boolean isPublic) {
        super(name);
        this.name = name;
        this.isPublic = isPublic;
    }
    /**
     * Checks whether the exterior area is publicly accessible.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns true if the exterior area is publicly accessible.
     * - Postcondition: Returns false if the exterior area is private.
     *
     * @return true if the area is public, false otherwise
     */
    public boolean isPublic(){
        return isPublic;
    }

    /**
     * Returns a textual description of the area
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns a string describing the exterior
     *
     * @return a string representation of the exterior.
     */
    @Override
    public String toString(){
        return name;
    }
}
