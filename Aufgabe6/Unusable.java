package Aufgabe6;
/**
 * Represents an unusable room that does not support any office-specific functions.
 */
public class Unusable {
    private double area;

    /**
     * Constructs a new unusable room.
     *
     * Design by Contract (DbC):
     * - Precondition: `area` must be a positive double.
     * - Postcondition: Initializes the `area` property of the unusable room.
     *
     * @param area the total area of the room in square meters
     */
    public Unusable(double area) {
        this.area = area;
    }

    /**
     * Gets the total area of the unusable rooms.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the total area as a positive double.
     *
     * @return the total area of the room.
     */
    public double getArea() {
        return area;
    }
}
