package Aufgabe7;
@Documentation(description = "A class representing a mid-sized underfloor heating office.",
        responsible = "Simeon Obretenov",
        invariants = {"The size of the office must always be '2'.",
                "The name of the office must always be non-null and non-empty.",
                "The assigned pump, if any, must be compatible with mid-sized underfloor heating offices."},
        historyConstraints = {"Once initialized, the name and size of the office must not change.",
                "If a pump is assigned, it must remain compatible with the office type and size."})

public class MidUnderfloorOffice extends UnderfloorHeatingOffice {
    @Documentation(description = "Constructor to create a MidUnderfloorOffice instance with a specified name.",
            responsible = "Simeon Obretenov",
            preconditions = {"The name must not be null or empty."},
            postconditions = {"A mid-sized underfloor office instance is created with the specified name and the size set to '2'."})
    public MidUnderfloorOffice(String n) {
        super(n, 2);
    }

    @Documentation(description = "Method to assign a pump to the office.",
            responsible = "Simeon Obretenov",
            preconditions = {"The pump must be valid and of the correct type for this office."},
            postconditions = {"The pump is assigned to the office, and the office pump type is set according to the assigned pump."})
    public void assign (Pump p) {
        pump = p.assignedBy(this);
    }
}
