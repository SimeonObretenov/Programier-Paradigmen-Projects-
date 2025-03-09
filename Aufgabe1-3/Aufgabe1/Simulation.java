package Aufgabe1;
import java.util.Random;

// Class that runs 10 Simulations and inputs the one with the greatest sustainability
public class Simulation {

    public static int floors = 8;
    public static int apartmentsPerFloor = 3;
    public static int residents = floors * apartmentsPerFloor;

    public static Building[] buildings;


    public static void main(String[] args) {
        System.out.println("Simulation 1:");
        System.out.println(goalFunction());
        System.out.println("Simulation 2:");
        System.out.println(goalFunction());
        System.out.println("Simulation 3:");
        System.out.println(goalFunction());
        System.out.println("Simulation 4:");
        System.out.println(goalFunction());
        System.out.println("Simulation 5: ");
        System.out.println(goalFunction());
        System.out.println("Simulation 6:");
        System.out.println(goalFunction());
        System.out.println("Simulation 7: ");
        System.out.println(goalFunction());
        System.out.println("Simulation 8:");
        System.out.println(goalFunction());
        System.out.println("Simulation 9:");
        System.out.println(goalFunction());
        System.out.println("Simulation 10:");
        System.out.println(goalFunction());
    }

    /**
     *  - Get the simulation into account,
     *  - calculate the budget for every building
     *  - and output for every building:
     *      -> average financial effort per person per year
     *      -> breakdown of each decade
     *      -> average CO2 emissions per resident per year
     *      -> average non-recyclable waste
     *      -> index for the average satisfaction
     *      -> age of the building
     *      -> sustainability
     */
    public static String goalFunction(){
        simulation();

        Building minimal = buildings[0];
        Building eco = buildings[1];
        Building high = buildings[2];

        String output = "";
        output += "\nKindOfBuilding number 1 - Current scenario: Minimal \nAverage financial effort per person per year: "
                + String.format("%.2f", minimal.getBudgetPerPersonPerYear(residents)) + " euro;"
                + "\nBreakdown of each decade for the average financial effort per resident per year: "
                + decadeToString(minimal.getBudgetPerPersonPerYearPerDecade()) + " euro;"
                + "\nAverage CO2 emissions per resident per year: "
                +  String.format("%.2f", minimal.getEmissionsPerPersonPerYear(residents)) + " tons; "
                + "\nAverage non-recyclable waste: "
                + String.format("%.2f", minimal.getWastePerPersonPerYear(residents))+" tons;"
                + "\nIndex for the average satisfaction with living quality per year: " +
                String.format("%.2f", minimal.getAverageIndexForHappinessPerPerson())
                + "\nIndex for the average satisfaction with living quality per decade: " +
                decadeToString(minimal.getAverageIndexForHappinessPerPersonPerDecade())
                + "\nAge: " + minimal.getAge()
                + "\nSustainability: " + String.format("%.4f", minimal.getSustainabilityIndex() * 10)
                + "\n" ;

        output += "\nKindOfBuilding number 2 - Current scenario: Eco \nAverage financial effort per person per year: "
                + String.format("%.2f", eco.getBudgetPerPersonPerYear(residents)) + " euro;"
                + "\nBreakdown of each decade for the average financial effort per resident per year: "
                + decadeToString(eco.getBudgetPerPersonPerYearPerDecade()) + " euro;"
                + "\nAverage CO2 emissions per resident per year: "
                +  String.format("%.2f", eco.getEmissionsPerPersonPerYear(residents)) + " tons;"
                + "\nAverage non-recyclable waste: "
                + String.format("%.2f",  eco.getWastePerPersonPerYear(residents))+" tons;"
                + "\nIndex for the average satisfaction with living quality per year: " +
                String.format("%.2f", eco.getAverageIndexForHappinessPerPerson())
                + "\nIndex for the average satisfaction with living quality per decade: " +
                decadeToString(eco.getAverageIndexForHappinessPerPersonPerDecade())
                + "\nAge: " + eco.getAge()
                + "\nSustainability: " + String.format("%.3f", eco.getSustainabilityIndex() * 10)
                + "\n" ;

        output += "\nKindOfBuilding number 3 - Current scenario: High Quality \nAverage financial effort per person per year: "
                + String.format("%.2f", high.getBudgetPerPersonPerYear(residents)) + " euro;"
                + "\nBreakdown of each decade for the average financial effort per resident per year: "
                + decadeToString(high.getBudgetPerPersonPerYearPerDecade()) + " euro;"
                + "\nAverage CO2 emissions per resident per year: "
                +  String.format("%.2f", high.getEmissionsPerPersonPerYear(residents)) + " tons;"
                + "\nAverage non-recyclable waste: "
                + String.format("%.2f", high.getWastePerPersonPerYear(residents))+" tons;"
                + "\nIndex for the average satisfaction with living quality per year: " +
                String.format("%.2f", high.getAverageIndexForHappinessPerPerson())
                + "\nIndex for the average satisfaction with living quality per decade: " +
                decadeToString(high.getAverageIndexForHappinessPerPersonPerDecade())
                + "\nAge: " + high.getAge()
                + "\nSustainability: " + String.format("%.3f", high.getSustainabilityIndex() * 10)
                + "\n" ;

        return output;
    }

