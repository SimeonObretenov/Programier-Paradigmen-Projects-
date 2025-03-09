package Aufgabe7;
@Documentation(description = "An abstract class representing an office with radiator heating.",
        responsible = "Simeon Obretenov",
        invariants = {"The name of the office must always be non-null and non-empty.",
                "The size of the office must always be a positive integer.",
                "The radiator heating type must remain consistent for the office."},
        historyConstraints = {"Once initialized, the name and size of the office must not change.",
                "The office type (RadiatorHeatingOffice) must remain consistent throughout its lifecycle."})

public abstract class RadiatorHeatingOffice extends Office {
    @Documentation(description = "Constructor to create a RadiatorHeatingOffice instance with a specified name and size.",
            responsible = "Simeon Obretenov",
            preconditions = {"The name must not be null or empty.",
                    "The size must be a valid positive integer."},
            postconditions = {"The RadiatorHeatingOffice instance is initialized with the given name, size, and radiator heating type."})
    protected RadiatorHeatingOffice(String n, int s) {
        super(n, s);
    }

    @Documentation(description = "Method to get a string representation of the radiator heating office, including the type of heating.",
            responsible = "Simeon Obretenov",
            postconditions = {"Returns a string indicating the heating type (radiator) and the office details."})
    public String toString() {
        return "Type of heating: Radiator; " + super.toString();
    }
}
