package Aufgabe2;


import java.util.Random;
import java.util.Map;
import java.util.stream.Stream;
/** In this Simulation Class we can see how the 6 buildings and their minimal, ecological and high-quality version
develop in time. For each simulation of a building we see its 3 versions. The simulation is in a small city
with a population of 10000 people with a high school and an university with a lot of buildings which look like
high school. The average block of flat is with 8 floors and 3 apartments in each floor - approximately 60 residants.
 There is a works for machine-building which has up to 500 workers. The city is called Paraprog.
*/
public class Simulation {

    // STYLE: Procedural programming
    public static int population = 10000;
    public static int studentsAndTeachers = 1500;
    public static int workers = 500;
    public static int residants = 60;
    // BAD PROCEDURAL: Buildings should be only used in methods and not as a global variable
    public static Building[] buildings;



    /**
     *  - Get the simulation into account,
     *  - calculate the budget for every building
     *  - and output for every building:
     *      -> average financial effort per person per year
     *      -> breakdown of each decade
     *      -> average CO2 emissions per resident per year
     *      -> index for the average satisfaction
     *      -> age of the building
     *      -> sustainability
     * PRE: number >= 1 && number <= 6
     * POST: Returns a formatted string with building statistics.
     *
     * @param number The building number for simulation.
     * @return Formatted simulation output.
     */
    // BAD PROCEDURAL: The method assumes the input number is always valid (between 1 and 6).
// SUGGESTION: Add input validation and throw an exception or return an error if the number is out of range.
    public static String goalFunction(int number){
        simulation(number);

        Building minimal = buildings[0]; // GOOD: Uses polymorphism to handle multiple building types seamlessly.
        Building eco = buildings[1];
        Building high = buildings[2];
        int people = people(number);
        String output = "";
        output += "\nBuilding number 1 - Current scenario: Minimal \nAverage financial effort per person per year: "
                + String.format("%.2f", minimal.getBudgetPerPersonPerYear(people)) + " euro;"
                + "\nBreakdown of each decade for the average financial effort per resident per year: "
                + decadeToString(minimal.getBudgetPerPersonPerYearPerDecade()) + " euro;"
                + "\nAverage CO2 emissions per resident per year: "
                +  String.format("%.2f", minimal.getEmissionsPerPersonPerYear(people)) + " tons; "
                + "\nIndex for the average satisfaction with living quality per year: " +
                String.format("%.2f", minimal.getAverageIndexForHappinessPerPerson())
                + "\nIndex for the average satisfaction with living quality per decade: " +
                decadeToString(minimal.getAverageIndexForHappinessPerPersonPerDecade())
                + "\nAge: " + minimal.getAge()
                + "\nSustainability: " + String.format("%.1f", minimal.getSustainability() )
                + "\n" ;

        output += "\nBuilding number 2 - Current scenario: Eco \nAverage financial effort per person per year: "
                + String.format("%.2f", eco.getBudgetPerPersonPerYear(people)) + " euro;"
                + "\nBreakdown of each decade for the average financial effort per resident per year: "
                + decadeToString(eco.getBudgetPerPersonPerYearPerDecade()) + " euro;"
                + "\nAverage CO2 emissions per resident per year: "
                +  String.format("%.2f", eco.getEmissionsPerPersonPerYear(people)) + " tons;"
                + "\nIndex for the average satisfaction with living quality per year: " +
                String.format("%.2f", eco.getAverageIndexForHappinessPerPerson())
                + "\nIndex for the average satisfaction with living quality per decade: " +
                decadeToString(eco.getAverageIndexForHappinessPerPersonPerDecade())
                + "\nAge: " + eco.getAge()
                + "\nSustainability: " + String.format("%.1f", eco.getSustainability() )
                + "\n" ;

        output += "\nBuilding number 3 - Current scenario: High Quality \nAverage financial effort per person per year: "
                + String.format("%.2f", high.getBudgetPerPersonPerYear(people)) + " euro;"
                + "\nBreakdown of each decade for the average financial effort per resident per year: "
                + decadeToString(high.getBudgetPerPersonPerYearPerDecade()) + " euro;"
                + "\nAverage CO2 emissions per resident per year: "
                +  String.format("%.2f", high.getEmissionsPerPersonPerYear(people)) + " tons;"
                + "\nIndex for the average satisfaction with living quality per year: " +
                String.format("%.2f", high.getAverageIndexForHappinessPerPerson())
                + "\nIndex for the average satisfaction with living quality per decade: " +
                decadeToString(high.getAverageIndexForHappinessPerPersonPerDecade())
                + "\nAge: " + high.getAge()
                + "\nSustainability: " + String.format("%.1f", high.getSustainability())
                + "\n" ;

        return output;
    }

    /**
     * Generates buildings based on the provided number.
     *
     * PRE: number >= 1 && number <= 6
     * POST: Returns an array of three buildings.
     *
     * @param number The building number to generate.
     * @return An array of three building instances.
     */

