package Aufgabe7;
@Documentation(description = "An abstract class representing a low-temperature pump.",
        responsible = "Yoana Angelova",
        invariants = {"Price must be positive.",
                "The assigned pump should not change its price after being set."})
public abstract class LowTempPump implements Pump {
    private double price;

    @Documentation(description = "Constructor to create a LowTempPump instance with a specified price.",
            responsible = "Yoana Angelova",
            preconditions = {"price must be a positive value."},
            postconditions = {"The price attribute is initialized with the given value."},
            invariants = {"The price of the pump must be positive."})
    public LowTempPump(double price) {
        this.price = price;
    }

    @Documentation(description = "Method to assign a low-temperature pump to a SmallRadiatorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a Pump instance assigned to the SmallRadiatorOffice (currently returns null)."})
    @Override
    public Pump assignedBy(SmallRadiatorOffice o) {
        return null;
    }

    @Documentation(description = "Method to assign a low-temperature pump to a MidRadiatorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a Pump instance assigned to the MidRadiatorOffice (currently returns null)."})
    @Override
    public Pump assignedBy(MidRadiatorOffice o) {
        return null;
    }

    @Documentation(description = "Method to assign a low-temperature pump to a LargeRadiatorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null.",},
            postconditions = {"Returns a Pump instance assigned to the LargeRadiatorOffice (currently returns null)."})
    @Override
    public Pump assignedBy(LargeRadiatorOffice o) {
        return null;
    }

    @Documentation(description = "Method to get the price of the high-temperature pump.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"Returns the price of the pump."},
            invariants = {"The price of the pump must always be positive."})
    @Override
    public double getPrice(){
        return price;
    }

    @Documentation(description = "Method to provide a string representation of the low-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns a string representation of the pump, including the pump type and price."})
    @Override
    public String toString() {
        return "Pump type: low temperature, with price " + this.price + "euros";
    }
}
