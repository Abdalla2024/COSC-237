public class ReservationDetails {
    String name;
    String creditCardNum;
    TimeSpan rentalPeriod;
    boolean insuranceSelected;
    String vin;

    public ReservationDetails(String name, String ccn, TimeSpan rp, boolean insur, String vin) {
        this.name = name;
        this.creditCardNum = ccn;
        this.rentalPeriod = rp;
        this.insuranceSelected = insur;
        this.vin = vin;
    }

    public String getName() {
        return name;
    }

    public String getCreditCard() {
        return creditCardNum;
    }

    public TimeSpan getRentalPeriod() {
        return rentalPeriod;
    }

    public boolean getInsuranceSelected() {
        return insuranceSelected;
    }

    public String getVin() {
        return vin;
    }
}
