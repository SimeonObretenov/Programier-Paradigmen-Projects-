package Aufgabe6;

import java.util.Iterator;

public class CompanyGen<X extends Usable, Y extends Unusable> implements Iterable<BuildingGen<X,Y>> {
    private SinglyLinkedListGen<BuildingGen<X,Y>> buildings;

    /**
     * Constructs a new Company instance.
     *
     * Design by Contract (DbC):
     * - Precondition: None.
     * - Postcondition: A new empty CompanyGen instance is created with an empty list of buildings.
     */

    public CompanyGen(){
        buildings=new SinglyLinkedListGen<>();
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
    public void addBuilding(BuildingGen<X,Y> building) {
        buildings.addLast(building);
    }

    /**
     * Removes a building from the company.
     *
     * Design by Contract (DbC):
     * - Precondition: The `building` parameter must not be null and must exist in the list.
     * - Postcondition: The `building` is removed from the list if it exists.
     *
     * @param building The building to be removed.
     */
    public void removeBuilding(BuildingGen<X,Y> building) {
        buildings.remove(buildings.indexOf(building));
    }
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

    @Override
    public Iterator<BuildingGen<X,Y>> iterator(){
        return buildings.iterator();
    }
}
