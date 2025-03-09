package Aufgabe6;


import java.io.IOException;
import java.util.LinkedList;

/**
 * NOTE: Class to test the implemented methods
 * Responsibilities:
 *  - Yoana Angelova: Usable, Withwindows, Windowless, Unusable, Office, OfficeGen
 *  - Ivaylo Georgiev: Company, CompanyGen, CustomIterator, CustomIterable, Test
 *  - Simeon Obretenov: Builfing, BuildingGen, SinglyLinkedList, SinglyLinkedListGen
 */
public class Test {
    public static void main(String[] args) {
        String companies= "                                                                                      Company\n" +
                "Building A:\n" +
                "101:\n" +
                "OfficeRoom1: length 5.0 m, width 6.0 m, office space with 4 workstations and 3.0 m^2 window area\n" +
                "OfficeRoom2: length 7.0 m, width 8.0 m, office space with 5 workstations and 4.0 m^2 window area\n" +
                "OfficeRoom3: length 6.0 m, width 9.0 m, office space with 6 workstations and 5.0 m^2 window area\n" +
                "StorageRoom4: length 4.0 m, width 4.0 m, storage space with 11.0 m^2 storage area and 401 lm flux\n" +
                "StorageRoom5: length 5.0 m, width 5.0 m, storage space with 16.0 m^2 storage area and 501 lm flux\n" +
                "\n" +
                "UnusableRooms - 11.5\n" +
                "Total area of the office:181.0 m^2\n" +
                "\n" +
                "102:\n" +
                "OfficeRoom6: length 6.0 m, width 7.0 m, office space with 5 workstations and 4.0 m^2 window area\n" +
                "OfficeRoom7: length 8.0 m, width 9.0 m, office space with 6 workstations and 5.0 m^2 window area\n" +
                "OfficeRoom8: length 7.0 m, width 10.0 m, office space with 7 workstations and 6.0 m^2 window area\n" +
                "StorageRoom9: length 5.0 m, width 5.0 m, storage space with 12.0 m^2 storage area and 402 lm flux\n" +
                "StorageRoom10: length 6.0 m, width 6.0 m, storage space with 17.0 m^2 storage area and 502 lm flux\n" +
                "\n" +
                "UnusableRooms - 12.5\n" +
                "Total area of the office:245.0 m^2\n" +
                "\n" +
                "103:\n" +
                "OfficeRoom11: length 7.0 m, width 8.0 m, office space with 6 workstations and 5.0 m^2 window area\n" +
                "OfficeRoom12: length 9.0 m, width 10.0 m, office space with 7 workstations and 6.0 m^2 window area\n" +
                "OfficeRoom13: length 8.0 m, width 11.0 m, office space with 8 workstations and 7.0 m^2 window area\n" +
                "StorageRoom14: length 6.0 m, width 6.0 m, storage space with 13.0 m^2 storage area and 403 lm flux\n" +
                "StorageRoom15: length 7.0 m, width 7.0 m, storage space with 18.0 m^2 storage area and 503 lm flux\n" +
                "\n" +
                "UnusableRooms - 13.5\n" +
                "Total area of the office:319.0 m^2\n" +
                "\n" +
                "104:\n" +
                "OfficeRoom16: length 8.0 m, width 9.0 m, office space with 7 workstations and 6.0 m^2 window area\n" +
                "OfficeRoom17: length 10.0 m, width 11.0 m, office space with 8 workstations and 7.0 m^2 window area\n" +
                "OfficeRoom18: length 9.0 m, width 12.0 m, office space with 9 workstations and 8.0 m^2 window area\n" +
                "StorageRoom19: length 7.0 m, width 7.0 m, storage space with 14.0 m^2 storage area and 404 lm flux\n" +
                "StorageRoom20: length 8.0 m, width 8.0 m, storage space with 19.0 m^2 storage area and 504 lm flux\n" +
                "\n" +
                "UnusableRooms - 14.5\n" +
                "Total area of the office:403.0 m^2\n" +
                "\n" +
                "105:\n" +
                "OfficeRoom21: length 9.0 m, width 10.0 m, office space with 8 workstations and 7.0 m^2 window area\n" +
                "OfficeRoom22: length 11.0 m, width 12.0 m, office space with 9 workstations and 8.0 m^2 window area\n" +
                "OfficeRoom23: length 10.0 m, width 13.0 m, office space with 10 workstations and 9.0 m^2 window area\n" +
                "StorageRoom24: length 8.0 m, width 8.0 m, storage space with 15.0 m^2 storage area and 405 lm flux\n" +
                "StorageRoom25: length 9.0 m, width 9.0 m, storage space with 20.0 m^2 storage area and 505 lm flux\n" +
                "\n" +
                "UnusableRooms - 15.5\n" +
                "Total area of the office:497.0 m^2\n" +
                "\n" +
                "\n" +
                "\n" +
                "Building B:\n" +
                "201:\n" +
                "OfficeRoom26: length 5.0 m, width 6.0 m, office space with 4 workstations and 3.0 m^2 window area\n" +
                "OfficeRoom27: length 7.0 m, width 8.0 m, office space with 5 workstations and 4.0 m^2 window area\n" +
                "OfficeRoom28: length 6.0 m, width 9.0 m, office space with 6 workstations and 5.0 m^2 window area\n" +
                "StorageRoom29: length 4.0 m, width 4.0 m, storage space with 11.0 m^2 storage area and 401 lm flux\n" +
                "StorageRoom30: length 5.0 m, width 5.0 m, storage space with 16.0 m^2 storage area and 501 lm flux\n" +
                "\n" +
                "UnusableRooms - 11.5\n" +
                "Total area of the office:181.0 m^2\n" +
                "\n" +
                "202:\n" +
                "OfficeRoom31: length 6.0 m, width 7.0 m, office space with 5 workstations and 4.0 m^2 window area\n" +
                "OfficeRoom32: length 8.0 m, width 9.0 m, office space with 6 workstations and 5.0 m^2 window area\n" +
                "OfficeRoom33: length 7.0 m, width 10.0 m, office space with 7 workstations and 6.0 m^2 window area\n" +
                "StorageRoom34: length 5.0 m, width 5.0 m, storage space with 12.0 m^2 storage area and 402 lm flux\n" +
                "StorageRoom35: length 6.0 m, width 6.0 m, storage space with 17.0 m^2 storage area and 502 lm flux\n" +
                "\n" +
                "UnusableRooms - 12.5\n" +
                "Total area of the office:245.0 m^2\n" +
                "\n" +
                "203:\n" +
                "OfficeRoom36: length 7.0 m, width 8.0 m, office space with 6 workstations and 5.0 m^2 window area\n" +
                "OfficeRoom37: length 9.0 m, width 10.0 m, office space with 7 workstations and 6.0 m^2 window area\n" +
                "OfficeRoom38: length 8.0 m, width 11.0 m, office space with 8 workstations and 7.0 m^2 window area\n" +
                "StorageRoom39: length 6.0 m, width 6.0 m, storage space with 13.0 m^2 storage area and 403 lm flux\n" +
                "StorageRoom40: length 7.0 m, width 7.0 m, storage space with 18.0 m^2 storage area and 503 lm flux\n" +
                "\n" +
                "UnusableRooms - 13.5\n" +
                "Total area of the office:319.0 m^2\n" +
                "\n" +
                "204:\n" +
                "OfficeRoom41: length 8.0 m, width 9.0 m, office space with 7 workstations and 6.0 m^2 window area\n" +
                "OfficeRoom42: length 10.0 m, width 11.0 m, office space with 8 workstations and 7.0 m^2 window area\n" +
                "OfficeRoom43: length 9.0 m, width 12.0 m, office space with 9 workstations and 8.0 m^2 window area\n" +
                "StorageRoom44: length 7.0 m, width 7.0 m, storage space with 14.0 m^2 storage area and 404 lm flux\n" +
                "StorageRoom45: length 8.0 m, width 8.0 m, storage space with 19.0 m^2 storage area and 504 lm flux\n" +
                "\n" +
                "UnusableRooms - 14.5\n" +
                "Total area of the office:403.0 m^2\n" +
                "\n" +
                "205:\n" +
                "OfficeRoom46: length 9.0 m, width 10.0 m, office space with 8 workstations and 7.0 m^2 window area\n" +
                "OfficeRoom47: length 11.0 m, width 12.0 m, office space with 9 workstations and 8.0 m^2 window area\n" +
                "OfficeRoom48: length 10.0 m, width 13.0 m, office space with 10 workstations and 9.0 m^2 window area\n" +
                "StorageRoom49: length 8.0 m, width 8.0 m, storage space with 15.0 m^2 storage area and 405 lm flux\n" +
                "StorageRoom50: length 9.0 m, width 9.0 m, storage space with 20.0 m^2 storage area and 505 lm flux\n" +
                "\n" +
                "UnusableRooms - 15.5\n" +
                "Total area of the office:497.0 m^2\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";

        //Non-Generic
        Company company = new Company();

        Building building1 = new Building("Building A");
        Building building2 = new Building("Building B");

        int roomCounter = 1;
        for (int i = 1; i <= 2; i++) {
            Building building = (i == 1) ? building1 : building2;
            for (int j = 1; j <= 5; j++) { // Five offices per building
                SinglyLinkedList usableRooms = new SinglyLinkedList();


                usableRooms.addLast(new WithWindows("OfficeRoom" + roomCounter++, 4 + j, 5 + j, true, 3 + j, 2.0 + j));
                usableRooms.addLast(new WithWindows("OfficeRoom" + roomCounter++, 6 + j, 7 + j, true, 4 + j, 3.0 + j));
                usableRooms.addLast(new WithWindows("OfficeRoom" + roomCounter++, 5 + j, 8 + j, true, 5 + j, 4.0 + j));


                usableRooms.addLast(new Windowless("StorageRoom" + roomCounter++, 3 + j, 3 + j, false, 10.0 + j, 400 + j));
                usableRooms.addLast(new Windowless("StorageRoom" + roomCounter++, 4 + j, 4 + j, false, 15.0 + j, 500 + j));


                Unusable unusableRoom = new Unusable(10.5 + j);


                Office office = new Office(usableRooms, j+i*100, unusableRoom);
                building.addOfficeUnit(office);
            }
            company.addBuilding(building);
        }

        //Generic
        CompanyGen<Usable, Unusable> companyGen = new CompanyGen<>();

        BuildingGen<Usable, Unusable> buildingGen1 = new BuildingGen<>("Building A");
        BuildingGen<Usable, Unusable> buildingGen2 = new BuildingGen<>("Building B");

        int roomGenCounter = 1;
        for (int i = 1; i <= 2; i++) {
            BuildingGen<Usable, Unusable> buildingGen = (i == 1) ? buildingGen1 : buildingGen2;
            for (int j = 1; j <= 5; j++) { // Five offices per building
                SinglyLinkedListGen<Usable> usableRoomsGen = new SinglyLinkedListGen<>();


                usableRoomsGen.addLast(new WithWindows("OfficeRoom" + roomGenCounter++, 4 + j, 5 + j, true, 3 + j, 2.0 + j));
                usableRoomsGen.addLast(new WithWindows("OfficeRoom" + roomGenCounter++, 6 + j, 7 + j, true, 4 + j, 3.0 + j));
                usableRoomsGen.addLast(new WithWindows("OfficeRoom" + roomGenCounter++, 5 + j, 8 + j, true, 5 + j, 4.0 + j));


                usableRoomsGen.addLast(new Windowless("StorageRoom" + roomGenCounter++, 3 + j, 3 + j, false, 10.0 + j, 400 + j));
                usableRoomsGen.addLast(new Windowless("StorageRoom" + roomGenCounter++, 4 + j, 4 + j, false, 15.0 + j, 500 + j));


                Unusable unusableRoom = new Unusable(10.5 + j);


                OfficeGen<Usable, Unusable> officeGen = new OfficeGen<>(usableRoomsGen, j+i*100, unusableRoom);
                buildingGen.addOfficeUnit(officeGen);
            }
            companyGen.addBuilding(buildingGen);
        }

        LinkedList<OfficeGen<Usable, Unusable>> newOfficesGen = new LinkedList<>();

        //Test case
        System.out.print("Test 1 - Comparing Strings: ");
        testCompanyEquality(company,companyGen,companies);

        // Non-Generic
        Office[] newOffices = new Office[6];
        newOffices[0] = createNewOffice(106, 3);
        newOffices[1] = createNewOffice(107, 3);
        newOffices[2] = createNewOffice(108, 3);
        for (int i = 0; i < 3; i++) {
            building1.addOfficeUnit(newOffices[i]);
        }

        newOffices[3] = createNewOffice(206, 3);
        newOffices[4] = createNewOffice(207, 3);
        newOffices[5] = createNewOffice(208, 3);
        for (int i = 3; i < 6; i++) {
            building2.addOfficeUnit(newOffices[i]);
        }

        //Generic
        newOfficesGen.addLast(createNewOfficeGen(106, 3));
        newOfficesGen.addLast(createNewOfficeGen(107, 3));
        newOfficesGen.addLast(createNewOfficeGen(108, 3));
        for (int i = 0; i < 3; i++) {
            buildingGen1.addOfficeUnit(newOfficesGen.get(i));
        }


        newOfficesGen.addLast(createNewOfficeGen(206, 3));
        newOfficesGen.addLast(createNewOfficeGen(207, 3));
        newOfficesGen.addLast(createNewOfficeGen(208, 3));
        for (int i = 3; i < 6; i++) {
            buildingGen2.addOfficeUnit(newOfficesGen.get(i));
        }

        //Test Case
        System.out.print("\nTest 2 - Adding offices into buildings: ");
        testOfficeCount(building1,building2,buildingGen1,buildingGen2,8);

        // Non-Generic
        building1.removeOfficeUnit(newOffices[1]);
        building1.removeOfficeUnit(newOffices[2]);
        building2.removeOfficeUnit(newOffices[4]);
        building2.removeOfficeUnit(newOffices[5]);

        // Generic
        buildingGen1.removeOfficeUnit(newOfficesGen.get(1));
        buildingGen1.removeOfficeUnit(newOfficesGen.get(2));
        buildingGen2.removeOfficeUnit(newOfficesGen.get(4));
        buildingGen2.removeOfficeUnit(newOfficesGen.get(5));

        // Test case
        System.out.print("\nTest 3 - Removing offices from buildings: ");
        testOfficeCount(building1, building2, buildingGen1, buildingGen2, 6);

        //Non-Generic
        Office office106 = newOffices[0];
        Office office206 = newOffices[3];
        WithWindows officeRoomNew1 = new WithWindows("OfficeRoomNew1", 10.0, 12.0, true, 5, 4.0);
        WithWindows officeRoomNew2 = new WithWindows("OfficeRoomNew2", 11.0, 13.0, true, 6, 5.0);
        Windowless storageRoomNew1 = new Windowless("StorageRoomNew1", 8.0, 10.0, false, 20.0, 600);

        Windowless storageRoomNew2 = new Windowless("StorageRoomNew2", 9.0, 11.0, false, 25.0, 700);
        Windowless storageRoomNew3 = new Windowless("StorageRoomNew3", 10.0, 12.0, false, 30.0, 800);
        WithWindows officeRoomNew3 = new WithWindows("OfficeRoomNew3", 12.0, 14.0, true, 7, 6.0);

        office106.addRoom(officeRoomNew1);
        office106.addRoom(officeRoomNew2);
        office106.addRoom(storageRoomNew1);

        office206.addRoom(storageRoomNew2);
        office206.addRoom(storageRoomNew3);
        office206.addRoom(officeRoomNew3);

        //Finding Office 101
        Office officeA = null;
        for (Object obj : building1) {
            Office office = (Office) obj;
            if (office.getNumber() == 101) {
                officeA = office;
                break;
            }
        }

        // Find Office 201 in Building B
        Office officeB = null;
        for (Object obj : building2) {
            Office office = (Office) obj;
            if (office.getNumber() == 201) {
                officeB = office;
                break;
            }
        }

        // Remove 2 rooms from Building A (office 101)
        Usable removedRoomA1;
        Usable removedRoomA2=null;
        int countA = 0;
        assert officeA != null;
        for (Object room : officeA) {
            if (countA == 0) {
                removedRoomA1 = (Usable)room;
                officeA.removeRoom(removedRoomA1);
                countA++;
            } else if (countA == 1) {
                removedRoomA2 = (Usable)room;
                officeA.removeRoom(removedRoomA2);
                break;
            }
        }

        // Remove 1 room from Building B (office 201)
        Usable removedRoomB;
        assert officeB != null;
        for (Object room : officeB) {
            removedRoomB = (Usable) room;
            officeB.removeRoom(removedRoomB);
            break;
        }


        //Generic
        OfficeGen<Usable, Unusable> officeGen106 = newOfficesGen.get(0);
        officeGen106.addRoom(officeRoomNew1);
        officeGen106.addRoom(officeRoomNew2);
        officeGen106.addRoom(storageRoomNew1);
        OfficeGen<Usable, Unusable> officeGen206 = newOfficesGen.get(3);
        officeGen206.addRoom(storageRoomNew2);
        officeGen206.addRoom(storageRoomNew3);
        officeGen206.addRoom(officeRoomNew3);

        // Find OfficeGen 101 in BuildingGen A
        OfficeGen<Usable, Unusable> officeGenA = null;
        for (OfficeGen<Usable, Unusable> officeGen : buildingGen1) { // Assuming BuildingGen implements Iterable
            if (officeGen.getNumber() == 101) { // Assuming getNumber() exists in OfficeGen
                officeGenA = officeGen;
                break;
            }
        }

        // Find OfficeGen 201 in BuildingGen B
        OfficeGen<Usable, Unusable> officeGenB = null;
        for (OfficeGen<Usable, Unusable> officeGen : buildingGen2) {
            if (officeGen.getNumber() == 201) {
                officeGenB = officeGen;
                break;
            }
        }

        // Remove 2 rooms from OfficeGen 101
        Usable removedRoomGenA1;
        Usable removedRoomGenA2;
        int countGenA = 0;
        assert officeGenA != null;
        for (Usable room : officeGenA) {
            if (countGenA == 0) {
                removedRoomGenA1 = room;
                officeGenA.removeRoom(room);
                countGenA++;
            } else if (countGenA == 1) {
                removedRoomGenA2 = room;
                officeGenA.removeRoom(room);
                break;
            }
        }

        // Remove 1 room from OfficeGen 201
        Usable removedRoomGenB = null;
        assert officeGenB != null;
        for (Usable room : officeGenB) {
            removedRoomGenB = room;
            officeGenB.removeRoom(room);
            break;
        }

        //Test case
        System.out.print("\nTest 4 - Object added: ");
        testRoomPresence(office106,storageRoomNew1,true);
        System.out.print("Test 4 - Object added: ");
        testRoomPresence(officeGen106,storageRoomNew1,true);
        System.out.print("Test 4 - Object removed: ");
        testRoomPresence(officeA,removedRoomA2,false);
        System.out.print("Test 4 - Object removed: ");
        testRoomPresence(officeGenA,removedRoomA2,false);
        System.out.println();
        System.out.print("Test 5 - Before changing usability: ");
        testRoomTypeCount(office106, 5,1);
        System.out.print("Test 5 - Before changing usability: ");
        testRoomTypeCount(office206, 4,2);

        //Non-Generic and Generic
        // Change OfficeRoomNew1 and OfficeRoomNew2 to storage rooms

        officeRoomNew1.change(25.0); // Set storage space
        officeRoomNew2.change(30.2); // Set storage space

        // Change StorageRoomNew3 to an office room
        storageRoomNew3.change(8); // Set workstations


        //Test Case
        System.out.print("Test 5 - After changing usability: ");
        testRoomTypeCount(office106, 3,3);
        System.out.print("Test 5 - After changing usability: ");
        testRoomTypeCount(office206, 5,1);

        //Non-Generic and Generic
        Office empty = new Office(new SinglyLinkedList(),1000,null);
        OfficeGen<Usable,Unusable> emptyGen = new OfficeGen<>(new SinglyLinkedListGen<>(),1000,null);
        try{
            System.out.print("\nTest 6 - Testing Division with 0: ");
            System.out.println(empty.calculateAverageAreaWindowless());
        }catch (ArithmeticException e){
            System.out.println("Successful test");
        }
        try{
            System.out.print("Test 6 - Testing Division with 0: ");
            System.out.println(emptyGen.calculateAverageAreaWindowless());
        }catch (ArithmeticException e){
            System.out.println("Successful test");
        }

        //Non-Generic
        //display the statistical values on the screen
        System.out.println(company);
        System.out.println("Test 7 - display the statistical values on the screen (non-generic use)");
        for (CustomIterator buildingIterator = company.iterator(); buildingIterator.hasNext(); ) {
            Building building = (Building) buildingIterator.next();

            for (CustomIterator officeIterator = building.iterator(); officeIterator.hasNext(); ) {
                Office office = (Office) officeIterator.next();
                System.out.println("Office " + office.getNumber() + ":");

                System.out.println("Total Area: " + office.calculateArea() + " m^2");
                System.out.println("Average Area: " + office.calculateAverageArea() + " m^2");

                try {
                    System.out.println("Average Area (With Windows): " + office.calculateAverageAreaWithWindows() + " m^2");
                } catch (ArithmeticException e) {
                    System.out.println("Average Area (With Windows): No rooms with windows.");
                }

                try {
                    System.out.println("Average Area (Windowless): " + office.calculateAverageAreaWindowless() + " m^2");
                } catch (ArithmeticException e) {
                    System.out.println("Average Area (Windowless): No windowless rooms.");
                }

                try {
                    System.out.println("Average Storage Capacity: " + office.calculateAverageStorage() + " m^3");
                } catch (ArithmeticException e) {
                    System.out.println("Average Storage Capacity: No storage rooms.");
                }

                try {
                    System.out.println("Average Workstations: " + office.calculateAverageWorkstations());
                } catch (ArithmeticException e) {
                    System.out.println("Average Workstations: No office rooms.");
                }

                try {
                    System.out.println("Average Window-to-Area Ratio: " + office.calculateAverageWindowToAreaRatio());
                } catch (ArithmeticException e) {
                    System.out.println("Average Window-to-Area Ratio: No rooms with windows.");
                }

                try {
                    System.out.println("Average Flux-to-Area Ratio: " + office.calculateAverageFluxToAreaRatio());
                } catch (ArithmeticException e) {
                    System.out.println("Average Flux-to-Area Ratio: No windowless rooms.");
                }
                System.out.println();
            }
        }

        //Generic
        //display the statistical values on the screen
        System.out.println(companyGen);
        System.out.println("Test 7 - display the statistical values on the screen (generic use)");
        for (BuildingGen<Usable, Unusable> building : companyGen) {
            for (OfficeGen<Usable, Unusable> office : building) {
                System.out.println("Office " + office.getNumber() + ":");
                System.out.println("Total Area: " + office.calculateArea() + " m^2");
                System.out.println("Average Area: " + office.calculateAverageArea() + " m^2");

                try {
                    System.out.println("Average Area (With Windows): " + office.calculateAverageAreaWithWindows() + " m^2");
                } catch (ArithmeticException e) {
                    System.out.println("Average Area (With Windows): No rooms with windows.");
                }

                try {
                    System.out.println("Average Area (Windowless): " + office.calculateAverageAreaWindowless() + " m^2");
                } catch (ArithmeticException e) {
                    System.out.println("Average Area (Windowless): No windowless rooms.");
                }

                try {
                    System.out.println("Average Storage Capacity: " + office.calculateAverageStorage() + " m^3");
                } catch (ArithmeticException e) {
                    System.out.println("Average Storage Capacity: No storage rooms.");
                }

                try {
                    System.out.println("Average Workstations: " + office.calculateAverageWorkstations());
                } catch (ArithmeticException e) {
                    System.out.println("Average Workstations: No office rooms.");
                }

                try {
                    System.out.println("Average Window-to-Area Ratio: " + office.calculateAverageWindowToAreaRatio());
                } catch (ArithmeticException e) {
                    System.out.println("Average Window-to-Area Ratio: No rooms with windows.");
                }

                try {
                    System.out.println("Average Flux-to-Area Ratio: " + office.calculateAverageFluxToAreaRatio());
                } catch (ArithmeticException e) {
                    System.out.println("Average Flux-to-Area Ratio: No windowless rooms.");
                }

                System.out.println();
            }
        }

    }
    private static void testCompanyEquality(Company company, CompanyGen<Usable, Unusable> companyGen, String c) {
        // Convert both toString() results to strings
        String nonGenericResult = company.toString();
        String genericResult = companyGen.toString();

        // Check if both match the expected value
        if (nonGenericResult.equals(c) && genericResult.equals(c)) {
            System.out.println("Successful test");
        } else {
            // If the test fails, show the expected and actual values
            System.out.println("Test failed!");
            System.out.println("Expected: " + c);
            System.out.println("Non-Generic Result: " + nonGenericResult);
            System.out.println("Generic Result: " + genericResult);
        }
    }

