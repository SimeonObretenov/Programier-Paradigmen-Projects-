package Aufgabe2;

/**
 * Represents an ecological type of building.
 * Implements the KindOfBuilding interface and provides specific parameters
 * for an ecological building type.
 */
// GOOD OOP: high class cohesion: it has a focused responsibility, clearly defined methods, and an intuitive design, making it
// maintainable, testable, and easy to extend.
public class EcologicalKindOfBuilding implements KindOfBuilding {

    private final int lifespan = 50;
    private final int renovationCycle = 20;
    private final double emissionCoeff = 1.0;
    private final double shellMaterialCoeff = 1.0;
    private final double finishMaterialCoeff = 1.25;
    private final double sustainabilityCoe = 1.25;

    /**
     * Retrieves the lifespan of the ecological building.
     * PRE: None
     * POST: Result == 50
     * @return Lifespan of the building in years.
     */
    public int getLifespan() {
        return lifespan;
    }

    /**
     * Retrieves the renovation cycle of the ecological building.
     * PRE: None
     * POST: Result == 20
     * @return Number of years after which renovation is required.
     */
    public int getRenovationCycle() {
        return renovationCycle;
    }

    /**
     * Retrieves the emission coefficient for the ecological building.
     * PRE: None
     * POST: Result == 1.0
     * @return Emission coefficient affecting sustainability calculations.
     */
    public double getEmissionCoeff() {
        return emissionCoeff;
    }

    /**
     * Retrieves the shell material coefficient for the ecological building.
     * PRE: None
     * POST: Result == 1.0
     * @return Coefficient affecting the shell material properties.
     */
    public double getShellMaterialCoeff() {
        return shellMaterialCoeff;
    }

    /**
     * Retrieves the finish material coefficient for the ecological building.
     * PRE: None
     * POST: Result == 1.25
     * @return Coefficient affecting the finish material properties.
     */
    public double getFinishMaterialCoeff() {
        return finishMaterialCoeff;
    }

    /**
     * Retrieves the sustainability coefficient for the ecological building.
     * PRE: None
     * POST: Result == 1.25
     * @return Coefficient affecting sustainability calculations.
     */
    public double getSustainabilityCoe() {
        return sustainabilityCoe;
    }
}
