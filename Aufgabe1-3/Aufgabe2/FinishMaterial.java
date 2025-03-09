package Aufgabe2;
/**
 * Represents finish materials.
 * Implements the Material interface and provides specific parameters for the materials.
 */
// BAD OOP: The class has several constants like purchaseCost = 50, installationCost = 100, etc.,
// which are hardcoded and difficult to modify or extend
public class FinishMaterial implements Material{
    private double quality;
    private double purchaseCost = 50;
    private double installationCost = 100;
    private double maintenanceCost = 2.5;
    private double demolitionCost = 30;
    private double disposalCost = 20;
    private double emission = 250;
    private double recyclable = 0.6;

    /**
     * Constructor to initialize a FinishMaterial with a given of building coefficient and size.
     * @param buildingKindCoeff Material coefficient
     * @param buildingSize Size of the building: used for material quantity
     * PRE: buildingKindCoeff != null
     * PRE: buildingSize != null
     * POST: A new FinishMaterial object is initialized with associated values.
     */
    public FinishMaterial(double buildingKindCoeff, double buildingSize) {
        this.quality = buildingKindCoeff;
        recyclable *= buildingKindCoeff;

        purchaseCost *= buildingSize * buildingKindCoeff;
        installationCost *= buildingSize * buildingKindCoeff;
        maintenanceCost *= buildingSize * buildingKindCoeff;
        demolitionCost *= buildingSize * buildingKindCoeff;
        disposalCost *= buildingSize * buildingKindCoeff;
        emission *= buildingSize * buildingKindCoeff;
    }

    /**
     * Retrieves the initial costs for the shell materials for constructing a building: purchase + instalation.
     * PRE: None
     * POST: Result == purchaseCost + installationCost
     * @return Initial cost in euros.
     */
    @Override
    public double getInitialCosts() {
        return purchaseCost + installationCost;
    }

    /**
     * Retrieves the demolution costs for the shell materials for constructing a building.
     * @param catastrophy Whether there is a catastrophe occurring
     * PRE: catastrophy != null
     * POST: Result == disposalCost || Result == demolitionCost + disposalCost
     * @return Demolution cost in euros.
     */
    @Override
    public double getDemolutionCost(boolean catastrophy) {
        if (catastrophy) {
            return disposalCost;
        }
        return demolitionCost + disposalCost;
    }

    /**
     * Retrieves the sustainability of the shell materials.
     * PRE: None
     * POST: Result == quality * emission * recyclable
     * @return Sustainability.
     */
    @Override
    public double getSustainability() {
        return quality * emission * recyclable;
    }

    /**
     * Retrieves the maintenance costs of the shell materials for constructing a building.
     * PRE: None
     * POST: Result == maintenanceCost
     * @return Maintenance costs in euros.
     */
    @Override
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    /**
     * Retrieves the CO2 emissions of the shell materials.
     * PRE: None
     * POST: Result == emission
     * @return Emissions.
     */
    @Override
    public double getEmission() {
        return emission;
    }
}
