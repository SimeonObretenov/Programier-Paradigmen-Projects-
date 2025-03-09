package Aufgabe2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * Represents a works (factory) for machine-building with 500 workers.
 * Implements the Building interface, providing methods for managing lifecycle,
 * budget, and sustainability.
 */
public class Works implements Building {

    private KindOfBuilding kind;
    private Random random = new Random();
    private Material shellMaterial;
    private Material finishMaterial;
    private double energyConsumption = random.nextInt(1_000_000, 4_000_000);
    private double emissions;
    private boolean isDestroyed = false;
    private int age = 0;
    private double budget;
    private double[] budgetPerDecade;

    private double initialSatisfactoryIndex = 100;
    private double currentSatisfactoryIndex = initialSatisfactoryIndex;
    private double yearlySatisfactoryIndex = 0;
    private double[] satisfactoryIndexPerDecade;

    /**
     * Initializes a Works object with a specific type of building.
     * @param kind Type of building influencing its properties.
     * PRE: kind != null
     * POST: A new Works object is created with initialized materials and stats.
     */
    public Works(KindOfBuilding kind) {
        this.kind = kind;
        shellMaterial = new ShellMaterial(kind.getShellMaterialCoeff(), random.nextInt(2250, 6000));
        finishMaterial = new FinishMaterial(kind.getFinishMaterialCoeff(), random.nextInt(250, 1000));
        emissions = (shellMaterial.getEmission() + finishMaterial.getEmission()) * kind.getEmissionCoeff();
        budget = shellMaterial.getInitialCosts() + finishMaterial.getInitialCosts();
        budgetPerDecade = new double[kind.getLifespan() / 10];
        satisfactoryIndexPerDecade = new double[kind.getLifespan() / 10];
    }

    /**
     * Returns the budget allocation per person per year for each decade.
     * @return Array of budget allocations.
     * POST: Result != null && Result.length == kind.getLifespan() / 10
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

    @Override

    /**
     * Calculates the budget allocation per person per year for a specific decade.
     * Adjusts based on whether the building is operational or destroyed.
     *
     * PRE: year > 0 && year <= kind.getLifespan()
     * PRE: residents > 0
     * POST: budgetPerDecade is updated for the given decade.
     *
     * @param year Current year to calculate for.
     * @param residents Number of city residents.
     */
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
    public double getBudgetPerPersonPerYear(int residents){
        return budget/residents/age;
    }

    /**
     * Returns the average satisfaction index per person for each decade.
     * @return Array of satisfaction indices per decade.
     * POST: Result != null && Result.length == kind.getLifespan() / 10
     */
    public double[] getAverageIndexForHappinessPerPersonPerDecade() {
        return satisfactoryIndexPerDecade;
    }

    /**
     * Returns the average satisfaction index accumulated over the building's lifetime.
     * @return Average satisfaction index.
     * PRE: age > 0
     * POST: Result >= 0
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

    /**
     * Calculates the average satisfaction index per person for a specific decade.
     * @param year Current year to calculate for.
     * PRE: year > 0 && year <= kind.getLifespan()
     * POST: satisfactoryIndexPerDecade is updated for the specified decade.
     */
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
     * Calculates and returns the building's sustainability index.
     * @return Sustainability index of the building.
     * POST: Result > 0
     */
    public double getSustainability() {
        if (kind.getClass() == MinimalKindOfBuilding.class) {
            return (1 / emissions) +
                    (1 / energyConsumption) +
                    (((double) kind.getLifespan() / kind.getRenovationCycle())) +
                    (1 / (finishMaterial.getSustainability() + shellMaterial.getSustainability()));
        } else if (kind.getClass() == EcologicalKindOfBuilding.class) {
            return 3.6 * (1 / emissions) +
                    1.4 * (1 / energyConsumption) +
                    2.5 * (((double) kind.getLifespan() / kind.getRenovationCycle())) +
                    (1 / (finishMaterial.getSustainability() + shellMaterial.getSustainability()));
        }
        return 1.2 * (1 / emissions) +
                1.4 * (1 / energyConsumption) +
                1.1 * (((double) kind.getLifespan() / kind.getRenovationCycle())) +
                (1 / (finishMaterial.getSustainability() + shellMaterial.getSustainability()));
    }

