package Aufgabe4;

import java.util.LinkedList;

/**
 * Represents a servant space, a specific type of room used for auxiliary or service purposes.
 *
 * PRE: All provided spaces must be valid and not null.
 * POST: The servant space is fully initialized, connected to the provided spaces,
 *       marked as accessible, and has an escape mechanism initialized.
 */
public class ServantSpace extends Room {

    /**
     * Constructs a ServantSpace and connects it to the provided spaces.
     *
     * PRE: All spaces provided as arguments must be valid and not null.
     * POST: The servant space is connected to the provided spaces,
     *       marked as accessible, and an escape mechanism is initialized.
     *
     * @param spaces The spaces to be linked to this servant space.
     */
    public ServantSpace(Space... spaces) {
        next = new LinkedList<>(); // Initialize the list of connected spaces.

        for (Space s : spaces) {
            // PRE: Each space in spaces must not be null.
            assert s != null : "Provided space cannot be null";

            s.next.add(s); // Add the current space to the next list of the provided space.
            next.add(s);   // Add the provided space to this servant space's list.
        }

        accesible = true; // POST: This servant space is marked as accessible.
        escape = new Escape(this); // POST: Escape mechanism is initialized for this servant space.
    }
}
