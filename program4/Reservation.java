// Abdalla Abdelmagid

public class Reservation {
    
    private String name; // customer name
    private String creditCardNum; // credit card number vehicle reserved under
    private TimeSpan rentalPeriod; // e.g., four days, two weeks, one month
    private boolean insuranceSelected; // indicates if optional daily insurance wanted

    public Reservation(String name, String ccn, TimeSpan rp, boolean insurance) {
        this.name = name;
        this.creditCardNum = ccn;
        this.rentalPeriod = rp;
        this.insuranceSelected = insurance;
    }

    public String getName() {
        return name;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public TimeSpan getRentalPeriod() {
        return rentalPeriod;
    }

    public boolean insuranceSelected() {
        return insuranceSelected;
    }

    public String toString() {
        return "Name: " + name + "\nCard Num: " + creditCardNum +
                "\nRental Period: " + rentalPeriod + "\nInsurance? " + insuranceSelected;
    }
}
