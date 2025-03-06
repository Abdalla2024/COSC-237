// Abdalla Abdelmagid

public class SUVRates extends VehicleRates {

    public double dr, wr, mr, mc, ir;


    public SUVRates() {
        super(29.95, 189.95, 679.95, 0.16, 14.95);
        dr = 29.95;
        wr = 189.95;
        mr = 679.95;
        mc = 0.16;
        ir = 14.95;
    }

    public String toString() {
        return "-----SUV Rates-----\nDaily rate: $" + dr +"\nWeekly rate: $" + wr + 
        "\nMonthly rate: $" + mr + "\nMileage charge: $" + mc + "\nInsurance rate: $" + ir;
    }
    
}