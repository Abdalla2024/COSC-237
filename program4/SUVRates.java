// Abdalla Abdelmagid

public class SUVRates extends VehicleRates {

    double dr, wr, mr, mc, ir;


    public SUVRates() {
        super(29.95, 189.95, 679.95, 0.16, 14.95);
        dr = 29.95;
        wr = 189.95;
        mr = 679.95;
        mc = 0.16;
        ir = 14.95;
    }

    public String toString() {
        return "-----SUV Rates-----\nDaily rate: $29.95\nWeekly rate: $189.95\nMonthly rate: $679.95" +
                "\nMileage charge: $0.16\nInsurance rate: $14.95";
    }
    
}