package Aufgabe5;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * NOTE: Class to test the implemented methods
 * Responsibilities:
 *  - Yoana Angelova: Map, Space, Exterior, Interior, Counter
 *  - Ivaylo Georgiev: Test, ApprovableSet, ApSet, AdminSet
 *  - Simeon Obretenov: SinglyLinkedList, Admin, Path, Approvable, RCounter
 *
 * No subtype relationships:
 *  - AdminSet and ApSet: AdminSet Implements ApprovableSet<X, P, T>, where T must be a subtype of Admin<X, T>, which
 *    makes it incompatible with ApSet because T in ApSet is general and unconstrained
 *  - Counter and RCounter: implement Approvable with incompatible type arguments.
 */
public class Test {
    public static void main(String[] args) {
        //declaring and initialising following containers
        ApSet<Counter<String>, Counter<String>, String> apString = new ApSet<>();
        ApSet<Counter<Integer>, Counter<Integer>, Integer> apInt = new ApSet<>();
        ApSet<Counter<Path<String>>, Counter<Path<String>>, Path<String>> apPathString = new ApSet<>();
        ApSet<RCounter, RCounter, Path<RCounter>> apRCounter = new ApSet<>();
        ApSet<Space<String>, String, Path<Space<String>>> apSpaceString = new ApSet<>();
        ApSet<Interior<String>, String, Path<Space<String>>> apInteriorString = new ApSet<>();
        ApSet<Exterior<String>, String, Path<Space<String>>> apExteriorString = new ApSet<>();
        AdminSet<RCounter, RCounter, Path<RCounter>> adminRCounter = new AdminSet<>();
        AdminSet<Space<String>, String, Path<Space<String>>> adminSpaceString = new AdminSet<>();
        AdminSet<Interior<String>, String, Path<Space<String>>> adminInteriorString = new AdminSet<>();
        AdminSet<Exterior<String>, String, Path<Space<String>>> adminExteriorString = new AdminSet<>();

        //creating the base objects
        String kitchen = "Kitchen";
        String living = "Living room";
        String bedroom = "Bedroom";

        Integer x = 10;
        Integer y= 20;
        Integer z =30;


        //filling apString

        // Creating strings for rooms
        String[] roomNames = {kitchen, living, bedroom};

        // Creating Counters and Criterions for String
        LinkedList<Counter<String>> stringCounters = new LinkedList<>();
        LinkedList<Counter<String>> stringCriterions = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            stringCounters.add(new Counter<>());
            stringCriterions.add(new Counter<>());
        }

        // Approving Counters with Strings
        int k = 0;
        for (Counter<String> c : stringCriterions) {
            stringCounters.get(0).approve(c, roomNames[k++]);
        }
        stringCounters.get(1).approve(stringCriterions.get(0), roomNames[0]);
        stringCounters.get(1).approve(stringCriterions.get(1), roomNames[1]);
        stringCounters.get(2).approve(stringCriterions.get(2), roomNames[2]);

        // Adding Counters and Criterions to ApSet
        for (Counter<String> c : stringCounters) {
            apString.add(c);
        }
        for (Counter<String> c : stringCriterions) {
            apString.addCriterion(c);
        }


        //filling apInt

        // Creating integers for testing
        Integer[] testNumbers = {x, y, z};

