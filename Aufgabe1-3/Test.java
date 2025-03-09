import Aufgabe1.Building;
import Aufgabe1.EcologicalBuilding;
import Aufgabe1.HighQualityBuilding;
import Aufgabe1.MinimalBuilding;
import Aufgabe2.*;


import java.util.Random;

/**
 * NOTE: Class to test the implemented methods
 * Responsibilities for AB1:
 *  - Yoana Angelova: MinimalKindOfBuilding, Test, goalFunction(), decadeToString(), comments
 *  - Ivaylo Georgiev: HighQualityKindOfBuilding, KindOfBuilding, generator(), simulation()
 *  - Simeon Obretenov: EcologicalKindOfBuilding, generator(), simulation()
 *
 *  Responsibilities for AB2:
 *  - Yoana Angelova: Material classes, Block of Flats, Medical Building
 *  - Ivaylo Georgiev: Catastrophe, Simulation, Academical Buildings, Works
 *  - Simeon Obretenov: Ecological-, Minimal- and HighQualityKindofBuilding, Administrative Builiding, Museum
 *
 *  Responsibilities for AB3:
 *  - Yoana Angelova: Parallel programming, Test, comments
 *  - Ivaylo Georgiev: Functional programming, Test
 *  - Simeon Obretenov: Parallel programming, Test, comments
 * */


public class Test {
    public static void main(String[] args) {
        //Aufgabe 1

        Building[] buildings = Aufgabe1.Simulation.generator();

        Building minimal = buildings[0];
        Building eco = buildings[1];
        Building high = buildings[2];

        System.out.println("Test 1: aging:");
        int minimalAgeBeforeAging = minimal.getAge();
        for (int i = 0; i < 5; i++) {
            minimal.age();
        }
        testValue(minimalAgeBeforeAging, minimal.getAge());

        Building newMinimal = Aufgabe1.Simulation.generator()[0];
        Building newEco = Aufgabe1.Simulation.generator()[1];
        Building newHigh = Aufgabe1.Simulation.generator()[2];

        System.out.println("Test 2: comparing identity:");
        testIdentity(minimal, newMinimal, false);
        testIdentity(high, newHigh, false);

        System.out.println("Test 3: destruction:");
        newEco.demolish(90);
        testIdentity(newEco.isDestroyed(), false, false);
        testIdentity(eco.isDestroyed(), false);

        // BAD PROCEDURAL: testing the program should've been by a method and by not many loops
        double initialSatisfactoryIndex = eco.getAverageIndexForHappinessPerPerson();
        double initialBudget = eco.getBudgetPerPersonPerYearPerDecade()[0];
        eco.age();
        double initialEmmisions = eco.getEmissionsPerPersonPerYear(24);
        Random rand = new Random();
        int catastrophy = rand.nextInt(10);
        int magnitude = rand.nextInt(100);
        boolean renovating = false;
        int startingRen = 0;

        for (int i = 1; i < 30; i++) {
            if (eco.isDestroyed()) {
                return;
            }

            eco.age();
            int renovation = rand.nextInt(10);
            if (catastrophy == 4) {
                eco.demolish(((double) magnitude) / 100);
            }
            if (renovation == 6 && !renovating) {
                renovating = true;
                startingRen = eco.getAge();
            }
            if (renovating) {
                eco.repair(1, eco.getAge() - startingRen == eco.getRennovationCycle());
            }
            if (eco.getAge() - startingRen == eco.getRennovationCycle()) {
                startingRen = 0;
                renovating = false;
            }
            if (i % 10 == 0) {
                eco.calculateBudgetPerPersonPerYearPerDecade(i, 24);
                eco.calculateAverageIndexForHappinessPerPersonPerDecade(i);
            }

        }

        System.out.println("Test 4: decreasing satisfactory index with time:");
        testValue(eco.getAverageIndexForHappinessPerPerson(), initialSatisfactoryIndex);

        System.out.println("Test 5: calculate the budget:");
        testValue(initialBudget, eco.getBudgetPerPersonPerYear(24));

        System.out.println("Test 6: increase the CO2 emissions:");
        eco.demolish(1);
        testValue(eco.getEmissionsPerPersonPerYear(24), initialEmmisions);

        // Aufgabe 2 and 3

        //STYLE: Procedural Programming
        // PRE: Simulations require valid building numbers (1 to 6).
        // POST: Outputs simulation results to the console.
        System.out.println("\n\n\nSimulation 1, Administrative Building:");
        System.out.println(Aufgabe2.Simulation.goalFunction(1));
        System.out.println("Simulation 2, Academical Building:");
        System.out.println(Aufgabe2.Simulation.goalFunction(2));
        System.out.println("Simulation 3, Works:");
        System.out.println(Aufgabe2.Simulation.goalFunction(3));
        System.out.println("Simulation 4, House-Museum:");
        System.out.println(Aufgabe2.Simulation.goalFunction(4));
        System.out.println("Simulation 5, Block of flats:");
        System.out.println(Aufgabe2.Simulation.goalFunction(5));
        System.out.println("Simulation 6, Medical Building:");
        System.out.println(Aufgabe2.Simulation.goalFunction(6));


        Aufgabe2.Building school = new AcademicalBuilding(new EcologicalKindOfBuilding());
        Catastrophe catastrophe = new Catastrophe();
        System.out.println("Test 7: testing an object catastrophe");
        boolean makingDamage = catastrophe.isExisting();
        while(!makingDamage){
            makingDamage = catastrophe.isExisting();
        }
        while(!school.isDestroyed()){
            catastrophe.demolish(school,makingDamage);
        }
        testIdentity(school.isDestroyed(),true);

        System.out.println("Test 8: testing destruction on the new types of building");
        Aufgabe2.Building hospital = new MedBuilding(new MinimalKindOfBuilding());
        hospital.demolish(80);
        testIdentity(hospital.isDestroyed(), false, false);
        Aufgabe2.Building block = new BlockOfFlats(new HighQualityKindOfBuilding());
        block.demolish(90);
        testIdentity(block.isDestroyed(), true);

        System.out.println("Test 9: testing budget on the new types of building");
        hospital = new MedBuilding(new MinimalKindOfBuilding());
        double initialMedBudget = hospital.getBudgetPerPersonPerYearPerDecade()[0];
        hospital.age();
        hospital.age();
        hospital.age();
        hospital.age();
        hospital.age();
        hospital.age();
        hospital.demolish(40);
        testValue(initialMedBudget, hospital.getBudgetPerPersonPerYear(2000));
    }
    public static void testIdentity(Object first, Object second, boolean expected) {
        boolean real = first == second;

        if (real == expected) {
            System.out.println("Successful test");
        } else {
            if (real) {
                System.out.println("Comparison NOT successful! " + first + " should not be " +
                        "identical with " + second);
            } else {
                System.out.println("Comparison NOT successful! " + first + " should be " +
                        "identical with " + second);
            }
        }
    }

    public static void testIdentity(Object given, Object expected) {
        testIdentity(given, expected, true);
    }

    public static void testValue(double given, double expected) {
        if (given < expected) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected + " / Given value: " + given);
        }
    }


}
