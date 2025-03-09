package Aufgabe4;

import java.util.LinkedList;

/**
 * Represents a lift, an interior space used for vertical movement between connected spaces.
 *
 * PRE: All provided spaces must be valid and not null.
 * POST: The lift is fully initialized, connected to the provided spaces,
 *       marked as accessible, and has an escape mechanism initialized.
 */
public class Lift extends Interior {

    /**
     * Constructs a Lift and connects it to the provided spaces.
     *
     * PRE: All spaces provided as arguments must be valid and not null.
     * POST: The lift is connected to the provided spaces,
     *       marked as accessible, and an escape mechanism is initialized.
     *
     * @param spaces The spaces to be linked to this lift.
     */
    public Lift(Space... spaces) {
        next = new LinkedList<>(); // Initialize the list of connected spaces.

        for (Space s : spaces) {
            // PRE: Each space in spaces must not be null.
            assert s != null : "Provided space cannot be null";

            s.next.add(s); // Add the current space to the next list of the provided space.
            next.add(s);   // Add the provided space to this lift's list.
        }

        accesible = true; // POST: This lift is marked as accessible.
        escape = new Escape(this); // POST: Escape mechanism is initialized for this lift.
    }
}