    private static Office createNewOffice(int number, int roomCount) {
        SinglyLinkedList usableRooms = new SinglyLinkedList();
        float baseNumber = number * 10;

        for (int i = 1; i <= roomCount; i++) {
            usableRooms.addLast(new Windowless(
                    "OfficeRoom" + (int)(baseNumber + i), // Unique name
                    4.5 + i, // Length
                    5.5 + i, // Width
                    true, // Office flag
                    3 + i, // Workstations/Storage value
                    300 + i // Flux
            ));
        }

        Unusable unusableRoom = new Unusable(15.5f + roomCount); // Float area
        return new Office(usableRooms, number, unusableRoom);
    }

    private static OfficeGen<Usable, Unusable> createNewOfficeGen(int number, int roomCount) {
        SinglyLinkedListGen<Usable> usableRoomsGen = new SinglyLinkedListGen<>();
        float baseNumber = number * 10;

        for (int i = 1; i <= roomCount; i++) {
            usableRoomsGen.addLast(new Windowless(
                    "OfficeRoom" + (int)(baseNumber + i), // Unique name
                    4.5 + i, // Length
                    5.5 + i, // Width
                    true, // Office flag
                    3 + i, // Workstations/Storage value
                    300 + i // Flux
            ));
        }

        Unusable unusableRoom = new Unusable(15.5f + roomCount); // Float area
        return new OfficeGen<>(usableRoomsGen, number, unusableRoom);
    }

