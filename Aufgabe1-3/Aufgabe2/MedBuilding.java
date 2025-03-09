package Aufgabe2;


import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;


/**
 * Represents a medical building such as a hospital or health center.
 * Implements the Building interface, providing methods for managing building lifecycle,
 * budget, sustainability, and other metrics.
 */
// GOOD OOP: The use of dynamic binding (via the KindOfBuilding interface) allows you to seamlessly switch between different
// kind of buildings
public class MedBuilding implements Building {
    // Random generator for generating material properties and energy consumption.
    Random random = new Random();

    // Type of building influencing budget, emissions, and sustainability.
    private KindOfBuilding kind;

    // Materials used for shell and finishing, affecting cost and emissions.
    private Material shellMaterial;
    private Material finishMaterial;

    // Annual energy consumption in kWh, randomly assigned within a range.
    private double energyConsumption = random.nextInt(700_000, 1_350_000);

    // Total emissions of the building, calculated from materials and type.
    private double emissions;
    // Indicates whether the building is destroyed.
    private boolean isDestroyed;

    // Age of the building in years.
    private int age;

    // Total budget allocated to the building, including materials.
    private double budget;

    // Budget per decade, calculated for each 10-year interval.
    private double[] budgetPerDecade;

    // Satisfaction index measuring the perceived quality of the building.
    private double initialSatisfactoryIndex;
    private double currentSatisfactoryIndex;

    // Total satisfaction accumulated over years.
    private double yearlySatisfactoryIndex;

    // Satisfaction index per decade.
    private double[] satisfactoryIndexPerDecade;

    /**
     * Constructor to initialize an MedBuilding with a given kind of building.
     * @param kind The type of the building influencing budget and emissions.
     * PRE: kind != null
     * POST: A new MedBuilding object is initialized with associated materials and metrics.
     */
    public MedBuilding(KindOfBuilding kind) {
        this.kind = kind;
        shellMaterial = new ShellMaterial(kind.getShellMaterialCoeff(), random.nextInt(3500, 7000));
        finishMaterial = new FinishMaterial(kind.getFinishMaterialCoeff(), random.nextInt(420, 850));

        emissions = (energyConsumption + shellMaterial.getEmission() + finishMaterial.getEmission()) * kind.getEmissionCoeff();

        isDestroyed = false;
        age = 0;

        budget = shellMaterial.getInitialCosts() + finishMaterial.getInitialCosts();
        budgetPerDecade = new double[kind.getLifespan() / 10];

        initialSatisfactoryIndex = 100;
        currentSatisfactoryIndex = initialSatisfactoryIndex;
        yearlySatisfactoryIndex = 0;
        satisfactoryIndexPerDecade = new double[kind.getLifespan() / 10];
    }

    /**
     * Returns the budget per person per year for each decade.
     * POST: Result != null && Result.length == kind.getLifespan() / 10
     * @return Array of budget allocations.
     */
    public double[] getBudgetPerPersonPerYearPerDecade() {
        return budgetPerDecade;
    }

    private static double calculateBudgetForDecade(int year, int residents, double budget, double[]budgetPerDecade) {
        //STYLE: functional programming  - the whole methode
        int currentDecade = year / 10 - 1;

        double remainingBudget = budget -
                IntStream.range(0, currentDecade)
                        .mapToDouble(i -> budgetPerDecade[i] * 10 * residents)
                        .sum();

        return remainingBudget / (residents * 10);
    }

    /**
     * Calculates the budget per person per year for a specific decade, based on whether the building is destroyed.
     * @param year Current year to calculate for.
     * @param residents Number of population.
     * PRE: year > 0 && year <= kind.getLifespan()
     * PRE: residents > 0
     * POST: budgetPerDecade is updated for the given decade.
     */
    @Override
    public void calculateBudgetPerPersonPerYearPerDecade(int year, int residents) {
        if(!isDestroyed){
            budgetPerDecade[year/10-1] = calculateBudgetForDecade(year,residents,budget,budgetPerDecade);
        }else{
            int i = 0;
            double money = this.budget;
            while (i < kind.getLifespan() / 10 && budgetPerDecade[i] != 0.0) {
                money -= budgetPerDecade[i] * 10 * residents;
                i++;
            }
            if (money > 0 && i != kind.getLifespan() / 10) {
                budgetPerDecade[i] = money / residents / 10;
            }
        }

    }

