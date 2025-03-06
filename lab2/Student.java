//Abdalla Abdelmagid

public class Student extends Person {

    private int credits;
    private double gpa;
    private String major;


    // constructor
    public Student (String name, int age, int height, int weight
                    , int c, double g, String m) {               
        super (name, age, height, weight);
        credits = c;
        gpa = g;
        major = m;
    }

    // getter methods

    public int getCredits() {
        return credits;
    }
    
    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public String toString () {
        return super.getName() + " age:" + super.getAge() + " height:" + super.getHeight() + 
       " ins. weight:" + super.getWeight() + " lbs. Earned Credits: " + credits +
        " gpa: " + gpa + " major: " + major;
    }

    public String status () {
        if (credits >= 0 && credits <= 30) {
            return "freshman";
        } else if (credits >= 31 && credits <= 60) {
            return "sophomore";
        } else if (credits >= 61 && credits < 90) {
            return "junior";
        } else {
            return "senior";
        }
    }

    public boolean deansList () {
        if (gpa >= 3.4) {
            return true;
        } else 
            return false;
    }
}
