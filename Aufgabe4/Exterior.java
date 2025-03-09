package Aufgabe4;

import java.util.LinkedList;

/**
 * Represents an exterior space that connects to multiple other spaces.
 */
public class Exterior extends Space {

    /**
     * Constructs an Exterior instance and links it to the provided spaces.
     *
     * PRE: All provided spaces are valid and not null.
     * POST: The current space is marked as accessible, linked to all provided spaces,
     *       and has an escape mechanism initialized.
     *
     * @param spaces The spaces to be linked to this exterior.
     */
    public Exterior(Space... spaces) {
        next = new LinkedList<>(); // Initialize the list of connected spaces.

        for (Space s : spaces) {
            // PRE: Each space in spaces must not be null.
            assert s != null : "Provided space cannot be null";

            s.next.add(s); // Add the current space to the next list of the provided space.
            next.add(s);   // Add the provided space to this exterior's list.
        }

        accesible = true; // POST: This exterior is marked as accessible.
        escape = new Escape(this); // POST: Escape mechanism is initialized for this exterior.
    }
}
