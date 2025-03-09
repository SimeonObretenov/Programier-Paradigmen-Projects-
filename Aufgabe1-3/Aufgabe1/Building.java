package Aufgabe1;

// Interface describing the properties of a building
public interface Building {
    /**
     * In what year is the full renovation done
     */
    int getRennovationCycle();

    /**
     * Is the building destroyed
     */
    boolean isDestroyed();

    /**
     * What is the current age of the building
     */
    int getAge();

    /**
     * Breakdown of each decade for the average financial effort per resident per year
     */
    double[] getBudgetPerPersonPerYearPerDecade();

    /**
     * Average financial effort per person per year
     */
    double getBudgetPerPersonPerYear(int residents);

    /**
     * Calculate the average budget per resident per year:
     *  - the number speaks for every different decade
     *  - takes into account if the building is destroyed at the age % 10 = 0 or age % 10 != 0
     */
    void calculateBudgetPerPersonPerYearPerDecade(int year, int residents);

    /**
     * Index for the average satisfaction with living quality per decade
     */
    double[] getAverageIndexForHappinessPerPersonPerDecade();

    /**
     * Index for the average satisfaction with living quality per year
     */
    double getAverageIndexForHappinessPerPerson();

    /**
     * Calculate the average index for satisfactory per resident per year:
     *  - the number speaks for every different decade
     *  - takes into account if the building is destroyed at the age % 10 = 0 or age % 10 != 0
     */
    void calculateAverageIndexForHappinessPerPersonPerDecade(int year);

    /**
     * Average CO2 emissions per resident per year
     */
    double getEmissionsPerPersonPerYear(int residents);

    /**
     * Average non-recyclable waste
     */
    double getWastePerPersonPerYear(int residents);

    /**
     * Calculate the sustainability of the building:
     *  - takes into account emissions, waste, energy consumption, lifespan and renovation cycle
     */
    double getSustainabilityIndex();

    /**
     * What happens when the building needs repairing:
     *  - nothing if it is already destroyed
     *  - renovate a small part of the building
     *      -> that increases the costs and the quantity of the materials
     *      -> if a certain time is passed (20 years for the minimal and ecological kindOfBuildings and 25 years for the
     *         high quality kindOfBuildings) the full renovation is completed, which brings the satisfactory index almost
     *         to its original state
     *  - in case of damage it increases the costs and the quantity of the materials based on the damage percent
     */
    void repair(double percentToRepair, boolean finishRen);

    /**
     * What happens to the building in case of damage:
     *  - nothing if it is already destroyed
     *  - collapses if the destruction is more than a given percent (different for every type of building)
     *  - the damage is repaired if the destruction is less than a given percent (different for every type of building)
     */
    void demolish(double destruction);

    /**
     * Increase the age of the building:
     *  - if the lifespan is reached destroy it
     *  - if not decrease the satisfactory index, add maintenance and increase the CO2 emissions
     */
    void age();

}