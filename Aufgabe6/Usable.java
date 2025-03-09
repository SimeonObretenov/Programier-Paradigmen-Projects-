package Aufgabe6;
/**
 * Represents an abstract usable room within an office unit.
 * Rooms must extend this abstract class to define specific room behaviors and characteristics.
 */
public abstract class Usable {
    private String name;
    private double length;
    private double width;
    private boolean office;
    protected int workstations = 0;
    protected double storage = 0;


    /**
     * Constructs a new instance of a usable room.
     *
     * Design by Contract (DbC):
     * - Precondition: `name` must be non-null, and `length` and `width` must be positive integers.
     * - Postcondition: Initializes a Usable instance with the provided parameters.
     *
     * @param name   the name of the room
     * @param length the length of the room in meters
     * @param width  the width of the room in meters
     * @param office indicates whether the room is an office
     */
    public Usable(String name, double length, double width, boolean office) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.office = office;
    }

    /**
     * Gets the name of the room.
     *
     * Design by Contract (DbC):
     * - Postcondition: returns the name of the room
     *
     * @return the name of the room as a string.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the length of the room.
     *
     * Design by Contract (DbC):
     * - Postcondition: returns the length of the room
     *
     * @return the length of the room in meters as an integer.
     */
    public double getLength() {
        return this.length;
    }

    /**
     * Gets the width of the room.
     *
     * Design by Contract (DbC):
     * - Postcondition: returns the width of the room
     *
     * @return the width of the room in meters as an integer.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets the number of workstations in the room.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the number of workstations, or 0 if the room is not an office.
     *
     * @return the number of workstations as an integer.
     */
    public int getWorkstations() {
        return this.workstations;
    }

    /**
     * Gets the storage space available in the room.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the storage space in cubic meters, or 0 if the room is an office.
     *
     * @return the amount of storage space as a double.
     */
    public double getStorage() {
        return this.storage;
    }

    /**
     * Checks if the room is an office or not.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the type of the room.
     *
     * @return whether the room is an office or not.
     */
    public boolean isOffice() {
        return office;
    }

    /**
     * Toggles the room designation and adjusts room properties accordingly.
     *
     * Design by Contract (DbC):
     * - Precondition: `n` must be a non-null Number; its type determines the field to adjust.
     * - Postcondition: If toggled to office, sets workstations based on `n` and clears storage.
     * - Postcondition: If toggled to storage, sets storage space based on `n` and clears workstations.
     *
     * @param n a Number that defines the new value for either workstations or storage.
     */
    public void change(Number n) {
        this.office = !this.office;
        if(this.office) {
            this.workstations = (int) n;
            this.storage = 0;
        }
        else {
            this.workstations = 0;
            this.storage = (double) n;
        }
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
       return name + ": length " + length + " m, width " + width + " m";
    }
}
