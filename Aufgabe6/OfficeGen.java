package Aufgabe6;

import java.util.Iterator;

/**
 * Represents an office composed of unidentified room types.
 */
public class OfficeGen<X extends Usable, Y extends Unusable> implements Iterable<X>{
    private SinglyLinkedListGen<X> usableRooms;
    private int uniqueNumber;
    private Y unusableRooms;
    /**
     * Constructs a new OfficeGen instance.
     *
     * Design by Contract (DbC):
     * - Precondition: `number` must be a non-negative integer (including zero) representing the initial number of rooms.
     * - Precondition: `area` must be a non-negative double (including zero) representing the initial total area of the office.
     * - Postcondition: Creates an OfficeGen instance with no assigned rooms initially, using the provided `number` and `area` as placeholders or defaults.
     *
     * @param number the initial number of rooms in the office (can be zero)
     */
    public OfficeGen(SinglyLinkedListGen<X> list, int number, Y unusableRooms) {
        this.usableRooms = list;
        this.uniqueNumber = number;
        this.unusableRooms = unusableRooms;
    }

    /**
     * Gets the unique number this office unit.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the unique number this office unit as a positive integer.
     *
     * @return the unique number this office unit
     */
    public int getNumber() {
        return this.uniqueNumber;
    }

    /**
     * Reads out the areas of the adjoining rooms of this office
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the areas of the adjoining rooms of this office unit as a list.
     *
     * @return the areas of the adjoining rooms of this office
     */
    public double getAdjoiningRoomsArea() {
        return this.unusableRooms.getArea();
    }

    /**
     * Calculates and the area of the office.
     *
     * Design by Contract (DbC):
     * - Postcondition: returns the total area of the office
     *
     * @return the total area of the office
     */
    public double calculateArea() {
        double area = 0;
        for (int i = 0; i < this.usableRooms.size(); i++) {
            area += (this.usableRooms.get(i)).getLength() * (this.usableRooms.get(i)).getWidth();
        }
        return area;
    }

    /**
     * Adds a room to the office.
     *
     * Design by Contract (DbC):
     * - Precondition: Room must be non-null and of the correct type (`Usable` or `Unusable`).
     * - Postcondition: Increases the total number of rooms and updates the office's properties accordingly.
     */
    public void addRoom(X x) {
        this.usableRooms.addLast(x);
    }

    /**
     * Removes a room from the office.
     *
     * Design by Contract (DbC):
     * - Precondition: Room to be removed must exist in the office.
     * - Postcondition: Decreases the total number of rooms and updates the office's properties accordingly.
     */
    public void removeRoom(X x) {
        int index = this.usableRooms.indexOf(x);
        this.usableRooms.remove(index);
    }

    /**
     * Calculates the average area of all usable rooms  in the office.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the average area as a positive double.
     *
     * @return the average area of all usable rooms in the office
     */
    public double calculateAverageArea() {
        if (this.usableRooms.size() == 0) {
            return 0;
        }
        return calculateArea() / this.usableRooms.size();
    }

    /**
     * Calculates the average area of rooms with windows in the office.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the average area of windowed rooms as a positive double.
     *
     * @return the average area of rooms with windows
     */
    public double calculateAverageAreaWithWindows() {
        double area = 0;
        int count = 0;
        for (int i = 0; i < this.usableRooms.size(); i++) {
            if (this.usableRooms.get(i) instanceof WithWindows) {
                area += (this.usableRooms.get(i)).getLength() * (this.usableRooms.get(i)).getWidth();
                count ++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException();
        }
        return area / count;
    }

    /**
     * Calculates the average area of windowless rooms in the office.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the average area of windowless rooms as a positive double.
     *
     * @return the average area of windowless rooms
     */
    public double calculateAverageAreaWindowless() {
        double area = 0;
        int count = 0;
        for (int i = 0; i < this.usableRooms.size(); i++) {
            if (this.usableRooms.get(i) instanceof Windowless) {
                area += (this.usableRooms.get(i)).getLength() * (this.usableRooms.get(i)).getWidth();
                count ++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException();
        }
        return area / count;
    }

    /**
     * Calculates the average storage capacity of rooms in the office.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the average storage capacity as a positive double.
     *
     * @return the average storage capacity of rooms
     */
    public double calculateAverageStorage() {
        double storage = 0;
        int count = 0;
        for (int i = 0; i < this.usableRooms.size(); i++) {
            if (!(this.usableRooms.get(i)).isOffice()) {
                storage += (this.usableRooms.get(i)).getStorage();
                count ++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException();
        }
        return storage / count;
    }

    /**
     * Calculates the average number of workstations in the office.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the average number of workstations as a positive double.
     *
     * @return the average number of workstations
     */
    public double calculateAverageWorkstations() {
        double workstations = 0;
        int count = 0;
        for (int i = 0; i < this.usableRooms.size(); i++) {
            if ((this.usableRooms.get(i)).isOffice()) {
                workstations += (this.usableRooms.get(i)).getWorkstations();
                count ++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException();
        }
        return workstations / count;
    }

    /**
     * Calculates the average ratio of window area to room area.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the average ratio of window area to room area as a positive double.
     *
     * @return the average ratio of window area to room area
     */
    public double calculateAverageWindowToAreaRatio() {
        double windowArea = 0;
        int count = 0;
        for (int i = 0; i < this.usableRooms.size(); i++) {
            if (this.usableRooms.get(i) instanceof WithWindows) {
                windowArea += ((WithWindows)this.usableRooms.get(i)).getArea();
                count ++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException();
        }
        return  (windowArea / count) / calculateAverageAreaWithWindows();
    }

    /**
     * Calculates the average ratio of flux to room area for windowless rooms.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the average flux-to-area ratio as a positive double.
     *
     * @return the average ratio of flux to area for windowless rooms
     */
    public double calculateAverageFluxToAreaRatio() {
        double flux = 0;
        int count = 0;
        for (int i = 0; i < this.usableRooms.size(); i++) {
            if (this.usableRooms.get(i) instanceof Windowless) {
                flux += ((Windowless)this.usableRooms.get(i)).getFlux();
                count ++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException();
        }
        return  (flux / count) / calculateAverageAreaWindowless();
    }

    /**
     * Returns the unusable rooms of this office unit.
     *
     * Design by Contract (DbC):
     * - Postcondition: Returns the unusable rooms.
     *
     * @return the unusable rooms.
     */
    public Unusable getUnusableRooms() {
        return this.unusableRooms;
    }

    /**
     * Toggles the room designation and adjusts room properties accordingly.
     *
     * Design by Contract (DbC):
     * - Precondition: `n` must be a non-null Number; its type determines the field to adjust.
     * - Postcondition: If toggled to office, sets workstations based on `n` and clears storage.
     * - Postcondition: If toggled to storage, sets storage space based on `n` and clears workstations.
     *
     * @param n a Number that defines the new value for either workstations or storage.
     */
    public void change(X x, Number n) {
        x.change(n);
    }

    /**
     * Returns a String version of the office, containing info about the rooms and total area of the office.
     * */
    public String toString(){
        String output="";
        if(usableRooms.size()==0 && usableRooms==null){
            return uniqueNumber+" is Empty";
        }
        output+= usableRooms.toString();
        output=output.equals("Empty")? uniqueNumber+": UnusableRooms - "+unusableRooms.getArea()+"\n":uniqueNumber+":\n"+output+ "UnusableRooms - "+unusableRooms.getArea()+"\n";

        output+="Total area of the office:"+calculateArea()+" m^2\n";
        return output;
    }

    public Iterator<X> iterator(){
        return usableRooms.iterator();
    }
}
