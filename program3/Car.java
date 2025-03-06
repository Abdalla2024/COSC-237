// Abdalla Abdelmagid

public class Car extends Vehicle {

    private String make;
    private int seats;
    private int mpg;
    private String vin;

    public Car(){
    
    }

    public Car(String make, int mpg, int seats, String vin) {
        super(make, mpg, vin, null);
        this.make = make;
        this.mpg = mpg;
        this.vin = vin;
        this.seats = seats;
    }

    public String toString() {
        return make +  "   " + mpg + "    " + seats + "        " + vin;
    }
    
}