        // Creating Counters and Criterions for Integer
        LinkedList<Counter<Integer>> intCounters = new LinkedList<>();
        LinkedList<Counter<Integer>> intCriterions = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            intCounters.add(new Counter<>());
            intCriterions.add(new Counter<>());
        }

        // Approving Counters with Integers
        k = 0;
        for (Counter<Integer> c : intCriterions) {
            intCounters.get(0).approve(c, testNumbers[k++]);
        }
        intCounters.get(1).approve(intCriterions.get(0), testNumbers[0]);
        intCounters.get(1).approve(intCriterions.get(1), testNumbers[1]);
        intCounters.get(2).approve(intCriterions.get(2), testNumbers[2]);

        // Adding Counters and Criterions to ApSet
        for (Counter<Integer> c : intCounters) {
            apInt.add(c);
        }
        for (Counter<Integer> c : intCriterions) {
            apInt.addCriterion(c);
        }


        //filling apPathString

        // Creating paths for String
        LinkedList<Path<String>> stringPaths = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Path<String> path = new Path<>();
            path.add("Room" + i);
            path.add("Hall" + i);
            path.add("Exit" + i);
            stringPaths.add(path);
        }

        // Creating Counters and Criterions for Path<String>
        LinkedList<Counter<Path<String>>> pathStringCounters = new LinkedList<>();
        LinkedList<Counter<Path<String>>> pathStringCriterions = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            pathStringCounters.add(new Counter<>());
            pathStringCriterions.add(new Counter<>());
        }

        // Approving Counters with Paths
        k = 0;
        for (Counter<Path<String>> c : pathStringCriterions) {
            pathStringCounters.get(0).approve(c, stringPaths.get(k++));
        }
        pathStringCounters.get(1).approve(pathStringCriterions.get(0), stringPaths.get(0));
        pathStringCounters.get(1).approve(pathStringCriterions.get(1), stringPaths.get(1));
        pathStringCounters.get(2).approve(pathStringCriterions.get(2), stringPaths.get(2));

        // Adding Counters and Criterions to ApSet
        for (Counter<Path<String>> c : pathStringCounters) {
            apPathString.add(c);
        }
        for (Counter<Path<String>> c : pathStringCriterions) {
            apPathString.addCriterion(c);
        }


        //filling apRCounter

        // Creating paths for RCounter
        LinkedList<Path<RCounter>> rCounterPaths = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            Path<RCounter> path = new Path<>();
            for (int j = 0; j < 3; j++) {
                path.add(new RCounter());
            }
            rCounterPaths.add(path);
        }

        // Creating Counters and Criterions for Path<RCounter>
        LinkedList<RCounter> rCounterList = new LinkedList<>();
        LinkedList<RCounter> rCounterCriterions = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            rCounterList.add(new RCounter());
            rCounterCriterions.add(new RCounter());
        }

        // Approving RCounters with Paths
        k = 0;
        for (RCounter criterion : rCounterCriterions) {
            rCounterList.get(0).approve(criterion, rCounterPaths.get(k++));
        }
        rCounterList.get(1).approve(rCounterCriterions.get(0), rCounterPaths.get(0));
        rCounterList.get(1).approve(rCounterCriterions.get(1), rCounterPaths.get(1));
        rCounterList.get(2).approve(rCounterCriterions.get(2), rCounterPaths.get(2));

        // Adding RCounters and Criterions to ApSet

        for (RCounter c : rCounterList) {
            apRCounter.add(c);
        }
        for (RCounter criterion : rCounterCriterions) {
            apRCounter.addCriterion(criterion);
        }


        //Filling apSpaceString, apInteriorString, apExteriorString

        // Create LinkedLists for Space, Interior, and Exterior elements
        LinkedList<Space<String>> spaces = new LinkedList<>();
        spaces.add(new Space<>("Garden"));
        spaces.add(new Space<>("Garage"));
        spaces.add(new Space<>("Storage Room"));

        LinkedList<Interior<String>> interiors = new LinkedList<>();
        interiors.add(new Interior<>("Living Room", 25.5));
        interiors.add(new Interior<>("Bedroom", 20.0));
        interiors.add(new Interior<>("Kitchen", 15.0));

        LinkedList<Exterior<String>> exteriors = new LinkedList<>();
        exteriors.add(new Exterior<>("Playground", true));
        exteriors.add(new Exterior<>("Parking Lot", false));
        exteriors.add(new Exterior<>("Pool", true));

        // Create paths for Space, Interior, and Exterior
        LinkedList<Path<Space<String>>> spacePaths = new LinkedList<>();
        for (Space<String> space : spaces) {
            Path<Space<String>> path = new Path<>();
            path.add(space);
            spacePaths.add(path);
        }

        LinkedList<Path<Space<String>>> interiorPaths = new LinkedList<>();
        for (Interior<String> interior : interiors) {
            Path<Space<String>> path = new Path<>();
            path.add(interior);
            interiorPaths.add(path);
        }

        LinkedList<Path<Space<String>>> exteriorPaths = new LinkedList<>();
        for (Exterior<String> exterior : exteriors) {
            Path<Space<String>> path = new Path<>();
            path.add(exterior);
            exteriorPaths.add(path);
        }

        // Approve paths for Spaces
        k = 0;
        for (Space<String> space : spaces) {
            space.approve("Criteria " + k, spacePaths.get(k));
            apSpaceString.add(space);
            k++;
        }


        // Approve paths for Interiors
        k = 0;
        for (Interior<String> interior : interiors) {
            interior.approve("Interior Criteria " + k, interiorPaths.get(k));
            apInteriorString.add(interior);
            k++;
        }

        // Approve paths for Exteriors
        k = 0;
        for (Exterior<String> exterior : exteriors) {
            exterior.approve("Exterior Criteria " + k, exteriorPaths.get(k));
            apExteriorString.add(exterior);
            k++;
        }




        //copying from apRCounter to adminRCounter

        Iterator<RCounter> iterator = apRCounter.iteratorAll();
        while(iterator.hasNext()){
            adminRCounter.add(iterator.next());
        }
        Iterator<RCounter> criterions = apRCounter.criterions();
        while(criterions.hasNext()){
            adminRCounter.addCriterion(criterions.next());
        }


        //copying from the apsets with Space, Interior and Exterior to the corresponding adminsets

        Iterator<Space<String>> iteratorSpace = apSpaceString.iteratorAll();
        while(iteratorSpace.hasNext()){
            adminSpaceString.add(iteratorSpace.next());
        }
        Iterator<String> criterionsSpace = apSpaceString.criterions();
        while(criterionsSpace.hasNext()){
            adminSpaceString.addCriterion(criterionsSpace.next());
        }

        Iterator<Interior<String>> iteratorInterior = apInteriorString.iteratorAll();
        while(iteratorInterior.hasNext()){
            adminInteriorString.add(iteratorInterior.next());
        }
        Iterator<String> criterionsInterior = apInteriorString.criterions();
        while(criterionsInterior.hasNext()){
            adminInteriorString.addCriterion(criterionsInterior.next());
        }

        Iterator<Exterior<String>> iteratorExterior = apExteriorString.iteratorAll();
        while(iteratorExterior.hasNext()){
            adminExteriorString.add(iteratorExterior.next());
        }
        Iterator<String> criterionsExterior = apExteriorString.criterions();
        while(criterionsExterior.hasNext()){
            adminExteriorString.addCriterion(criterionsExterior.next());
        }


        // Test 1: Verify all entries in adminSpaceString
        int expectedSize = 3; // Garden, Garage, Storage Room
        assertEqual("Test 1: Verify adminSpaceString initial size", expectedSize, countElements(adminSpaceString.iteratorAll()));

        // Test 2: Remove 'Garage' and verify size
        Iterator<Space<String>> iterator1 = adminSpaceString.iterator();
        while (iterator1.hasNext()) {
            Space<String> space = iterator1.next();
            if (space.toString().equals("Garage")) {
                iterator1.remove();
                break;
            }
        }
        expectedSize = 2; // After removing Garage
        assertEqual("Test 2: Verify size after removing Garage", expectedSize, countElements(adminSpaceString.iteratorAll()));

        // Test 3: Reinsert 'Garage' and verify size
        Space<String> garage = new Space<>("Garage");
        adminSpaceString.add(garage);
        expectedSize = 3; // After reinserting Garage
        assertEqual("Test 3: Verify size after reinserting Garage", expectedSize, countElements(adminSpaceString.iteratorAll()));

        // Test 4: Approve a path for 'Garage' and verify
        Path<Space<String>> garagePath = new Path<>();
        garagePath.add(garage);
        garage.approve("Garage Approval", garagePath);
        boolean garageApproved = garage.approved("Garage Approval") != null;
        assertEqual("Test 4: Verify Garage approval", true, garageApproved);

        // Test 5: Verify all elements in adminSpaceString after processing
        LinkedList<String> expectedEntries = new LinkedList<>();
        expectedEntries.add("Garage");
        expectedEntries.add("Garden");
        expectedEntries.add("Storage Room");

        LinkedList<String> actualEntries = new LinkedList<>();
        Iterator<Space<String>> finalIterator = adminSpaceString.iteratorAll();
        while (finalIterator.hasNext()) {
            actualEntries.add(finalIterator.next().toString());
        }
        assertEqual("Test 5: Verify adminSpaceString contents after processing", expectedEntries, actualEntries);


        System.out.println();


        // Adding entries from AdminSet<Interior<String>, ...> to AdminSet<Space<String>, ...>
        Iterator<Interior<String>> interiorIterator = adminInteriorString.iterator();
        while (interiorIterator.hasNext()) {
            Interior<String> interior = interiorIterator.next();
            System.out.println("Processing Interior: " + interior);

            // Call `area()` or `isPublic()` based on the type and add to `adminSpaceString`
            if (interior.area() > 20) { // Example condition based on `area()`
                adminSpaceString.add(interior);
            }
        }

        // Adding entries from AdminSet<Exterior<String>, ...> to AdminSet<Space<String>, ...>
        Iterator<Exterior<String>> exteriorIterator = adminExteriorString.iterator();
        while (exteriorIterator.hasNext()) {
            Exterior<String> exterior = exteriorIterator.next();
            System.out.println("Processing Exterior: " + exterior);

            // Call `!isPublic()` and add to `adminSpaceString` if private
            if (!exterior.isPublic()) {
                adminSpaceString.add(exterior);
            }
        }

        // Output the result
        System.out.println("\nEntries in adminSpaceString after processing:");
        Iterator<Space<String>> spaceIterator = adminSpaceString.iterator();
        while (spaceIterator.hasNext()) {
            System.out.println(spaceIterator.next());
        }


        // Remove an element from adminSpaceString
        System.out.println("\nRemoving 'Garage' from adminSpaceString...");
        Iterator<Space<String>> iterator2 = adminSpaceString.iterator();
        while (iterator2.hasNext()) {
            Space<String> space = iterator2.next();
            if (space.toString().equals("Garage")) {
                iterator2.remove(); // Remove 'Garage'
                break;
            }
        }
        System.out.println("Contents of adminSpaceString after removal:");
        printSet(adminSpaceString);

        //Reinsert an element
        System.out.println("\nReinserting 'Garage' into adminSpaceString...");
        adminSpaceString.add(garage);
        System.out.println("Contents of adminSpaceString after reinsertion:");
        printSet(adminSpaceString);

        //  Validate other sets
        System.out.println("\nValidating adminInteriorString:");
        printSet(adminInteriorString);

        System.out.println("\nValidating adminExteriorString:");
        printSet(adminExteriorString);

        // Use additional methods (e.g., approve, iterator, etc.)
        System.out.println("\nApproving a path for 'Garage'...");
        garagePath.add(garage);
        garage.approve("Garage Approval", garagePath);

        System.out.println("Contents of adminSpaceString after approval:");
        printSet(adminSpaceString);
    }

    private static void assertEqual(String testName, Object expected, Object actual) {
        if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
            System.out.println(testName + ": Successful");
        } else {
            System.out.println(testName + ": Failed");
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + actual);
        }
    }

    private static int countElements(Iterator<?> iterator) {
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    private static <T extends Approvable<?, ?>> void printSet(AdminSet<T, ?, ?> set) {
        Iterator<T> iterator = set.iteratorAll();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
