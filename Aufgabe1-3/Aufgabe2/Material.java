package Aufgabe2;
/**
 * Represents the type of material, defining key properties such as costs, sustainability and CO2 emissions
 */
public interface Material {
    /**
     * Retrieves the initial costs for the shell materials for constructing a building: purchase + instalation.
     * PRE: None
     * POST: Result > 0
     * @return Initial cost in euros.
     */
    double getInitialCosts();

    /**
     * Retrieves the demolution costs for the shell materials for constructing a building.
     * @param catastrophy Whether there is a catastrophe occurring
     * PRE: catastrophy != null
     * POST: Result > 0
     * @return Demolution cost in euros.
     */
    double getDemolutionCost(boolean catastrophy);

    /**
     * Retrieves the sustainability of the shell materials.
     * PRE: None
     * POST: Result > 0
     * @return Sustainability.
     */
    double getSustainability();

    /**
     * Retrieves the maintenance costs of the shell materials for constructing a building.
     * PRE: None
     * POST: Result > 0
     * @return Maintenance costs in euros.
     */
    double getMaintenanceCost();

    /**
     * Retrieves the CO2 emissions of the shell materials.
     * PRE: None
     * POST: Result > 0
     * @return Emissions.
     */
    double getEmission();
}
