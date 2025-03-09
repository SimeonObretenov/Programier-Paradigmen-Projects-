package Aufgabe7;
@Documentation(description = "An interface representing a pump type.",
        responsible = "Ivaylo Georgiev",
        invariants = {"The power level of the pump must always be greater than or equal to 0.",
        "The price of the pump must always be positive."},
        historyConstraints = {"Once initialized, the price and power level of the pump must not change."})

public interface Pump {
    @Documentation(description = "Method to assign a pump by SmallUnderfloorOffice.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"o must not be null."},
            postconditions = {"Returns a valid Pump instance assigned by the provided SmallUnderfloorOffice."})
    Pump assignedBy(SmallUnderfloorOffice o);

    @Documentation(description = "Method to assign a pump by MidUnderfloorOffice.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"'o' must not be null."},
            postconditions = {"Returns a valid Pump instance assigned by the provided MidUnderfloorOffice."})
    Pump assignedBy(MidUnderfloorOffice o);

    @Documentation(description = "Method to assign a pump by LargeUnderfloorOffice.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"'o' must not be null."},
            postconditions = {"Returns a valid Pump instance assigned by the provided LargeUnderfloorOffice."})
    Pump assignedBy(LargeUnderfloorOffice o);

    @Documentation(description = "Method to assign a pump by SmallRadiatorOffice.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"'o' must not be null."},
            postconditions = {"Returns a valid Pump instance assigned by the provided SmallRadiatorOffice."})
    Pump assignedBy(SmallRadiatorOffice o);

    @Documentation(description = "Method to assign a pump by MidRadiatorOffice.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"'o' must not be null."},
            postconditions = {"Returns a valid Pump instance assigned by the provided MidRadiatorOffice."})
    Pump assignedBy(MidRadiatorOffice o);

    @Documentation(description = "Method to assign a pump by LargeRadiatorOffice.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"'o' must not be null."},
            postconditions = {"Returns a valid Pump instance assigned by the provided LargeRadiatorOffice."})
    Pump assignedBy(LargeRadiatorOffice o);

    @Documentation(description = "Method to get the power level of the pump.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"Returns the power level of the pump"})
    int getPower();

    @Documentation(description = "Method to get the price of pump.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"Returns the price of the pump."})
    double getPrice();

    @Documentation(description = "Method to provide a string representation of the pump.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"Returns a String representation of the Pump, including all relevant attributes and details."})
    String toString();
}
