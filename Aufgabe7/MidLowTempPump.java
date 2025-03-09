package Aufgabe7;
@Documentation(description = "A concrete class representing a medium low-temperature pump.",
        responsible = "Yoana Angelova",
        invariants = {"Price must always be positive.",
                "The power level must always be 2."},
        historyConstraints = {"Once initialized, the price and power level must not change."})

public class MidLowTempPump extends LowTempPump {
    private final int power = 2;

    @Documentation(description = "Constructor to create a MidLowTempPump instance with a specified price.",
            responsible = "Yoana Angelova",
            preconditions = {"price must be a positive value."},
            postconditions = {"The price is initialized with the given value, and the power level is set to 2."})
    public MidLowTempPump(double price) {
        super(price);
    }

    @Documentation(description = "Method to assign a medium low-temperature pump to a SmallUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a Pump instance (currently returns null)."})
    @Override
    public Pump assignedBy(SmallUnderfloorOffice o) {
        return null;
    }

    @Documentation(description = "Method to assign a medium low-temperature pump to a MidUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the MidLowTempPump instance."})
    @Override
    public Pump assignedBy(MidUnderfloorOffice o) {
        return this;
    }

    @Documentation(description = "Method to assign a medium low-temperature pump to a LargeUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the MidLowTempPump instance."})
    @Override
    public Pump assignedBy(LargeUnderfloorOffice o) {
        return this;
    }

    @Documentation(description = "Method to get the power level of the medium low-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns the power level of the pump, which is 2."})
    public int getPower() {
        return power;
    }

    @Documentation(description = "Method to provide a string representation of the medium low-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns a string representation of the pump, including the pump type, price, and power level."})
    public String toString() {
        return super.toString() + " and power level: medium";
    }
}
