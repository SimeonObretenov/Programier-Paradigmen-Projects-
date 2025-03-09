package Aufgabe4;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Represents a served space, a specific type of room with defined criteria
 * such as lighting, ventilation, heating, height, and space requirements.
 *
 * PRE: All criteria for a served space (e.g., lighting, ventilation, etc.) must meet the minimum standards.
 * POST: The served space is initialized with the provided attributes and connected to the given spaces.
 */
public class ServedSpace extends Room {

    // criteriums: sufficient natural and artificial lighting, ventilation, heating, minimum heights, and space

    int naturalLightning;  // in percentages
    int artificialLightning; // in lux, sufficient > 100 lux
    int ventilation; // in ACH
    int heating; // in Celsius
    int minimumHeight; // in centimetres
    double space; // in m^2
    double areaWindows; // in m^2

    /**
     * Constructs a ServedSpace with the specified criteria and connects it to the given spaces.
     *
     * PRE: All input criteria (e.g., lighting, ventilation, heating, height, space) must meet the specified thresholds:
     *      - Natural light >= 20%
     *      - Artificial light >= 300 lux
     *      - Ventilation >= 15 ACH
     *      - Heating >= 20°C
     *      - Minimum height >= 240 cm
     *      - Space >= 7 m²
     * POST: The served space is initialized with the provided criteria, marked as accessible,
     *       and connected to the provided spaces.
     *
     * @param naturalLightning Percentage of natural lighting.
     * @param artificialLightning Intensity of artificial lighting in lux.
     * @param ventilation Ventilation rate in ACH (air changes per hour).
     * @param heating Temperature in Celsius.
     * @param minimumHeight Minimum height of the space in cm.
     * @param space Area of the space in square meters.
     * @param areaWindows Area of windows in square meters.
     * @param spaces Array of spaces to be connected to this served space.
     * @throws IllegalArgumentException If any of the criteria do not meet the specified thresholds.
     */
    public ServedSpace(int naturalLightning, int artificialLightning, int ventilation, int heating, int minimumHeight, int space, double areaWindows, LinkedList<Space> spaces) {
        try {
            if (naturalLightning < 20) {
                throw new IllegalArgumentException("Insufficient, because the natural light is not enough!");
            }
            if (artificialLightning < 300) {
                throw new IllegalArgumentException("Insufficient, because the artificial light is not enough!");
            }
            if (ventilation < 15) {
                throw new IllegalArgumentException("Insufficient, because the ventilation is not good enough!");
            }
            if (heating < 20) {
                throw new IllegalArgumentException("Insufficient, because the heating is not good enough!");
            }
            if (minimumHeight < 240) {
                throw new IllegalArgumentException("Insufficient, because the minimum height is not reached!");
            }
            if (space < 7) {
                throw new IllegalArgumentException("Insufficient, because the space is not big enough!");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

        this.naturalLightning = naturalLightning;
        this.artificialLightning = artificialLightning;
        this.ventilation = ventilation;
        this.heating = heating;
        this.minimumHeight = minimumHeight;
        this.space = space;
        this.areaWindows = areaWindows;

        next = new LinkedList<>();
        for (Space s : spaces) {
            s.next.add(s);
            next.add(s);
        }
        accesible = true;
        escape = new Escape(this);
    }

    /**
     * Calculates the alternative escape method based on the area of windows.
     *
     * PRE: None.
     * POST: Returns the area of windows if it is sufficient (>= 1.1 m²),
     *       otherwise returns -1.
     *
     * @return The area of windows in m² if sufficient, or -1 if not sufficient.
     */
    public double alternativeEscape() {
        if (areaWindows >= 1.1) {
            return areaWindows;
        }
        return -1;
    }
}
