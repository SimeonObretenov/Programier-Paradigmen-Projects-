package Aufgabe5;
/**
 * Represents an interior room.
 */
public class Interior<P> extends Space<P>{
    private String name;
    private double area;
    public Interior(String name, double area) {
        super(name);
        this.name = name;
        this.area = area;
    }

    /**
     * Gets the size of the interior room in square meters.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the area of the interior room as a positive double.
     *
     * @return the area of the room as a double, in square meters.
     */
    public double area(){
        return area;
    }

    /**
     * Returns a textual description of the area
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns a string describing the interior
     *
     * @return a string representation of the interior.
     */
    @Override
    public String toString(){
        return name;
    }
}
