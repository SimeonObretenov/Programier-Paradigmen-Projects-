package Aufgabe2;

/**
 * Represents the type of a building, defining key properties such as lifespan,
 * renovation cycle, and material coefficients.
 */
public interface KindOfBuilding {

    /**
     * Retrieves the lifespan of the building.
     * PRE: None
     * POST: Result > 0
     * @return Lifespan of the building in years.
     */
    int getLifespan();

    /**
     * Retrieves the renovation cycle of the building.
     * PRE: None
     * POST: Result > 0
     * @return Number of years after which renovation is required.
     */
    int getRenovationCycle();

    /**
     * Retrieves the emission coefficient for the building type.
     * PRE: None
     * POST: Result > 0
     * @return Emission coefficient used in sustainability calculations.
     */
    double getEmissionCoeff();

    /**
     * Retrieves the shell material coefficient for the building type.
     * PRE: None
     * POST: Result > 0
     * @return Coefficient affecting the shell material properties.
     */
    double getShellMaterialCoeff();

    /**
     * Retrieves the finish material coefficient for the building type.
     * PRE: None
     * POST: Result > 0
     * @return Coefficient affecting the finish material properties.
     */
    double getFinishMaterialCoeff();

    /**
     * Retrieves the sustainability coefficient for the building type.
     * PRE: None
     * POST: Result > 0
     * @return Coefficient affecting sustainability calculations.
     */
    double getSustainabilityCoe();
}
