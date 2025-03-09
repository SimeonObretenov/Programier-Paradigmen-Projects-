package Aufgabe7;

import java.util.*;
/**
 * Responsibilities:
 *  - Yoana Angelova: HighTempPump, LargeHighTempPump, MidHighTempPump, SmallHighTempPump,
 *      LowTempPump, LargeLowTempPump, MidLowTempPump, SmallLowTempPump, Documentation, Test
 *  - Ivaylo Georgiev: Pump, OfficeOperator, Test
 *  - Simeon Obretenov: Office, UnderfloorHeatingOffice, LargeUnderfloorOffice, MidUnderfloorOffice, SmallUnderfloorOffice,
 *      RadiatorHeatingOffice, LargeRadiatorOffice, MidRadiatorOffice, SmallRadiatorOffice
 */
@Documentation(description = "Class to test the implemented methods",
    responsible = "Ivaylo Georgiev")
public class Test {
    public static void main(String[] args) {

        LinkedList<Office> offices1 = new LinkedList<>();
        offices1.add(new SmallUnderfloorOffice("Small Underfloor 11"));
        offices1.add(new SmallUnderfloorOffice("Small Underfloor 12"));
        offices1.add(new MidUnderfloorOffice("Mid Underfloor 11"));
        offices1.add(new MidUnderfloorOffice("Mid Underfloor 12"));
        offices1.add(new LargeUnderfloorOffice("Large Underfloor 11"));
        offices1.add(new LargeUnderfloorOffice("Large Underfloor 12"));
        offices1.add(new SmallRadiatorOffice("Small Radiator 11"));
        offices1.add(new SmallRadiatorOffice("Small Radiator 12"));
        offices1.add(new MidRadiatorOffice("Mid Radiator 11"));
        offices1.add(new MidRadiatorOffice("Mid Radiator 12"));
        offices1.add(new LargeRadiatorOffice("Large Radiator 11"));
        offices1.add(new LargeRadiatorOffice("Large Radiator 12"));



        LinkedList<Office> offices = new LinkedList<>();
        offices.add(new MidUnderfloorOffice("gosho"));
        offices.add(new SmallRadiatorOffice("petko"));
        offices.add(new LargeRadiatorOffice("moni"));


        OfficeOperator o = new OfficeOperator(offices1);
        System.out.println(o.showOffices());
    }

    public static void testEquals(Object given, Object expected) {
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }

    public static void testEquals(Object first, Object second, boolean expected) {
        if (first.equals(second) == expected) {
            System.out.println("Successful test");
        } else {
            if (expected) {
                System.out.println("Test NOT successful! " + first.toString() +
                        " must be equal to " + second.toString());
            } else {
                System.out.println("Test NOT successful! " + first.toString() +
                        " must not be equal to " + second.toString());
            }
        }
    }

}
