package Aufgabe7;
@Documentation(description = "A concrete class representing a small high-temperature pump.",
        responsible = "Yoana Angelova",
        invariants = {"Price must always be positive.",
                "The power level must always be 1."},
        historyConstraints = {"Once initialized, the price and power level must not change."})

public class SmallHighTempPump extends HighTempPump {
    private final int power = 1;

    @Documentation(description = "Constructor to create a SmallHighTempPump instance with a specified price.",
            responsible = "Yoana Angelova",
            preconditions = {"price must be a positive value."},
            postconditions = {"The price is initialized with the given value, and the power level is set to 1."})
    public SmallHighTempPump(double price) {
        super(price);
    }

    @Documentation(description = "Method to assign a small high-temperature pump to a SmallRadiatorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the SmallHighTempPump instance."})
    @Override
    public Pump assignedBy(SmallRadiatorOffice o) {
        return this;
    }

    @Documentation(description = "Method to assign a small high-temperature pump to a MidRadiatorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the SmallHighTempPump instance."})
    @Override
    public Pump assignedBy(MidRadiatorOffice o) {
        return this;
    }

    @Documentation(description = "Method to assign a small high-temperature pump to a LargeRadiatorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns the SmallHighTempPump instance."})
    @Override
    public Pump assignedBy(LargeRadiatorOffice o) {
        return this;
    }

    @Documentation(description = "Method to get the power level of the small high-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns the power level of the pump, which is 1."})
    public int getPower() {
        return power;
    }

    @Documentation(description = "Method to provide a string representation of the small high-temperature pump.",
            responsible = "Yoana Angelova",
            postconditions = {"Returns a string representation of the pump, including the pump type, price, and power level."})
    public String toString() {
        return super.toString() + " and power level: small";
    }
}
