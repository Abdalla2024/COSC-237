// Abdalla Abdelmagid

public class TimeSpan {
    
    private char timeUnit; // ‘D’ (day), ‘W’ (week), ‘M’ (month)
    private int numUnits; // num of days, weeks or months

    public TimeSpan(char timeUnit, int numUnits) {
        this.timeUnit = timeUnit;
        this.numUnits = numUnits;
    }

    public char getTimeUnit() {
        return timeUnit;
    }

    public int getNumUnits() {
        return numUnits;
    }

    public String toString() {
        if (timeUnit == 'D' || timeUnit == 'd') {
            return numUnits + " days";
        } else if (timeUnit == 'W' || timeUnit == 'w') {
            return numUnits + " weeks";
        } else if (timeUnit == 'M' || timeUnit == 'm') {
            return numUnits + " months";
        } else {
            return "Invalid input";
        }
    }
    
}
