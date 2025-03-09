package Aufgabe7;

import java.util.LinkedList;
@Documentation(description = "A class to manage office operations and heat pump assignments.",
        responsible = "Ivaylo Georgiev")
public class OfficeOperator {
    LinkedList<Pump> pumps;
    LinkedList<Office> offices;

    @Documentation(description = "Constructor to create an OfficeOperator with a list of offices.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"The list of offices must not be null."},
            postconditions = {"An OfficeOperator instance is created with the specified list of offices and an empty pump list."},
            invariants = {"The pump list must not contain null elements.",
                    "The office list must not contain null elements.",
                    "Each pump can only be assigned to one office at a time."},
            historyConstraints = {"Once initialized, the list of offices must not be null.",
                    "Assigned pumps must remain consistent with office requirements and configurations."})

    public OfficeOperator(LinkedList<Office> offices){
        pumps=new LinkedList<>();
        this.offices=offices;
    }

    @Documentation(description = "Method to add a heat pump to the operator's pump list.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"The pump must be a valid instance of Pump and not null."},
            postconditions = {"The heat pump is added to the pump list."})
    public void addHeatPump(Pump p) {
        if(p!=null){
            pumps.addLast(p);
        }
    }

    @Documentation(description = "Method to delete a heat pump from the operator's pump list.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"The pump must be a valid instance of Pump and not null."},
            postconditions = {"The heat pump is deleted from the pump list."})
    public void deleteHeatPump(Pump p) {
        if(p!=null){
            pumps.addLast(p);
        }
    }

    @Documentation(description = "Method to assign a heat pump to an office based on its size and pump availability.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"The office must not be null."},
            postconditions = {"A suitable heat pump is assigned to the office, based on its size."})
    public Pump assignHeatPump(Office o) {
        if(o.getPump()==null){
            Pump newP=pumps.getFirst();
            for (Pump p:pumps) {
                if(newP.getPower()>=o.getSize() && newP.getPower()<p.getPower()){
                    newP=p;
                }
            }
            o.assign(newP);
            return newP;
        }
        returnHeatPump(o);
        Pump newP=pumps.getFirst();
        for (Pump p:pumps) {
            if(newP.getPower()>=o.getSize() && newP.getPower()<p.getPower() && p!=pumps.getLast()){
                newP=p;
            }
        }
        o.assign(newP);
        return newP;
    }

    @Documentation(description = "Method to delete the heat pump from an office and add it back to the operator's pump list.",
            responsible = "Ivaylo Georgiev",
            preconditions = {"The office must not be null and should have an assigned pump."},
            postconditions = {"The pump is returned to the pump list and is available for assignment again."})
    public void returnHeatPump(Office o) {
        Pump p = o.returnPump();
        if(p!=null){
            pumps.addLast(p);
        }
    }

    @Documentation(description = "Method to calculate the total price of available pumps.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"The total price of all available pumps is returned."})
    public double priceAvailable() {
        double sum=0;
        for(Pump p:pumps){
            sum+=p.getPrice();
        }
        return sum;
    }

    @Documentation(description = "Method to calculate the total price of pumps currently assigned to offices.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"The total price of all installed pumps is returned."})
    public double priceInstalled() {
        double sum=0;
        for(Office o:offices){
            if(o.getPump()!=null){
                sum+=o.getPump().getPrice();
            }
        }
        return sum;
    }

    @Documentation(description = "Method to display a list of all available heat pumps.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"A string representation of all available pumps is returned."})
    public String showHeatPumps() {
        String output = "";
        if (pumps.isEmpty()) {
            return "No pumps";
        }
        else {
            for (Pump p: pumps) {
                output += p.toString() + '\n';
            }
        }
        return output;
    }

    @Documentation(description = "Method to display a list of all offices and their pump assignments.",
            responsible = "Ivaylo Georgiev",
            postconditions = {"A string representation of all offices and their pump assignments is returned."})
    public String showOffices() {
        String output = "";
        for (Office o: offices) {
            output += o.toString() + '\n';
        }
        return output;
    }
}
