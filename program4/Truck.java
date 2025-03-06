// Abdalla Abdelmagid

public class Truck extends Vehicle {
    
    private String length;
    private int loadCapacity;
    private int mpg;
    private String vin;

    public Truck(String length, int mpg, int loadCapacity, String vin) {
        super(length, mpg, vin, null);
        this.length = length;
        this.mpg = mpg;
        this.vin = vin;
        this.loadCapacity = loadCapacity;
    }

    public String toString() {
        return length + "       " + mpg + "    " + loadCapacity + "            " + vin;
    }
}