    private static int countOffices(Building building) {
        int count = 0;
        for (Object room : building) { // Assuming Building implements Iterable for offices
            count++;
        }
        return count;
    }

    private static int countOffices(BuildingGen<Usable, Unusable> buildingGen) {
        int count = 0;
        for (OfficeGen<Usable, Unusable> ignored : buildingGen) {
            count++;
        }
        return count;
    }

    private static void testOfficeCount(Building buildingA, Building buildingB,
                                        BuildingGen<Usable, Unusable> buildingGenA,
                                        BuildingGen<Usable, Unusable> buildingGenB, int n) {

        boolean nonGenericA = countOffices(buildingA) == n;
        boolean nonGenericB = countOffices(buildingB) == n;

        if (!(nonGenericA && nonGenericB)) {
            System.out.println("Non-Generic Test Failed!");
            System.out.println("Building A has " + countOffices(buildingA) + " offices.");
            System.out.println("Building B has " + countOffices(buildingB) + " offices.");
            return;
        }

        boolean genericA = countOffices(buildingGenA) == n;
        boolean genericB = countOffices(buildingGenB) == n;

        if (!(genericA && genericB)) {
            System.out.println("Generic Test Failed!");
            System.out.println("BuildingGen A has " + countOffices(buildingGenA) + " offices.");
            System.out.println("BuildingGen B has " + countOffices(buildingGenB) + " offices.");
            return;
        }

        System.out.println("Successful test");


    }
    private static void testRoomPresence(Office office, Object room, boolean presentCheck) {
        boolean checker=false;
        for (Object r : office) {
            if (r==room) {
                checker= true;
            }
        }
        if(presentCheck){
            if (!checker) {
                System.out.println("Test Failed: Room is not present.");
            } else {
                System.out.println("Successful test");
            }
        }else{
            if (checker) {
                System.out.println("Test Failed: Room is present.");
            } else {
                System.out.println("Successful test");
            }
        }

    }

