package Aufgabe6;
/**
 * Represents a usable room without windows.
 */
public class Windowless extends Usable{
    private int flux;

    /**
     * Constructs a new windowless room.
     *
     * Design by Contract (DbC):
     * - Precondition: `name`, `length`, and `width` must be valid, non-null values.
     * - Precondition: `n` must be a `Number` to set `workstations` or `storage` based on `office` status.
     * - Precondition: `flux` must be a non-negative integer.
     * - Postcondition: Initializes room properties and assigns `flux` to the instance.
     *
     * @param name   the name of the room
     * @param length the length of the room in meters
     * @param width  the width of the room in meters
     * @param office whether the room is designated as an office
     * @param n      the value to set `workstations` or `storage`
     * @param flux   the flux value for the room
     */
    public Windowless(String name, double length, double width, boolean office, Number n, int flux) {
        super(name, length, width, office);
        if (super.isOffice()) {
            super.workstations = (int) n;
        }
        else {
            super.storage = (double) n;
        }
        this.flux = flux;
    }

    /**
     * Gets the flux value of the room.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the flux as a non-negative integer.
     *
     * @return the flux value of the room.
     */
    public int getFlux() {
        return this.flux;
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
            return super.toString() + ", office space with " + super.workstations + " workstations and " + flux + " lm flux";
        }
        return super.toString() + ", storage space with " + super.storage + " m^2 storage area and " + flux + " lm flux";
    }

}
