// Abdalla Abdelmagid

public class CurrentRates {
    
    // array of size 3 to store rates for three types of vehicles
    private VehicleRates[] rates = new VehicleRates[3];
    

    public CurrentRates(CarRates c, SUVRates s, TruckRates t) {
        rates [0] = c;
        rates[1] = s;
        rates[2] = t;
    }

    public VehicleRates getCarRates() {
        return rates[0];
    }

    public void setCarRates(VehicleRates r) {
        rates[0] = r;
    }

    public VehicleRates getSUVRates() {
        return rates[1];
    }

    public void setSUVRates(VehicleRates r) {
        rates[1] = r;
    }

    public VehicleRates getTruckRates() {
        return rates[2];
    }

    public void setTruckRates(VehicleRates r) {
        rates[2] = r;
    }

    public double calcEstimatedCost(int vehicleType,TimeSpan estimatedRentalPeriod, int estimatedNumMiles,
    boolean dailyInsur, boolean primeCustomer) {
        double cost = 0;
        for(int i = 0; i < rates.length; i++) {
            if(i == (vehicleType - 1)) {
                if(estimatedRentalPeriod.getTimeUnit() == 'D') {
                    cost = estimatedRentalPeriod.getNumUnits() * rates[i].getDailyRate();
                    cost += (rates[i].getMileageCharge() * estimatedNumMiles);

                    if(dailyInsur) {
                        cost += (rates[i].getDailyInsurRate() * estimatedRentalPeriod.getNumUnits());
                    }

                    if(primeCustomer) {
                        cost -= (rates[i].getMileageCharge() * 100);
                    }
                } else if(estimatedRentalPeriod.getTimeUnit() == 'W') {
                    cost = estimatedRentalPeriod.getNumUnits() * rates[i].getWeeklyRate();
                    cost += (rates[i].getMileageCharge() * estimatedNumMiles);

                    if(dailyInsur) {
                        cost += (rates[i].getDailyInsurRate() * estimatedRentalPeriod.getNumUnits());
                    }

                    if(primeCustomer) {
                        cost -= (rates[i].getMileageCharge() * 100);
                    }
                } else if(estimatedRentalPeriod.getTimeUnit() == 'M') {
                    cost = estimatedRentalPeriod.getNumUnits() * rates[i].getMonthlyRate();
                    cost += (rates[i].getMileageCharge() * estimatedNumMiles);

                    if(dailyInsur) {
                        cost += (rates[i].getDailyInsurRate() * estimatedRentalPeriod.getNumUnits());
                    }

                    if(primeCustomer) {
                        cost -= (rates[i].getMileageCharge() * 100);
                    }
                }
            }
        }
        return cost;
    }

    
    public double calcActualCost(VehicleRates rates, int numDaysUsed, int NumMilesDriven,
    boolean dailyInsur, boolean primeCustomer) {
        int weeks = 0;
        int months = 0;
        double cost = 0;

        if(numDaysUsed < 7) {
            cost = rates.getDailyRate() * numDaysUsed;
        } else if (numDaysUsed >= 7 && numDaysUsed < 30) {
            while(numDaysUsed >= 7) {
                weeks++;
                numDaysUsed -= 7;
            }
            cost = rates.getWeeklyRate() * weeks;
        } else if (numDaysUsed > 30) {
            while(numDaysUsed > 30) {
                months++;
                numDaysUsed -= 30;
            }
            cost = rates.getMonthlyRate() * months;
        }
        return cost;
    }
}
