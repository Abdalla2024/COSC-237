// Abdalla Abdelmagid

public abstract class VehicleRates {
    private double dailyRate;
    private double weeklyRate;
    private double monthlyRate;
    private double mileageCharge;
    private double insuranceRate;


    public VehicleRates(double dr, double wr, double mr, double mc, double ir) {
        this.dailyRate = dr;
        this.weeklyRate = wr;
        this.monthlyRate = mr;
        this.mileageCharge = mc;
        this.insuranceRate = ir;
    } 

    public double getDailyRate() {      // cost per day
        return dailyRate;
    }

    public double getWeeklyRate() {     // cost per week
        return weeklyRate;
    }

    public double getMonthlyRate() {    // cost per month
        return monthlyRate;
    }

    public double getMileageCharge() {  // cost per mile based on vehicle type
        return mileageCharge;
    }

    public double getDailyInsurRate() {  // insurance cost (per day)
        return insuranceRate;
    }

    public abstract String toString();  // subclasses must provide toString method
}