    public static Building[] generator(int number) { //STYLE: functional programming  - the whole methode
        // Mapping building types to their respective arrays using Stream

        Map<Integer, Building[]> buildingGenerators = Map.of(
                1, Stream.of(
                        new AdministrativeBuilding(new MinimalKindOfBuilding()),
                        new AdministrativeBuilding(new EcologicalKindOfBuilding()),
                        new AdministrativeBuilding(new HighQualityKindOfBuilding())
                ).toArray(Building[]::new),
                2, Stream.of(
                        new AcademicalBuilding(new MinimalKindOfBuilding()),
                        new AcademicalBuilding(new EcologicalKindOfBuilding()),
                        new AcademicalBuilding(new HighQualityKindOfBuilding())
                ).toArray(Building[]::new),
                3, Stream.of(
                        new Works(new MinimalKindOfBuilding()),
                        new Works(new EcologicalKindOfBuilding()),
                        new Works(new HighQualityKindOfBuilding())
                ).toArray(Building[]::new),
                4, Stream.of(
                        new Museum(new MinimalKindOfBuilding()),
                        new Museum(new EcologicalKindOfBuilding()),
                        new Museum(new HighQualityKindOfBuilding())
                ).toArray(Building[]::new),
                5, Stream.of(
                        new BlockOfFlats(new MinimalKindOfBuilding()),
                        new BlockOfFlats(new EcologicalKindOfBuilding()),
                        new BlockOfFlats(new HighQualityKindOfBuilding())
                ).toArray(Building[]::new)
        );

        // Default case if the number doesn't match
        return buildingGenerators.getOrDefault(number,
                Stream.of(
                        new MedBuilding(new MinimalKindOfBuilding()),
                        new MedBuilding(new EcologicalKindOfBuilding()),
                        new MedBuilding(new HighQualityKindOfBuilding())
                ).toArray(Building[]::new)
        );


    }

    /**
     * Simulate the life of the kindOfBuildings:
     *  - Generate the 3 kindOfBuildings
     *  - Follow up what is happening to each building with time passing
     *      -> increase the age of the buildings if they are not destroyed
     *      -> check to see if there is a catastrophy this year and if so generate the damage percentage
     *         and apply it to each building
     *      -> start renovating a building at random point
     *         and renovate a small part of it every year
     *      -> update the budget and the satisfactory index per decade
     * PRE: number >= 1 && number <= 6
     * POST: Simulates and updates buildings' states.
     *
     * @param number The simulation number.
     */
    private static void simulation(int number) {
        // GOOD PROCEDURAL: it's divided in separate methods instead of a one whole thing
        buildings = generator(number);

        int[] startingRen = new int[3];
        // GOOD PROCEDURAL: the information is put in array instead of separate objects
        boolean[] renovating = {false, false, false};
        int people = people(number);
        int i = 1;
        // GOOD PROCEDURAL: Proper use of control structures
        while (!buildings[0].isDestroyed() || !buildings[1].isDestroyed() || !buildings[2].isDestroyed()) {
            Random rand = new Random();
            Catastrophe catastrophe = new Catastrophe();
            boolean cat;
            for (int j = 0; j <= 2; j++) {
                int renovation = rand.nextInt(10);
                if (!buildings[j].isDestroyed()) {
                    buildings[j].age();
                    cat = catastrophe.isExisting();
                    catastrophe.demolish(buildings[j], cat);
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
                        buildings[j].calculateBudgetPerPersonPerYearPerDecade(i, people);
                        buildings[j].calculateAverageIndexForHappinessPerPersonPerDecade(i);
                    }
                }
            }
            i++;
        }

        // if for example a building is destroyed at the age of 46 this for cycle calculates for the 5th
        // decade the average money and index because of the 6 years
        for (int j = 0; j < 3; j++) {
            //STYLE: OOP
            buildings[j].calculateBudgetPerPersonPerYearPerDecade(buildings[j].getAge(), people);
            buildings[j].calculateAverageIndexForHappinessPerPersonPerDecade(buildings[j].getAge());
        }
    }

    /**
     * Converts decade data to a formatted string.
     *
     * PRE: array != null
     * POST: Returns a non-null formatted string.
     */
    private static String decadeToString(double[] array) {
        String output = "";
        for (int i = 0; i < array.length; i++){
            output += String.format("%.2f",array[i]) + "  ";
        }
        return output;
    }

    /**
     * Determines the number of people associated with a building type.
     *
     * PRE: number >= 1 && number <= 6
     * POST: Returns a positive integer for the population.
     *
     * @param number The building number.
     * @return Number of people.
     */

    private static int people(int number){
        switch (number){
            case 1,4,6:
                //STYLE: Procedurale Programming
                return population;
            case 2:
                return studentsAndTeachers;
            case 3:
                return workers;
            default:
                return residants;
        }
    }
}
