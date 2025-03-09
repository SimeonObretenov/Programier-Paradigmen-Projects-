package Aufgabe2;

import java.util.Random;

/**
 * Represents a random catastrophic event that can potentially damage buildings.
 */
public class Catastrophe {

    /**
     * Determines whether a catastrophe event exists.
     * PRE: None
     * POST: Result == true || Result == false
     * @return True if a catastrophe occurs, false otherwise.
     */
    public boolean isExisting() {
        Random random = new Random();
        if (random.nextInt(20) == 4) { // Catastrophe occurs with a 1/20 chance.
            return true;
        }
        return false;
    }

    /**
     * Simulates the destruction of a building in case of a catastrophe.
     * PRE: building != null
     * PRE: existing == true || existing == false
     * POST: If existing == true, building demolition is triggered with random damage magnitude.
     * @param building The building affected by the catastrophe.
     * @param existing Whether the catastrophe exists.
     */

    //ERROR: not using a private variable to check if a catastrophe exits and the methode should rely on
    //the client to input isExisting() in it
    public void demolish(Building building, boolean existing) {
        if (!existing) { // No catastrophe, no action required.
            return;
        }
        Random random = new Random();
        int magnitude = random.nextInt(100); // Random damage magnitude between 0% and 100%.
        building.demolish((double) magnitude / 100);
    }
}