    /**
     * Returns the average budget per person per year.
     * @param rooms Number of rooms.
     * PRE: residents > 0 && age > 0
     * POST: Result >= 0
     * @return Budget per person per year.
     */
    public double getBudgetPerPersonPerYear(int rooms) {
        return budget / rooms / age;
    }

    /**
     * Returns the average satisfaction index per person for each decade.
     * POST: Result != null && Result.length == kind.getLifespan() / 10
     * @return Array of satisfaction indices per decade.
     */
    public double[] getAverageIndexForHappinessPerPersonPerDecade() {
        return satisfactoryIndexPerDecade;
    }

    /**
     * Returns the average satisfaction index for the building.
     * PRE: age > 0
     * POST: Result >= 0
     * @return Average satisfaction index.
     */
    public double getAverageIndexForHappinessPerPerson() {
        return yearlySatisfactoryIndex / age;
    }


    private static double calculateIndexForDecade(int year, double yearlySatisfactoryIndex, double[]satisfactoryIndexPerDecade) {
        //STYLE: functional programming  - the whole methode
        int currentDecade = year / 10 - 1;

        double remainingBudget = yearlySatisfactoryIndex -
                IntStream.range(0, currentDecade)
                        .mapToDouble(i -> satisfactoryIndexPerDecade[i] * 10)
                        .sum();

        return remainingBudget / 10;
    }

    @Override
    public void calculateAverageIndexForHappinessPerPersonPerDecade(int year) {
        if(!isDestroyed){
            satisfactoryIndexPerDecade[year/10-1] = calculateIndexForDecade(year,yearlySatisfactoryIndex,satisfactoryIndexPerDecade);
        }else{
            int i = 0;
            double index = this.yearlySatisfactoryIndex;
            while (i < kind.getLifespan() / 10 && satisfactoryIndexPerDecade[i] != 0.0) {
                index -= satisfactoryIndexPerDecade[i] * 10;
                i++;
            }
            if (index > 0 && i < kind.getLifespan() / 10) {
                satisfactoryIndexPerDecade[i] = index / 10;
            }
        }

    }

    /**
     * Returns the building's sustainability index.
     * The calculation differs based on the building kind.
     * POST: Result > 0
     * @return Sustainability index of the building.
     */
    public double getSustainability() {
        if(kind.getClass()==MinimalKindOfBuilding.class){
            return (1 / emissions) +
                    (1 / energyConsumption) +
                    (((double) kind.getLifespan() / kind.getRenovationCycle()))+(1/ (finishMaterial.getSustainability()+shellMaterial.getSustainability()));
        }else if(kind.getClass()==EcologicalKindOfBuilding.class){
            return  3.6 * (1 / emissions) +
                    1.4 * (1 / energyConsumption) +
                    2.5 * (((double) kind.getLifespan() / kind.getRenovationCycle()))+(1/ (finishMaterial.getSustainability()+shellMaterial.getSustainability()));
        }
        return  1.2 * (1 / emissions) +
                1.4 * (1 / energyConsumption) +
                1.1 * (((double) kind.getLifespan()/ kind.getRenovationCycle()))+(1/ (finishMaterial.getSustainability()+shellMaterial.getSustainability()));

    }

    /**
     * Calculates emissions per person per year based on total emissions,
     * number of residents, and building age.
     * @param rooms Number of rooms.
     * PRE: residents > 0 && age > 0
     * POST: Result > 0
     * @return Emissions per person per year.
     */
    public  double getEmissionsPerPersonPerYear(int rooms) {
        return emissions / rooms / age;
    }

    /**
     * Retrieves the renovation cycle based on the building type.
     * POST: Result > 0
     * @return Renovation cycle in years.
     */
    @Override
    public int getRennovationCycle() {
        return kind.getRenovationCycle();
    }

    /**
     * Checks if the building is destroyed.
     * POST: Result == true || Result == false
     * @return True if destroyed, false otherwise.
     */
    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    /**
     * Retrieves the current age of the building.
     * POST: Result >= 0
     * @return Building age in years.
     */
    @Override
    public int getAge(){
        return age;
    }

