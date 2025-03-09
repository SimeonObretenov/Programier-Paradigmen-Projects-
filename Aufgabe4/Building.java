package Aufgabe4;
/**
 * Represents a building.
 * Implements the Entity interface and provides specific parameters for a building.
 */
public class Building implements Entity {
    private Space[] spaces;
    private boolean accessible;

    /**
     * Constructor to initialize a FinishMaterial with a given of building coefficient and size.
     * @param spaces list of spaces
     * PRE: spaces != null
     * POST: A new Building object is initialized with associated values.
     */
    public Building(Space[] spaces) {
        this.spaces = spaces.clone();
        this.accessible = true;
        for (Space s : this.spaces) {
            s.setPartOf(this);
        }
    }

    /**
     * Adds an entity to a building
     * PRE: e != null
     */
    @Override
    public void add(Entity e) {
        System.out.println("The building does not contain any entities. You cannot remove one.");
    }

    /**
     * Adds a space to a building
     * PRE: s != null
     */
    @Override
    public void add(Space s) {
        s.makeAccessible();
    }

    /**
     * Removes an entity from a building
     * PRE: e != null
     */
    @Override
    public void remove(Entity e) {
        System.out.println("The building does not contain any entities. You cannot remove one.");
    }

    /**
     * Removes a space from a building
     * PRE: s != null
     */
    @Override
    public void remove(Space s) {
        s.remove();
        if (!checkAccessibility()) {
            remove();
        }
    }

    /**
     * Makes the building and its spaces inaccessible
     */
    @Override
    public void remove() {
        this.accessible = false;
        for (Space s : spaces) {
            s.remove();
        }
    }

    /**
     * Makes the building accessible
     */
    @Override
    public void makeAccessible(){
        this.accessible = true;
        for (Space s : spaces) {
            s.makeAccessible();
        }
    }

    /**
     * Checks to see if all spaces that are part of this building are accessible
     * POST: Result == TRUE || Result == FALSE
     */
    @Override
    public boolean checkAccessibility() {
        for (Space s : spaces) {
            if (s.isAccesible()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the accessibility of the building
     * POST: Result == TRUE || Result == FALSE
     */
    @Override
    public boolean isAccessible() {
        return accessible;
    }

    /**
     * Returns a list of the spaces in this building
     * POST: Result != null
     */
    public Space[] spaces() {
        return spaces;
    }

}
