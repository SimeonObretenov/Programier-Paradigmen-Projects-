package Aufgabe7;
@Documentation(description = "A concrete class representing a large low-temperature pump.",
        responsible = "Yoana Angelova",
        invariants = {"The price of the pump must always be positive.",
                "The power level of the pump is fixed at 3 and cannot change."},
        historyConstraints = {"Once assigned to an office, the pump's price cannot change."})
public class LargeLowTempPump extends LowTempPump {
    private final int power = 3;

    @Documentation(description = "Constructor to create a LargeLowTempPump instance with a specified price.",
            responsible = "Yoana Angelova",
            preconditions = {"price must be a positive value."},
            postconditions = {"The price is initialized with the given value, and the power level is set to 3."},
            invariants = {"The price of the pump must always be positive."})
    public LargeLowTempPump(double price) {
        super(price);
    }

    @Documentation(description = "Method to assign a large low-temperature pump to a SmallUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a Pump instance (currently returns null)."})
    @Override
    public Pump assignedBy(SmallUnderfloorOffice o) {
        return null;
    }

    @Documentation(description = "Method to assign a large low-temperature pump to a MidUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a Pump instance (currently returns null)."})
    @Override
    public Pump assignedBy(MidUnderfloorOffice o) {
        return null;
    }

    @Documentation(description = "Method to assign a large low-temperature pump to a LargeUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the LargeLowTempPump instance."})
    @Override
    public Pump assignedBy(LargeUnderfloorOffice o) {
        return this;
    }

    @Documentation(description = "Method to get the power level of the large low-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns the power level of the pump, which is 3."},
            invariants = {"The power level of the pump is fixed at 3 and cannot change."})
    public int getPower() {
        return this.power;
    }

    @Documentation(description = "Method to provide a string representation of the large low-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns a string representation of the pump, including the pump type, price, and power level."})
    public String toString() {
        return super.toString() + " and power level: large";
    }
}
