// Abdalla Abdelmagid

public class Transaction {
    
    private String creditCardNum;
    private String companyName;
    private int vehicleType; // car, SUV or Truck
    private String rentalPeriod; // days, week, months
    private int milesDriven;
    private double rentalCost;

    public Transaction(String ccn, String compName, int vehType, 
                        String rentPeriod, int milesDriven, double cost) {
                            this.creditCardNum = ccn;
                            this.companyName = compName;
                            this.vehicleType = vehType;
                            this.rentalPeriod = rentPeriod;
                            this.milesDriven = milesDriven;
                            this.rentalCost = cost;

    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public String toString() {
        return "Name: " + companyName + "\nCredit card num: " + creditCardNum + "\nRental period: " +
        rentalPeriod + "\nMiles driven: " + milesDriven;
    }

    public double getRentalCost() {
        return rentalCost;
    }
}
