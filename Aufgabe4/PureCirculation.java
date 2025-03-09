package Aufgabe4;

import java.util.LinkedList;

/**
 * Represents a pure circulation space, a type of circulation that facilitates movement between spaces.
 *
 * PRE: The provided spaces must be valid and not null.
 * POST: The pure circulation is initialized, marked as accessible,
 *       and connected to the provided spaces with an escape mechanism.
 */
public class PureCirculation extends Circulation {

    /**
     * Constructs a PureCirculation and connects it to the provided spaces.
     *
     * PRE: All spaces in the array must be valid and not null.
     * POST: The pure circulation is connected to the provided spaces,
     *       marked as accessible, and has an escape mechanism initialized.
     *
     * @param spaces The spaces to be connected to this pure circulation.
     */
    public PureCirculation(Space... spaces) {
        next = new LinkedList<>(); // Initialize the list of connected spaces.
        for (Space s : spaces) {
            // PRE: Each space in spaces must not be null.
            assert s != null : "Provided space cannot be null";
            s.next.add(s); // Add the current space to the next list of the provided space.
        }
        accesible = true; // POST: This pure circulation is marked as accessible.
        escape = new Escape(this); // POST: Escape mechanism is initialized for this pure circulation.
    }
}
