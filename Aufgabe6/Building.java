package Aufgabe6;

public class Building implements CustomIterable {

    private SinglyLinkedList offices; //offices!=null
    private String name; //name is not empty

    /**
     * Constructs a new Building instance.
     *
     * Design by Contract (DbC):
     * - Precondition: String is not empty.
     * - Postcondition: A new empty Building instance is created with an empty list of offices and a name.
     */
    public Building(String name) {
        offices = new SinglyLinkedList();
        this.name=name;
    }

    /**
     * Adds an office unit to the building.
     *
     * Design by Contract (DbC):
     * - Precondition: The `office` parameter must not be null.
     * - Postcondition: The `office` is added to the end of the list.
     *
     * @param office The office unit to be added.
     */
    public void addOfficeUnit(Office office) {
        offices.addLast(office);
    }

    /**
     * Removes an office unit from the building.
     *
     * Design by Contract (DbC):
     * - Precondition: The `office` parameter must not be null and must exist in the list.
     * - Postcondition: The `office` is removed from the list if it exists.
     *
     * @param office The office unit to be removed.
     */
    public void removeOfficeUnit(Office office) {
        offices.remove(offices.indexOf(office));
    }

    /**
     * Returns a string representation of the building, showing all office units.
     *
     * Design by Contract (DbC):
     * - Precondition: None.
     * - Postcondition: A string representation of all office units in the building is returned.
     *
     * @return A string containing the details of all office units in the building.
     */
    @Override
    public String toString() {
        return name+":\n"+offices.toString();
    }
    /**
     * to comment
     * */
    public CustomIterator iterator(){
        return offices.iterator();
    }
}

