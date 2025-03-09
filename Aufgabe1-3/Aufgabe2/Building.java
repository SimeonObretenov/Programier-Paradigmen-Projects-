package Aufgabe2;

/**
 * Represents the blueprint for different types of buildings.
 * Defines common operations for managing lifecycle, maintenance,
 * and sustainability metrics.
 */
public interface Building {

    /**
     * Retrieves the renovation cycle of the building.
     * PRE: None
     * POST: Result > 0
     * @return Number of years after which full renovation is required.
     */
    int getRennovationCycle();

    /**
     * Checks whether the building is destroyed.
     * PRE: None
     * POST: Result == true || Result == false
     * @return True if the building is destroyed, false otherwise.
     */
    boolean isDestroyed();

    /**
     * Retrieves the current age of the building in years.
     * PRE: None
     * POST: Result >= 0
     * @return Age of the building in years.
     */
    int getAge();

    /**
     * Repairs the building by a specified percentage.
     * Optionally completes finishing renovation.
     * PRE: percentToRepair >= 0 && percentToRepair <= 100
     * POST: Building budget and material quantities are updated.
     * @param percentToRepair Percentage of damage to repair.
     * @param finishRen Whether to complete finishing renovation.
     */
    void repair(double percentToRepair, boolean finishRen);

    /**
     * Handles destruction or damage to the building.
     * If destruction exceeds a threshold, the building collapses.
     * Otherwise, damage is repaired.
     * PRE: destruction >= 0 && destruction <= 100
     * POST: If destruction > threshold, building is marked as destroyed.
     * @param destruction Percentage of destruction inflicted on the building.
     */

    //STYLE: parallel programming  - the whole methode in every class, which implements Building
    void demolish(double destruction);

    /**
     * Ages the building by one year.
     * If the building's lifespan is reached, it is destroyed.
     * Otherwise, maintenance and emissions increase, and satisfaction decreases.
     * PRE: None
     * POST: Building age is incremented. Emissions and budget are updated.
     */
    void age();

    /**
     * Calculates the average satisfaction index per person for a specific decade.
     * PRE: year > 0 && year <= building's lifespan
     * POST: Satisfaction index per decade is updated.
     * @param year Current year to calculate for.
     */
    void calculateAverageIndexForHappinessPerPersonPerDecade(int year);

    /**
     * Calculates the average budget spent per person per year for a specific decade.
     * PRE: year > 0 && year <= building's lifespan
     * PRE: residents > 0
     * POST: Budget per decade is updated.
     * @param year Current year to calculate for.
     * @param residents Number of people using the building.
     */
    void calculateBudgetPerPersonPerYearPerDecade(int year, int residents);

    /**
     * Calculates the average emissions per person per year.
     * PRE: residents > 0 && building age > 0
     * POST: Result > 0
     * @param residents Number of people using the building.
     * @return Emissions per person per year.
     */
    double getEmissionsPerPersonPerYear(int residents);

    /**
     * Calculates the sustainability score for the building.
     * PRE: None
     * POST: Result > 0
     * @return Sustainability index based on emissions and energy consumption.
     */

    //ERROR: in every simulation, the index of every minimal building is the same.
    //The same error is valid for every ecological and high-qualitative building.
    //For example a factory should not in any case have the same index as a
    //administrative building. This can be seen in the emission data.
    //The error is valid for every implementation of this method in the subtypes.
    double getSustainability();

    /**
     * Calculates the average budget spent per person per year.
     * PRE: residents > 0 && building age > 0
     * POST: Result > 0
     * @param residents Number of people using the building.
     * @return Budget spent per person per year.
     */
    double getBudgetPerPersonPerYear(int residents);

    /**
     * Retrieves the budget allocation per person per year for each decade.
     * PRE: None
     * POST: Result != null && Result.length > 0
     * @return Array of budget allocations per decade.
     */
    double[] getBudgetPerPersonPerYearPerDecade();

    /**
     * Retrieves the average satisfaction index per person per year.
     * PRE: building age > 0
     * POST: Result >= 0
     * @return Average satisfaction index per person per year.
     */
    double getAverageIndexForHappinessPerPerson();

    /**
     * Retrieves the average satisfaction index per person per year per decade.
     * PRE: None
     * POST: Result != null && Result.length > 0
     * @return Array of satisfaction indices per decade.
     */
    double[] getAverageIndexForHappinessPerPersonPerDecade();
}
