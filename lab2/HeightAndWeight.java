//Abdalla Abdelmagid

import java.util.*;

public class HeightAndWeight {
    private int height; //ins
    private int weight; //lbs

// Constructor
public HeightAndWeight (int h, int w) {
    height = h;
    weight = w;
  }

// toString method
public String toString() {
    return "Height: " + height + " in. " +
           "Weight: " + weight + " lbs";
  }

  // Getter Methods
  public int getHeight () {
    return height;
}

public int getWeight () {
    return weight;
}

// HeightAndWeight Operators
public double getBMI(){
  return convertPoundsToKgs(weight) / 
        Math.pow(convertFeetToMeters(height), 2);
}

/* public boolean healthyBMI(){
 double range = getBMI(); 
    if(range>=18.5&&range<=24.9){
      return true;
    } else {
      return false;
    }
}
*/

public String getDescript(){
    double bmi = getBMI();
    if (bmi > 0 && bmi < 18.5) {
        return "underweight";
    } else if (bmi >= 18.5 && bmi < 25) {
        return "Normal";
    } else if (bmi >= 25 && bmi < 30) {
        return "Overweight";
    } else {
        return "obese";
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
