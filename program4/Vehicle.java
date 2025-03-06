// Abdalla Abdelmagid

public abstract class Vehicle {

    private String description; // stores make-model-year for cars and SUVs, stores length for trucks
    private int mpg; // miles per gallon rating
    private String vin; // unique vehicle identification number
    private Reservation resv; // reservation information (a null value means vehicle not reserved)
    private VehicleRates rates; // only assigned when vehicle reserved

    public Vehicle() {
        
    }
    public Vehicle(String d, int mpg, String vin, Reservation resv) {
        this.description = d;
        this.mpg = mpg;
        this.vin = vin;
        resv = null;
        rates = null; // used to hold rates quoated at the time of the reservation
    }

    public Vehicle(String make, int mpg, String vin) {
    }
    
    public String getDescription() {
        return description;
    }

    public int getMpg() {
        return mpg;
    }

    public String getVin() {
        return vin;
    }

    public abstract String toString();

    public Reservation getReservation() throws UnreservedVehicleException{
        return resv;
    }

    public boolean isReserved() {
        if (resv == null) {
            return false;
        } else {
            return true;
        }
    }

    public void reserve(Reservation r) throws ReservedVehicleException{
        try {
            if (isReserved()) {
                throw new ReservedVehicleException();
            } else {
                resv = r;
            }
        } catch (ReservedVehicleException e) {
            e.printStackTrace();
        }
    }

    public Reservation cancelReservation() throws UnreservedVehicleException{
        if (resv == null) {
            throw new UnreservedVehicleException();
        }
        
        resv = null;
        return resv;
    }

    public VehicleRates getQuotedRates() {
        return rates;
    }

    public void setQuotedRates(VehicleRates cost) {

    }
}