    /**
     *  - Generate a building with 8 floors and 3 apartments per floor
     *  - Assign the values to each type of kindOfBuildings:
     *      -> each variable will be different for all the kindOfBuildings in the end, because we declare
     *         it first as a coefficient (based on the information from the task description),
     *         that we then multiply by the random generated value
     */
    public static Building[] generator(){
        Random rand = new Random();
        int shellCosts = rand.nextInt(200000, 400000);
        int finishingCosts = rand.nextInt(200000,350000);
        int demolutionCosts = rand.nextInt(25000, 100000);
        int maintenance = rand.nextInt(20000, 25000);
        int shellQuantity = rand.nextInt(500, 1000);
        int finishingQuantity = rand.nextInt(1000, 2000);
        int energyConsumption = rand.nextInt(500, 1000);

        int[] rng = {shellCosts, finishingCosts, demolutionCosts, maintenance, shellQuantity, finishingQuantity, energyConsumption};

        return new Building[]{new MinimalBuilding(rng), new EcologicalBuilding(rng), new HighQualityBuilding(rng)};
    }

    /**
     * Simulate the life of the kindOfBuildings:
     *  - Generate the 3 kindOfBuildings
     *  - Follow up what is happening to each building with time passing
     *      -> increase the age of the kindOfBuildings if they are not destroyed
     *      -> check to see if there is a catastrophy this year and if so generate the damage percentage
     *         and apply it to each building
     *      -> start renovating a building at age 6 (or 6 years after the last full renovation)
     *         and renovate a small part of it every year
     *      -> update the budget and the satisfactory index per decade
     */
    private static void simulation() {
        buildings = generator();

        int[] startingRen = new int[3];
        boolean[] renovating = {false, false, false};

        int i = 1;
        while (!buildings[0].isDestroyed() || !buildings[1].isDestroyed() || !buildings[2].isDestroyed()) {
            Random rand = new Random();
            int catastrophy = rand.nextInt(10);
            int magnitude = rand.nextInt(100);

            for (int j = 0; j <= 2; j++) {
                int renovation = rand.nextInt(10);
                if (!buildings[j].isDestroyed()) {
                    buildings[j].age();
                    if (catastrophy == 4) {
                        buildings[j].demolish(((double) magnitude) / 100);
                    }
                    if (renovation == 6 && !renovating[j]) {
                        renovating[j] = true;
                        startingRen[j] = buildings[j].getAge();
                    }
                    if (renovating[j]) {
                        buildings[j].repair(1,
                                buildings[j].getAge() - startingRen[j] == buildings[j].getRennovationCycle());
                    }
                    if (buildings[j].getAge() - startingRen[j] == buildings[j].getRennovationCycle()) {
                        startingRen[j] = 0;
                        renovating[j] = false;
                    }
                    if (i % 10 == 0) {
                        buildings[j].calculateBudgetPerPersonPerYearPerDecade(i, residents);
                        buildings[j].calculateAverageIndexForHappinessPerPersonPerDecade(i);
                    }

                }

            }

            i++;
        }

        // if for example a building is destroyed at the age of 46 this for cycle calculates for the 5th
        // decade the average money and index because of the 6 years
        for (int j = 0; j < 3; j++) {
            buildings[j].calculateBudgetPerPersonPerYearPerDecade(buildings[j].getAge(), residents);
            buildings[j].calculateAverageIndexForHappinessPerPersonPerDecade(buildings[j].getAge());
        }



    }

    public static String decadeToString(double[] array) {
        String output = "";
        for (int i = 0; i < array.length; i++){
            output += String.format("%.2f",array[i]) + "  ";
        }
        return output;
    }
}