    /**
     * Repairs the building by a certain percentage.
     * Updates the satisfaction index if finishing renovation is performed.
     * @param percentToRepair Percentage of destruction.
     * @param finishRen Whether finishing renovation is performed.
     * PRE: percentToRepair >= 0 && percentToRepair <= 100
     * POST: budget is increased by repair costs.
     * POST: If finishRen == true, satisfaction index is updated.
     */
    @Override
    public void repair(double percentToRepair, boolean finishRen) {
        if (isDestroyed) {
            return;
        }

        if (percentToRepair == 1) { // Full repair
            if (kind.getClass() == MinimalKindOfBuilding.class) {
                budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * 0.000000016;
                budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * 0.000000016;
            } else if (kind.getClass() == EcologicalKindOfBuilding.class) {
                budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * 0.000000026;
                budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * 0.00000001;
            } else {
                budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * 0.009;
                budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * 0.009;
            }

            if (finishRen) { // Update satisfaction index after renovation.
                yearlySatisfactoryIndex += initialSatisfactoryIndex * 0.98;
                initialSatisfactoryIndex *= (kind.getClass() == HighQualityKindOfBuilding.class) ? 0.97 : 0.99;
                currentSatisfactoryIndex = initialSatisfactoryIndex;
            }
            return;
        }

        // Partial repair
        budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * (percentToRepair / 100 + 1);
        budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * (percentToRepair / 100 + 1);
    }

    /**
     * Demolishes the building if damage exceeds a certain threshold based on the building type.
     * Repairs the damage if the threshold is not reached.
     * Adds demolition costs and recalculates emissions.
     * @param destruction Percentage of destruction inflicted on the building.
     * PRE: destruction >= 0 && destruction <= 100
     * POST: If destruction > threshold, isDestroyed == true.
     * POST: budget is adjusted by demolition cost.
     */
    public void demolish(double destruction) {
        CompletableFuture.runAsync(() -> {
            if (isDestroyed) {
                return;  // Early exit if already destroyed
            }

            double perc;
            if (kind.getClass() == MinimalKindOfBuilding.class) {
                perc = 0.8;
            } else if (kind.getClass() == EcologicalKindOfBuilding.class) {
                perc = 0.85;
            } else {
                perc = 0.9;
            }

            if (destruction > perc) {
                isDestroyed = true;

                boolean isCatastrophe = (destruction == 100);

                // Parallel cost and emission calculations
                CompletableFuture<Double> shellCostFuture = CompletableFuture.supplyAsync(() ->
                        shellMaterial.getDemolutionCost(isCatastrophe)
                );

                CompletableFuture<Double> finishCostFuture = CompletableFuture.supplyAsync(() ->
                        finishMaterial.getDemolutionCost(isCatastrophe)
                );

                CompletableFuture<Double> emissionFuture = CompletableFuture.supplyAsync(() ->
                        shellMaterial.getEmission() + finishMaterial.getEmission()
                );

                // Combine results and update shared state
                CompletableFuture<Void> updateState = CompletableFuture.allOf(shellCostFuture, finishCostFuture, emissionFuture)
                        .thenRun(() -> {
                            try {
                                double shellCost = shellCostFuture.join();
                                double finishCost = finishCostFuture.join();
                                double totalEmissions = emissionFuture.join() + energyConsumption + age;

                                synchronized (this) {  // Ensure atomic updates to shared state
                                    budget += shellCost + finishCost;
                                    emissions += totalEmissions;
                                }
                            } catch (Exception e) {
                                throw new RuntimeException("Error in parallel computation", e);
                            }
                        });

                updateState.join();  // Wait for all state updates to complete
            } else {
                // Parallel call to repair if not destroyed
                CompletableFuture.runAsync(() -> repair(destruction, false)).join();
            }
        }).join();  // Ensures the entire method runs asynchronously but blocks until completion.
    }


    /**
     * Ages the building by one year.
     * Updates budget, satisfaction index, and emissions .
     * POST: age is incremented by 1.
     * POST: If age == lifespan, building is demolished.
     * POST: budget, emissions, and satisfaction index are updated.
     */
    @Override
    public void age() {
        if (++age == kind.getLifespan()) {
            demolish(1);
            return;
        }
        budget += shellMaterial.getMaintenanceCost();
        budget += finishMaterial.getMaintenanceCost();
        yearlySatisfactoryIndex += currentSatisfactoryIndex;
        currentSatisfactoryIndex *= 0.987; // Satisfaction decreases annually.
        emissions += energyConsumption * kind.getEmissionCoeff();
    }


}
