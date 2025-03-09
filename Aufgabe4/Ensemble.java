package Aufgabe4;
/**
 * Represents an ensemble.
 * Implements the Entity interface and provides specific parameters for aa ensemble.
 */
public class Ensemble implements Entity {
    private Entity[] entities;
    private boolean accessible;

    /**
     * Constructor to initialize a FinishMaterial with a given of building coefficient and size.
     * @param entities list of entities
     * PRE: entities != null
     * POST: A new Ensemble object is initialized with associated values.
     */
    public Ensemble(Entity[] entities) {
        this.entities = entities.clone();
        accessible = true;
    }

    /**
     * Adds an entity to an ensemble
     * PRE: e != null
     */
    @Override
    public void add(Entity e) {
        e.makeAccessible();
    }

    /**
     * Adds a space to an ensemble
     * PRE: s != null
     */
    @Override
    public void add(Space s) {
        System.out.println("The ensemble does not contain any spaces. You cannot add one.");
    }

    /**
     * Removes an entity from an ensemble
     * PRE: e != null
     */
    @Override
    public void remove(Entity e) {
        e.remove();
    }

    /**
     * Removes a space from an ensemble
     * PRE: s != null
     */
    @Override
    public void remove(Space s) {
        System.out.println("The ensemble does not contain any spaces. You cannot remove one.");
    }

    /**
     * Makes the ensemble and its spaces inaccessible
     */
    @Override
    public void remove() {
        this.accessible = false;
        for (Entity e : entities) {
            e.remove();
        }
    }

    /**
     * Makes the ensemble accessible
     */
    @Override
    public void makeAccessible(){
        accessible = true;
        for (Entity e : entities) {
            e.makeAccessible();
        }
    }

    /**
     * Checks to see if all entities that are part of this ensemble are accessible
     * POST: Result == TRUE || Result == FALSE
     */
    @Override
    public boolean checkAccessibility() {
        for (Entity e : entities) {
            if (e.isAccessible()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the accessibility of the ensemble
     * POST: Result == TRUE || Result == FALSE
     */
    @Override
    public boolean isAccessible() {
        return accessible;
    }

    /**
     * Returns the area enclosed by the ensemble or null if it does not exist
     * This area exists if there are 3 or more entities in the ensemble
     * POST: Result != null || Result == null
     */
    public Space space() {
        return entities.length >= 3 ? new PublicRoad() : null;
    }
}
