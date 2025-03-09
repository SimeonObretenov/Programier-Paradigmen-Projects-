package Aufgabe7;
@Documentation(description = "An abstract class representing a high-temperature pump.",
        responsible = "Yoana Angelova",
        invariants = {"The price of the pump must always be positive."}
)
public abstract class HighTempPump implements Pump {
    private double price;

    @Documentation(description = "Constructor to create a HighTempPump instance with a specified price.",
            responsible = "Yoana Angelova",
            preconditions = {"price must be a positive value."},
            postconditions = {"The price attribute is initialized with the given value."},
            invariants = {"The price of the pump must be positive."})
    public HighTempPump(double price) {
        this.price = price;
    }

    @Documentation(description = "Method to assign a high-temperature pump to a SmallUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a Pump instance assigned to the SmallUnderfloorOffice (currently returns null)."})
    public Pump assignedBy(SmallUnderfloorOffice o){
        return null;
    }

    @Documentation(description = "Method to assign a high-temperature pump to a MidUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a Pump instance assigned to the MidUnderfloorOffice (currently returns null)."})
    public Pump assignedBy(MidUnderfloorOffice o){
        return null;
    }

    @Documentation(description = "Method to assign a high-temperature pump to a LargeUnderfloorOffice.",
            responsible = "Yoana Angelova",
            preconditions = { "o must not be null."},
            postconditions = {"Returns a Pump instance assigned to the LargeUnderfloorOffice (currently returns null)."})
    public Pump assignedBy(LargeUnderfloorOffice o){
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

    @Documentation(description = "Method to provide a string representation of the high-temperature pump.",
            responsible = "Yoana Angelova.",
            postconditions = {"Returns a string representation of the pump, including the pump type and price."})
    @Override
    public String toString() {
        return "Pump type: high temperature, with price " + this.price + "euros";
    }
}