    /**
     * Calculates emissions per person per year.
     * @param residents Number of city residents.
     * @return Emissions per person per year.
     * PRE: residents > 0 && age > 0
     * POST: Result > 0
     */
    @Override
    public double getEmissionsPerPersonPerYear(int residents) {
        return emissions * 0.02 / residents / age;
    }

    /**
     * Retrieves the renovation cycle of the works.
     * @return Renovation cycle in years.
     * POST: Result > 0
     */
    @Override
    public int getRennovationCycle() {
        return kind.getRenovationCycle();
    }

    /**
     * Checks whether the works is destroyed.
     * @return True if destroyed, false otherwise.
     * POST: Result == true || Result == false
     */
    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    /**
     * Retrieves the current age of the works.
     * @return Age in years.
     * POST: Result >= 0
     */
    @Override
    public int getAge() {
        return age;
    }

    /**
     * Repairs the building by a specified percentage.
     * Optionally updates the satisfaction index if finishing renovation is performed.
     * @param percentToRepair Percentage of damage to repair.
     * @param finishRen Whether finishing renovation is performed.
     * PRE: percentToRepair >= 0 && percentToRepair <= 100
     * POST: Budget and satisfaction index are updated.
     */
    @Override
    public void repair(double percentToRepair, boolean finishRen) {
        if (isDestroyed) {
            return;
        }

        if (percentToRepair == 1) {
            if(kind.getClass()==MinimalKindOfBuilding.class){
                budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * 0.000000016;
                budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * 0.000000016;
            }else if(kind.getClass()==EcologicalKindOfBuilding.class){
                budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * 0.000000006;
                budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * 0.00000001;
            }else{
                budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * 0.0093;
                budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * 0.0094;
            }
//            shellCosts *= 1.000000016;
//            finishingCosts *= 1.000000016;
//            shellQuantity *= 1.000000016;
//            finishQuantity *= 1.000000016;
            if (finishRen) {
                yearlySatisfactoryIndex += initialSatisfactoryIndex * 0.98;
                if(kind.getClass()== HighQualityKindOfBuilding.class){
                    initialSatisfactoryIndex *= 0.97;
                }else{
                    initialSatisfactoryIndex *= 0.99;
                }
                currentSatisfactoryIndex = initialSatisfactoryIndex;
            }
            return;
        }
        budget += (shellMaterial.getInitialCosts() + shellMaterial.getDemolutionCost(false)) * (percentToRepair / 100 + 1);
        budget += (finishMaterial.getInitialCosts() + finishMaterial.getDemolutionCost(false)) * (percentToRepair / 100 + 1);
    }

    /**
     * Demolishes the building if damage exceeds a threshold.
     * Otherwise, the damage is repaired.
     * @param destruction Percentage of destruction inflicted.
     * PRE: destruction >= 0 && destruction <= 100
     * POST: If destruction > threshold, isDestroyed == true.
     */
    @Override
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
     * Ages the works by one year.
     * If lifespan is reached, demolishes the building.
     * PRE: None
     * POST: Age is incremented. Budget and emissions are updated.
     */
    @Override
    public void age() {
        if (++age == kind.getLifespan()) {
            demolish(1);
            return;
        }
        budget += shellMaterial.getMaintenanceCost();
        budget += finishMaterial.getMaintenanceCost();
        yearlySatisfactoryIndex +=currentSatisfactoryIndex;
        currentSatisfactoryIndex *=0.987;
        emissions += energyConsumption* kind.getEmissionCoeff();
    }
}
