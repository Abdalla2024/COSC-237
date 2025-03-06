// Abdalla Abdelmagid

public class SUV extends Vehicle {

    private String make;
    private int seats;
    private int cargoCapacity;
    private int mpg;
    private String vin;

    public SUV (String make, int mpg, int seats, int cargoCapacity, String vin) {
        super(make, mpg, vin, null);
        this.make = make;
        this.mpg = mpg;
        this.vin = vin;
        this.seats = seats;
        this.cargoCapacity = cargoCapacity;
    }

    public String toString() {
        return make +  "   " + mpg + "    " + seats + "  " + cargoCapacity + "       " + vin;
    }
    
}
