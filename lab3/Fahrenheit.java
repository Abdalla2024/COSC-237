public class Fahrenheit extends Temperature {

    public Fahrenheit(int temp) {
        super(temp);
    }
    
    public String toString() {
        return super.getTemp() + " degrees Fahrenheit";
    }

    public boolean belowFreezing() {
        if (super.getTemp() <= 32) {
            return true;
        } else {
            return false;
        }
    }

    public boolean swimmingWeather() {
        if (super.getTemp() >= 80) {
            return true;
        } else {
            return false;
        }
    }
}
