package Aufgabe6;
/**
 * Represents a usable room with windows.
 */
public class WithWindows extends Usable {
    private double area;

    /**
     * Constructs a new room with windows.
     *
     * Design by Contract (DbC):
     * - Precondition: `name`, `length`, and `width` must be valid, non-null values.
     * - Precondition: `n` must be a `Number` to set `workstations` or `storage` based on `office` status.
     * - Precondition: `area` must be a positive double.
     * - Postcondition: Initializes room properties and assigns `area` to the instance.
     *
     * @param name   the name of the room
     * @param length the length of the room in meters
     * @param width  the width of the room in meters
     * @param office whether the room is designated as an office
     * @param n      the value to set `workstations` or `storage`
     * @param area   the total window area of the room
     */
    public WithWindows(String name, double length, double width, boolean office, Number n, double area) {
        super(name, length, width, office);
        if (super.isOffice()) {
            super.workstations = (int) n;
        }
        else {
            super.storage = (double) n;
        }
        this.area = area;
    }

    /**
     * Gets the total window area of the room.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the total window area as a positive double.
     *
     * @return the total window area of the room.
     */
    public double getArea() {
        return this.area;
    }

    /**
     * Return the properties of the room as text
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the room's properties as a string
     *
     * @return a string representation of the room's properties
     */
    public String toString() {
        if(super.isOffice()) {
            return super.toString() + ", office space with " + super.workstations + " workstations and " + area + " m^2 window area";
        }
        return super.toString() + ", storage space with " + super.storage + " m^2 storage area and " + area + " m^2 window area";
    }

}
