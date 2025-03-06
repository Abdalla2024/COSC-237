// Abdalla Abdelmagid

public class CarRates extends VehicleRates {
    double dr, wr, mr, mc, ir;

    public CarRates() {
        super(24.95, 169.95, 514.95, 0.16, 14.95);
        dr = 24.95;
        wr = 169.95;
        mr = 514.95;
        mc = 0.16;
        ir = 14.95;
        
    }

    public String toString() {
        return "-----Car Rates-----\nDaily rate: $24.95\nWeekly rate: $169.95\nMonthly rate: $514.95" +
                "\nMileage charge: $0.16\nInsurance rate: $14.95";
    }
    
}
