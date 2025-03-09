package Aufgabe4;
/**
 * Represents a complex.
 * Implements the Entity interface and provides specific parameters for a complex.
 */
public class Complex implements Entity {
    private Building[] buildings;
    private Space[] spaces;
    private boolean accessible;

    /**
     * Constructor to initialize a FinishMaterial with a given of building coefficient and size.
     * @param buildings list of buildings
     * @param spaces list of spaces
     * PRE: buildings != null
     * PRE: spaces != null
     * POST: A new Complex object is initialized with associated values.
     */
    public Complex(Building[] buildings, Space[] spaces) {
        this.buildings = buildings.clone();
        this.spaces = spaces.clone();
        this.accessible = true;
        for (Space s : this.spaces) {
            s.setPartOf(this);
        }
    }

    /**
     * Adds an entity to a complex
     * PRE: e != null
     */
    @Override
    public void add(Entity e) {
        e.makeAccessible();
    }

    /**
     * Adds a space to a complex
     * PRE: s != null
     */
    @Override
    public void add(Space s) {
        s.makeAccessible();
    }

    /**
     * Removes an entity from a complex
     * PRE: e != null
     */
    @Override
    public void remove(Entity e) {
        e.remove();
        if (!checkAccessibility()) {
            remove();
        }
    }

    /**
     * Removes a space from a complex
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
     * Makes the complex and its spaces inaccessible
     */
    @Override
    public void remove() {
        this.accessible = false;
        for (Building b : buildings) {
            b.remove();
        }
        for (Space s : spaces) {
            s.remove();
        }
    }

    /**
     * Makes the complex accessible
     */
    @Override
    public void makeAccessible(){
        accessible = true;
        for (Space s : spaces) {
            s.makeAccessible();
        }
        for (Building b : buildings) {
            b.makeAccessible();
        }
    }

    /**
     * Checks to see if all spaces and entities that are part of this complex are accessible
     * POST: Result == TRUE || Result == FALSE
     */
    @Override
    public boolean checkAccessibility() {
        for (Space s : spaces) {
            if (s.isAccesible()) {
                return true;
            }
        }
        for (Building b : buildings) {
            if (b.isAccessible()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the accessibility of the complex
     * POST: Result == TRUE || Result == FALSE
     */
    @Override
    public boolean isAccessible() {
        return accessible;
    }

    /**
     * Returns a list of the buildings in this complex
     * POST: Result != null
     */
    public Building[] buildings() {
        return buildings;
    }

    /**
     * Returns a list of the spaces in this complex
     * POST: Result != null
     */
    public Space[] spaces() {
        return spaces;
    }



}
