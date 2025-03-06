// Abdalla Abdelmagid

public class TruckRates extends VehicleRates {

    public double dr, wr, mr, mc, ir;

    public TruckRates() {
        super(36.95, 224.95, 687.95, 0.26, 21.95);
        dr = 36.95;
        wr = 224.95;
        mr = 687.95;
        mc = 0.26;
        ir = 21.95;
        
    }

    public String toString() {
        return "-----Truck Rates-----\nDaily rate: $" + dr +"\nWeekly rate: $" + wr + 
        "\nMonthly rate: $" + mr + "\nMileage charge: $" + mc + "\nInsurance rate: $" + ir;
    }
    
}