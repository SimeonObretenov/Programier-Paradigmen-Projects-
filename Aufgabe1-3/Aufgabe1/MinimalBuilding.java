package Aufgabe1;

// Class describing a minimal building
public class MinimalBuilding implements Building {
    public MinimalBuilding(int[] rgn) {
        shellCosts *= rgn[0];
        finishingCosts *= rgn[1];
        demolutionCosts *= rgn[2];
        maintenance *= rgn[3];
        shellQuantity *= rgn[4];
        finishQuantity *= rgn[5];
        energyConsumption *= rgn[6];
    }
    // Time-oriented
    private final int lifespan = 50;
    private final int renovationCycle = 20;

    // KindOfBuilding quality
    private final double archQuality = 0.75;
    private final double materialsQuality = 2.0;

    // Life of the building
    private boolean isDestroyed = false;
    private int age = 0;

    // Costs
    private double shellCosts = 1.0; // Rohbau
    private double finishingCosts = 1.0; // Ausbau
    private double demolutionCosts = 1.25;
    private double maintenance = 1.0;
    private double budget = 0;
    private double[] budgetPerDecade = new double[lifespan / 10];


    // Quantity
    private double shellQuantity = 1.0;
    private double finishQuantity = 1.5;
    private double energyConsumption = 1.25;

    // Satisfaction
    private double initialSatisfactoryIndex = 100;
    private double currentSatisfactoryIndex=initialSatisfactoryIndex;
    private double yearlySatisfactoryIndex = initialSatisfactoryIndex;
    private double[] satisfactoryIndexPerDecade = new double[lifespan / 10];

    // ecological impact
    private double emissions = energyConsumption;
    private double waste = 0;

    @Override
    public int getRennovationCycle() {
        return renovationCycle;
    }

    @Override
    public boolean isDestroyed(){
        return isDestroyed;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public double[] getBudgetPerPersonPerYearPerDecade() {
        return budgetPerDecade;
    }

    @Override
    public double getBudgetPerPersonPerYear(int residents) {
        return budget / (residents * age);
    }

    @Override
    public void calculateBudgetPerPersonPerYearPerDecade(int year, int residents) {
        if (!isDestroyed) {
            double money = this.budget;
            for (int i = 0; i < year / 10; i++) {
                money -= budgetPerDecade[i] * 10 * residents;
            }
            budgetPerDecade[year / 10 - 1] = money / residents / 10;
        }
        else {
            int i = 0;
            double money = this.budget;
            while (i < lifespan / 10 && budgetPerDecade[i] != 0.0){
                money -= budgetPerDecade[i] * 10 * residents;
                i++;
            }
            if (money > 0 && i != lifespan / 10) {
                budgetPerDecade[i] = money / residents / 10;
            }
        }
    }

    @Override
    public double[] getAverageIndexForHappinessPerPersonPerDecade() {
        return satisfactoryIndexPerDecade;
    }

    @Override
    public double getAverageIndexForHappinessPerPerson() {
        return yearlySatisfactoryIndex / age;
    }

    @Override
    public void calculateAverageIndexForHappinessPerPersonPerDecade(int year) {
        if (!isDestroyed) {
            double index = this.yearlySatisfactoryIndex;
            for (int i = 0; i < year / 10; i++) {
                index -= satisfactoryIndexPerDecade[i] * 10;
            }
            satisfactoryIndexPerDecade[year / 10 - 1] = index / 10;
        }
        else {
            int i = 0;
            double index = this.yearlySatisfactoryIndex;
            while (i < lifespan / 10 && satisfactoryIndexPerDecade[i] != 0.0){
                index -= satisfactoryIndexPerDecade[i] * 10;
                i++;
            }
            if (index > 0 && i < lifespan / 10) {
                satisfactoryIndexPerDecade[i] = index / 10;
            }
        }
    }

    @Override
    public double getEmissionsPerPersonPerYear(int residents) {
        return emissions / residents/ age;
    }

    @Override
    public double getWastePerPersonPerYear(int residents) {
        return waste / residents / age;
    }

    @Override
    public double getSustainabilityIndex() {
        return  (1 / emissions) +
                (1 / waste) +
                (1 / energyConsumption) +
                (((double) lifespan / renovationCycle));
    }

    @Override
    public void repair(double percentToRepair, boolean finishRen) {
        if (isDestroyed) {
            return;
        }

        if (percentToRepair == 1) {
            shellCosts *= 1.000000016;
            finishingCosts *= 1.000000016;
            shellQuantity *= 1.000000016;
            finishQuantity *= 1.000000016;
            if (finishRen) {
                yearlySatisfactoryIndex += initialSatisfactoryIndex * 0.98;
                initialSatisfactoryIndex *= 0.98;
                currentSatisfactoryIndex = initialSatisfactoryIndex;
            }
            return;
        }

        shellCosts *= (percentToRepair / 50 + 1);
        finishingCosts *= (percentToRepair / 50 + 1);
        shellQuantity *= (percentToRepair / 50 + 1);
        finishQuantity *= (percentToRepair / 50 + 1);
    }

    @Override
    public void demolish(double destruction) {
        // Do nothing if the building is destroyed
        if (isDestroyed) {
            return;
        }

        if (destruction > 0.80) {
            isDestroyed = true;
            budget += demolutionCosts;
            emissions =  (shellQuantity + finishQuantity + maintenance+age) * 2 ;
            waste = (shellQuantity  + finishQuantity) * 2 ;
            return;
        }

        repair(destruction, false);
    }

    @Override
    public void age() {
        if (++age == lifespan) {
            demolish(1);
            return;
        }
        yearlySatisfactoryIndex += currentSatisfactoryIndex - 1;
        currentSatisfactoryIndex -= 2;
        budget = shellCosts + finishingCosts + maintenance * age;
        emissions += energyConsumption;
    }

}


