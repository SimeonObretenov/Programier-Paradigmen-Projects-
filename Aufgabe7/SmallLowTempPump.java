package Aufgabe7;
@Documentation(description = "A concrete class representing a small low-temperature pump.",
        responsible = "Yoana Angelova",
        invariants = {"Price must always be positive.",
                "The power level must always be 1."},
        historyConstraints = {"Once initialized, the price and power level must not change."})

public class SmallLowTempPump extends LowTempPump {
    private final int power = 1;

    @Documentation(description = "Constructor to create a SmallLowTempPump instance with a specified price.",
            responsible = "Yoana Angelova",
            preconditions = {"price must be a positive value."},
            postconditions = {"The price is initialized with the given value, and the power level is set to 1."})
    public SmallLowTempPump(double price) {
        super(price);
    }

    @Documentation(description = "Method to assign a small low-temperature pump to a SmallUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the SmallLowTempPump instance."})
    @Override
    public Pump assignedBy(SmallUnderfloorOffice o) {
        return this;
    }

    @Documentation(description = "Method to assign a small low-temperature pump to a MidUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the SmallLowTempPump instance."})
    @Override
    public Pump assignedBy(MidUnderfloorOffice o) {
        return this;
    }

    @Documentation(description = "Method to assign a small low-temperature pump to a LargeUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the SmallLowTempPump instance."})
    @Override
    public Pump assignedBy(LargeUnderfloorOffice o) {
        return this;
    }

    @Documentation(description = "Method to get the power level of the small low-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns the power level of the pump, which is 1."})
    @Override
    public int getPower() {
        return power;
    }

    @Documentation(description = "Method to provide a string representation of the small low-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns a string representation of the pump, including the pump type, price, and power level."})
    public String toString() {
        return super.toString() + " and power level: small";
    }
}
