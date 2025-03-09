package Aufgabe7;
@Documentation(description = "An abstract class representing an office with a name, size, and a pump.",
        responsible = "Simeon Obretenov",
        invariants = {"Name must not be null or empty.",
                "Size must always be a positive integer (1 for small, 2 for medium, 3 for large).",
                "The assigned pump, if any, must be compatible with the office size and type."},
        historyConstraints = {"Once an office's name and size are initialized, they must not change.",
                "If a pump is assigned, it must remain compatible with the office's requirements."})

public abstract class Office {

    private String name;
    private int size;
    protected Pump pump;

    @Documentation(description = "Constructor to create an Office instance with a specified name and size.",
            responsible = "Simeon Obretenov",
            preconditions = {"name must not be null or empty.",
                    "size must be a valid positive integer."},
            postconditions = {"The Office instance is initialized with the given name, size, and no pump assigned."},
            invariants = {"Name must not be null or empty.",
            "Size must always be a positive integer (1 for small, 2 for medium, 3 for large).",
            "The assigned pump, if any, must be compatible with the office size and type."},
            historyConstraints = {"Once an office's name and size are initialized, they must not change.",
                    "If a pump is assigned, it must remain compatible with the office's requirements."})

    protected Office(String n, int s) {
        this.name = n;
        this.size = s;
    }

    @Documentation(description = "Abstract method to assign a pump to the office.",
            responsible = "Simeon Obretenov",
            preconditions = {"The pump must be non-null."},
            postconditions = {"The specified pump is assigned to the office."})
    public abstract void assign(Pump p);

    @Documentation(description = "Method to get the name of the office.",
            responsible = "Simeon Obretenov",
            postconditions = {"Returns the name of the office."})
    public String getName() {
        return name;
    }

    @Documentation(description = "Method to get the size of the office.",
            responsible = "Simeon Obretenov",
            postconditions = {"Returns the size of the office."})
    public int getSize() {
        return size;
    }

    @Documentation(description = "Method to get the pump assigned to the office.",
            responsible = "Simeon Obretenov",
            postconditions = {"Returns the assigned pump, or null if no pump is assigned."})
    public Pump getPump() {
        return pump;
    }

    @Documentation(description = "Method to get a string representation of the office, including its name, size, and pump.",
            responsible = "Simeon Obretenov",
            postconditions = {"Returns a string containing the name, size (small, medium, large), and pump details (if any)."})
    public String toString() {
        String size = "";
        if (this.size == 1) { size= "small"; }
        else if (this.size == 2) { size= "medium"; }
        else { size = "large"; }
        if (pump == null) {
            return "with name: " + name + ", with size: " + size +  ", with no pump";
        }
        return "with name: " + name + ", with size: " + size + ", and type of pump: " + pump;
    }

    @Documentation(description = "Method to return the pump assigned to the office and set the pump to null.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"Returns the current pump assigned to the office and removes it from the office."})
    public Pump returnPump(){
        Pump p=pump;
        pump=null;
        return p;
    }

}
