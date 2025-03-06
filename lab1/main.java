import java.util.*;

class Main {
	static Scanner in = new Scanner(System.in);
	// HeightAndWeight hw = new HeightAndWeight();

	// Test Driver for HeightAndWeight Class  (incomplete)
    public static void main(String[] args) {
		int height = 66;
		int weight = 135;
	
		HeightAndWeight hw = new HeightAndWeight(height, weight);
		System.out.println("HeightAndWeight object created for height = " + height + " and weight = " + weight);
		System.out.println("Method getHeight returned " + hw.getHeight());
		System.out.println("Method getWeight returned " + hw.getWeight());
		System.out.println("Method getDesript returned " + hw.getDescript());
 
  
  }
}