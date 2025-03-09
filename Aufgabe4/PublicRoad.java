package Aufgabe4;

import java.util.LinkedList;

/**
 * Represents a public road, a special type of space that cannot be removed.
 *
 * PRE: The provided spaces must be valid and not null.
 * POST: The public road is initialized, marked as accessible,
 *       and connected to the provided spaces with an escape mechanism.
 */
public class PublicRoad extends Space {

    /**
     * Constructs a PublicRoad and connects it to the provided spaces.
     *
     * PRE: All spaces in the array must be valid and not null.
     * POST: The public road is connected to the provided spaces,
     *       marked as accessible, and has an escape mechanism initialized.
     *
     * @param spaces The spaces to be connected to this public road.
     */
    public PublicRoad(Space... spaces) {
        next = new LinkedList<>(); // Initialize the list of connected spaces.
        for (Space s : spaces) {
            // PRE: Each space in spaces must not be null.
            assert s != null : "Provided space cannot be null";
            s.next.add(s); // Add the current space to the next list of the provided space.
        }
        accesible = true; // POST: This public road is marked as accessible.
        escape = new Escape(this); // POST: Escape mechanism is initialized for this public road.
    }

    /**
     * Overrides the remove method to prevent removal of a public road.
     *
     * PRE: None.
     * POST: Always throws an IllegalStateException.
     *
     * @return This method does not return a value as it always throws an exception.
     * @throws IllegalStateException Always thrown to indicate that public roads cannot be removed.
     */
    @Override
    public Space remove() {
        throw new IllegalStateException("Cannot remove public road!");
    }
}
