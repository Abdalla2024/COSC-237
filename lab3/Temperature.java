public abstract class Temperature {
    
    private int temp;

    public Temperature (int temp) {
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public String toString() {
        return "";
    }

    public boolean belowFreezing() {
            return false;
    }

    public boolean swimmingWeather() {
            return false;
    }
}
