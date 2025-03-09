package Aufgabe6;

public class Company implements CustomIterable {

    private SinglyLinkedList buildings;

    /**
     * Constructs a new Company instance.
     *
     * Design by Contract (DbC):
     * - Precondition: None.
     * - Postcondition: A new empty Company instance is created with an empty list of buildings.
     */
    public Company() {
        buildings = new SinglyLinkedList();
    }

    /**
     * Adds a building to the company.
     *
     * Design by Contract (DbC):
     * - Precondition: The `building` parameter must not be null.
     * - Postcondition: The `building` is added to the end of the list.
     *
     * @param building The building to be added.
     */
    public void addBuilding(Building building) { buildings.addLast(building); }

    /**
     * Removes a building from the company.
     *
     * Design by Contract (DbC):
     * - Precondition: The `building` parameter must not be null and must exist in the list.
     * - Postcondition: The `building` is removed from the list if it exists.
     *
     * @param building The building to be removed.
     */
    public void removeBuilding(Building building) { buildings.remove(buildings.indexOf(building)); }

    /**
     * Returns a string representation of the company, showing all buildings.
     *
     * Design by Contract (DbC):
     * - Precondition: None.
     * - Postcondition: A string representation of all buildings in the company is returned.
     *
     * @return A string containing the details of all buildings in the company.
     */
    @Override
    public String toString() {
        return "                                                                                      Company\n"+ buildings.toString();

    }

    public CustomIterator iterator(){
        return buildings.iterator();
    }
}