    private static void testRoomPresence(OfficeGen<Usable, Unusable> officeGen, Usable room, boolean presentCheck) {
        boolean checker=false;
        for (Usable r : officeGen) {
            if (r==room) {
                checker= true;
            }
        }
        if(presentCheck){
            if (!checker) {
                System.out.println("Test Failed: Room is not present.");
            } else {
                System.out.println("Successful test");
            }
        }else{
            if (checker) {
                System.out.println("Test Failed: Room is present.");
            } else {
                System.out.println("Successful test");
            }
        }
    }
    private static void testRoomTypeCount(Office office, int expectedOfficeRooms, int expectedStorages) {
        int officeRoomCount = 0;
        int storageRoomCount = 0;

        for (Object room : office) { // Iterate through the rooms in the office
            if (((Usable) room).getStorage()==0) { // Office rooms
                officeRoomCount++;
            } else { // Storage rooms
                storageRoomCount++;
            }
        }


        if (officeRoomCount == expectedOfficeRooms && storageRoomCount == expectedStorages) {
            System.out.println("Successful Test");
        } else {
            System.out.println("Test Failed!");
            System.out.println("Expected Office Rooms: " + expectedOfficeRooms + ", Found: " + officeRoomCount);
            System.out.println("Expected Storages: " + expectedStorages + ", Found: " + storageRoomCount);
        }
    }


}

