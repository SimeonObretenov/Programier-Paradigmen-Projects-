package Aufgabe7;
@Documentation(description = "An abstract class representing an office with underfloor heating.",
        responsible = "Simeon Obretenov",
        invariants = {"The name of the office must always be non-null and non-empty.",
                "The size of the office must always be a positive integer.",
                "The underfloor heating type must remain consistent for the office."},
        historyConstraints = {"Once initialized, the name and size of the office must not change.",
                "The office type (UnderfloorHeatingOffice) must remain consistent throughout its lifecycle."})

public abstract class UnderfloorHeatingOffice extends Office {
    @Documentation(description = "Constructor to create an UnderfloorHeatingOffice instance with a specified name and size.",
            responsible = "Simeon Obretenov",
            preconditions = {"The name must not be null or empty.",
                    "The size must be a valid positive integer."},
            postconditions = {"The UnderfloorHeatingOffice instance is initialized with the given name, size, and underfloor heating type."})
    protected UnderfloorHeatingOffice(String n, int s) {
        super(n, s);
    }

    @Documentation(description = "Method to get a string representation of the underfloor heating office, including the type of heating.",
            responsible = "Simeon Obretenov",
            postconditions = {"Returns a string indicating the heating type (underfloor) and the office details."})
    public String toString() {
        return "Type of heating: Underfloor; " + super.toString();
    }
}
