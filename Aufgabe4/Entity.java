package Aufgabe4;

/**
 * Represents the blueprint for different types built units.
 * Defines common operations for adding, removing or changing built units
 */
public interface Entity {
    /**
     * Adds an entity to a built unit
     * PRE: e != null
     */
    void add(Entity e);

    /**
     * Adds a space to a built unit
     * PRE: s != null
     */
    void add(Space s);

    /**
     * Removes an entity from a built unit
     * PRE: e != null
     */
    void remove(Entity e);

    /**
     * Removes a space from a built unit
     * PRE: s != null
     */
    void remove(Space s);


    /**
     * Makes the entity and its built units inaccessible
     */
    void remove();

    /**
     * Makes the entity accessible
     */
    void makeAccessible();

    /**
     * Checks to see if all built units (and or spaces) that are part of this entity are accessible
     * POST: Result == TRUE || Result == FALSE
     */
    boolean checkAccessibility();

    /**
     * Returns the accessibility of the built unit
     * POST: Result == TRUE || Result == FALSE
     */
    boolean isAccessible();
}
