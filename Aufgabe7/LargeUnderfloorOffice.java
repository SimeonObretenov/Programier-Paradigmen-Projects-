package Aufgabe7;
@Documentation(description = "A class representing a large-sized underfloor heating office.",
        responsible = "Simeon Obretenov",
        invariants = {"The name must not be null or empty.",
                "The size of the LargeUnderfloorOffice is fixed at 3 and cannot change.",
                "The assigned pump must be of the correct type for this office."},
        historyConstraints = {"Once a pump is assigned, the office's pump type and the pump's price cannot change."})
public class LargeUnderfloorOffice extends UnderfloorHeatingOffice {
    @Documentation(description = "Constructor to create a LargeUnderfloorOffice instance with a specified name.",
            responsible = "Simeon Obretenov",
            preconditions = {"The name must not be null or empty."},
            postconditions = {"A large-sized underfloor office instance is created with the specified name and the size set to '3'."},
            invariants = {"The name must not be null or empty."})
    public LargeUnderfloorOffice(String n) {
        super(n, 3);
    }

    @Documentation(description = "Method to assign a pump to the office.",
            responsible = "Simeon Obretenov",
            preconditions = {"The pump must be valid and of the correct type for this office."},
            postconditions = {"The pump is assigned to the office, and the office pump type is set according to the assigned pump."})
    public void assign (Pump p) {
        pump = p.assignedBy(this);
    }
}
