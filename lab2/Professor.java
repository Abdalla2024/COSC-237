//Abdalla Abdelmagid

public class Professor extends Person{
    private int teachingLoad;
    private double score;
    private String department;

    // constructor
    public Professor(String name, int age, int height, int weight
                    , int tl, double s, String d) {
        super(name, age, height, weight);
        teachingLoad = tl;
        score = s;
        department = d;
    }

    // getter methods

    public int getTeachingLoad() {
        return teachingLoad;
    }

    public double getScore() {
        return score;
    }

    public String getDepartment() {
        return department;
    }

    public String rating() {
        if (score <= 5 && score >= 4) {
            return "hot";
        } else if (score < 4 && score >= 3){
            return "good";
        } else if (score < 3 && score >= 2) {
            return "so-so";
        } else if (score < 2 && score >= 0) {
            return "avoid";
        } else {
            return "Not in range?";
        }
    }

    public String toString () {
        return super.getName() + " age:" + super.getAge() + " height:" + super.getHeight() + 
       " ins. weight:" + super.getWeight() + " lbs. Teaching load: " + teachingLoad +
        " student eval: " + rating() + " department: " + department;
    }
}
