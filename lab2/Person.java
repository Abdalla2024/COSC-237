//Abdalla Abdelmagid

public class Person {

    private String name;
    private int age;
    private HeightAndWeight hw;

    public Person(String name, int age, int height, int weight) {
       this.name = name;
       this.age = age;
       hw = new HeightAndWeight(height, weight);
    }

    public String getName () {
       return name;
    }

    public int getAge () {
      return age;
    }

    public int getHeight () {
      int height = hw.getHeight(); 
      return height;
    }

    public int getWeight () {
      int weight = hw.getWeight(); 
      return weight;
    }

    public String toString () {
       return name + " age:" + age + " height:" + getHeight() + 
       " ins. weight:" + getWeight() + " lbs.";
    }

    public double getBMI(){
       int weight = getWeight();
       int height = getHeight();
      return convertPoundsToKgs(weight) / 
            Math.pow(convertFeetToMeters(height), 2);
    }

    public boolean healthyBMI(){
      double range = getBMI(); 
          if(range>=18.5&&range<=24.9){
            return true;
          } else {
            return false;
          }
      }

      // Private Methods
private double convertFeetToMeters(int h){
   return h * 0.0254;
}

private double convertPoundsToKgs(int p){
   return p * 0.454;
}

 }