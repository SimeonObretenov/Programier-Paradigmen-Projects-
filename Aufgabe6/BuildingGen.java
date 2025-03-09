package Aufgabe6;

import java.util.Iterator;

public class BuildingGen<X extends Usable, Y extends Unusable> implements Iterable<OfficeGen<X,Y>> {
    private SinglyLinkedListGen<OfficeGen<X, Y>> offices; //offices!=null
    private String name;

    /**
     * Constructs a new Building instance.
     *
     * Design by Contract (DbC):
     * - Precondition: String is not empty.
     * - Postcondition: A new empty Building instance is created with an empty list of offices and a name.
     */
    public BuildingGen(String name) {
        offices = new SinglyLinkedListGen<>();
        this.name=name;
    }

    /**
     * Adds an office unit to the building.
     *
     * Design by Contract (DbC):
     * - Precondition: `office` must not be null, and `offices` must be initialized (not null).
     * - Postcondition: Adds the provided `office` to the list of office units within the building.
     *
     * @param office the office unit to be added to the building
     */
    public void addOfficeUnit(OfficeGen<X,Y> office){ offices.addLast(office); }

    /**
     * Removes an office unit from the building.
     *
     * Design by Contract (DbC):
     * - Precondition: `office` must not be null, and the `office` must exist in the list of office units.
     * - Postcondition: Removes the specified `office` from the list of office units if it exists.
     *
     * @param office the office unit to be removed from the building
     */
    public void removeOfficeUnit(OfficeGen<X,Y> office){ offices.remove(offices.indexOf(office)); }

    /**
     * Returns a string representation of the building, including all office units.
     *
     * Design by Contract (DbC):
     * - Precondition: None.
     * - Postcondition: Returns a string containing information about all office units in the building.
     *
     * @return A string representation of all office units within the building.
     */
    public String toString() {
        return name+":\n"+offices.toString();
    }

    public Iterator<OfficeGen<X,Y>> iterator(){
        return offices.iterator();
    }
}
