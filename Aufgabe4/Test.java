package Aufgabe4;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * NOTE: Class to test the implemented methods
 * Responsibilities:
 *  - Yoana Angelova: Entity, Building, Complex, Ensemble, Test
 *  - Ivaylo Georgiev: Escape, Space, PublicRoad, Circulation, PureCirculation, Test
 *  - Simeon Obretenov: Exterior, Interior, Lift, Room, ServantSpace, ServedSpace, Test
 *
 * Class hierarchy: why a class (or interface) is not in relationship to another class (or interface)
 * Escape:
 *  - It represents an escape root. It is not associated with a particular type of space or entity
 * Entity:
 *  - Space and its subtypes: “Objekte von Entity können nicht vom Typ Space sein…”
 * - Escape: as in Escape
 * Building, Complex, Ensemble:
 *  - Space and its subtypes: as in Entity
 *  - Escape: as in Escape
 * Space:
 *  - Entity and its subtypes: as in Entity
 *  - Escape: as in Escape
 * PublicRoad:
 *  - Entity and its subtypes: as in Space
 *  - Interior and its subtypes, Exterior: it is a movement area
 *  - Circulation and its subtypes: it is an outside area
 *  - Escape: as in Escape
 * Circulation, PureCurculation:
 *  - Entity and its subtypes: as in Space
 *  - Exterior, PublicRoad: it is not an outside area
 *  - Interior: it is a movement area
 *  - Escape: as in Escape
 * Exterior:
 *  - Entity and its subtypes: as in Space
 *  - Interior and its subtype, Circulation and its subtypes: it is an outside area
 *  - PublicRoad: it is not a movement area
 *  - Escape: as in Escape
 * Interior:
 *  - Entity and its subtypes: as in Space
 *  - Exterior, PublicRoad: it is an area within the building
 *  - Circulation: it is not a movement area
 *  - Escape: as in Escape
 * Lift:
 *  - Entity and its subtypes, PublicRoad, Circulation and its subtypes, Exterior: as in Interior
 *  - Room and its subtypes: “Ein Aufzug ist ein (meist kleiner) Innenraum ohne öﬀenbare Fenster…”
 *  - Escape: as in Escape
 * Room:
 *  - Entity and its subtypes, PublicRoad, Circulation and its subtypes, Exterior: as in Interior
 *  - Lift: as in lift
 *  - Escape: as in Escape
 * ServantSpace:
 *  - Entity and its subtypes, PublicRoad, Circulation and its subtypes, Exterior, Lift: as in Room
 *  - ServedSpace: “Dienend sind Nebenräume, die nur auf die Erfüllung bestimmter Aufgaben und den
 *      kurzzeitigen Aufenthalt von Menschen ausgerichtet sind (WC, Technikraum, Treppenraum, ...),
 *      während bediente Räume für den längeren Aufenthalt von Menschen konzipiert sind (Wohnzimmer, Schlafzimmer, Büro, ...).“
 *  - Escape: as in Escape
 * ServedSpace:
 *  - Entity and its subtypes, PublicRoad, Circulation and its subtypes, Exterior, Lift: as in Room
 *  - ServantSpace: as in ServantSpace
 *  - Escape: as in Escape
 */




/** TestCases after some changes have to aligned in order to prevent getting unchecked Exceptions */
public class Test {
    public static void main(String[] args) {
        Space servant1 = new ServantSpace();
        Space servant2 = new ServantSpace(servant1);
        LinkedList<Space> list = new LinkedList<>();
        list.add(servant1); list.add(servant2);
        Space served1 = new ServedSpace(25, 300, 30, 20, 300, 10, 5,list);
        list.add(served1);
        Space served2 = new ServedSpace(40, 350, 15, 40, 350, 8, 3,list);
        list.add(new ServedSpace(55, 400, 20, 35, 300, 14, 12, list));
        Space[] buildingSpaces = {
                servant2,
                servant1,
                served1,
                served2,
                list.get(3),
                new Lift(),
                new Exterior(),
                new Exterior(),
                new Circulation(),
                new Circulation(),
                new Circulation(),
                new PureCirculation()
        };
        Space[] complexSpaces = {
                new PublicRoad(),
                new PublicRoad(),
                new PublicRoad(),
                new PublicRoad()
        };
        Entity[] buildings = {
                new Building(new Space[]{buildingSpaces[0], buildingSpaces[2], buildingSpaces[3], buildingSpaces[6], buildingSpaces[9]}),
                new Building(new Space[]{buildingSpaces[0], buildingSpaces[1], buildingSpaces[3], buildingSpaces[4], buildingSpaces[5],
                        buildingSpaces[6], buildingSpaces[7], buildingSpaces[10], buildingSpaces[12]})
        };
        Entity[] complexes = {
                new Complex(new Building[]{(Building) buildings[0], (Building) buildings[1],}, new Space[]{complexSpaces[1], complexSpaces[3]})
        };
        Entity ensemble = new Ensemble(new Entity[]{buildings[1], complexes[0]});

        System.out.println("Test 1: check entity relations:");
        testIdentity(buildings[0].getClass(), Building.class);
        testIdentity(complexes[0].getClass(), Complex.class);
        testIdentity(ensemble.getClass(), Ensemble.class);

        System.out.println("\nTest 2: remove/add spaces to a building:");
        buildings[1].remove(buildingSpaces[3]);
        System.out.println("Accessibility after remove:");
        testIdentity(buildingSpaces[3].isAccesible(), false);
        buildings[1].add(buildingSpaces[3]);
        System.out.println("Accessibility after adding it again:");
        testIdentity(buildingSpaces[3].isAccesible(), true);
        buildings[1].remove();
        System.out.println("Accessibility of the spaces after removing the building:");
        testIdentity(buildingSpaces[10].isAccesible(), false);
        buildings[1].makeAccessible();
        System.out.println("Accessibility of the spaces after adding the building again:");
        testIdentity(buildingSpaces[10].isAccesible(), true);

        System.out.println("\nTest 3: try removing/adding entities to a building:");
        buildings[0].remove(buildings[1]);
        buildings[0].add(complexes[0]);


        System.out.println("\nTest 4: get the spaces in a building:" + Arrays.toString(((Building) buildings[1]).spaces()));

        System.out.println("\nTest 5: remove/add buildings to a complex:");
        complexes[0].remove(buildings[0]);
        System.out.println("Accessibility of the building after remove:");
        testIdentity(buildings[0].isAccessible(), false);
        complexes[0].add(buildings[0]);
        System.out.println("Accessibility of the building after adding it again:");
        testIdentity(buildings[0].isAccessible(), true);

        System.out.println("\nTest 6: remove/add spaces to a complex:");
        complexes[0].remove();
        System.out.println("Accessibility of the spaces after removing the complex:");
        testIdentity(complexSpaces[3].isAccesible(), false);
        complexes[0].makeAccessible();
        System.out.println("Accessibility of the spaces after adding the complex again:");
        testIdentity(complexSpaces[3].isAccesible(), true);

        System.out.println("\nTest 7: get the buildings in a complex:" + Arrays.toString(((Complex)complexes[0]).buildings()));

        System.out.println("\nTest 8: try removing/adding spaces to a ensemble:");
        ensemble.remove(complexSpaces[3]);
        ensemble.add(complexSpaces[3]);

        System.out.println("\nTest 9: get the space in a ensemble: " + ((Ensemble)ensemble).space());

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
}
