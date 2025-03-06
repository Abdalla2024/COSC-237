public class Celsius extends Temperature {

    public Celsius(int temp) {
        super(temp);
    }

    public String toString() {
        return super.getTemp() + " degrees Celsius";
    }

    public boolean belowFreezing() {
        if (super.getTemp() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean swimmingWeather() {
        if (super.getTemp() >= 27) {
            return true;
        } else {
            return false;
        }
    }

}
