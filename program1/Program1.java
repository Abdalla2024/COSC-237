// Abdalla Abdelmagid

import java.text.DecimalFormat;
import java.util.Scanner;

public class Program1 {
    static Scanner in = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.00");
      public static void main(String[] args) {
        boolean run = true;
        do {
          int choice = 0;
    
          // Choice of conversion method
          final String[] convMethod = {
              "Metric to imperial",
              "Imperial to metric"
          };
    
          // Print the menu system to allow them to choose what they would like to convert
          System.out.println(getMenu(convMethod));
          System.out.print("> ");
    
          // What to run based on what the user chooses
          if (in.hasNextInt()) {
            choice = in.nextInt();
            switch (choice) {
              case 1:
                metricToImperial();
                break;
              case 2:
                imperialToMetric();
                break;
              case 0:
                System.out.println("Thanks for using our program!"); // Allow user to quit program
                run = false;
                break;
              default:
                System.err.println("Option does not exist. Try again"); // Input validation
                in.nextLine();
                break;
            }
          } else {
            System.err.println("Invalid option. Try again");
            in.nextLine();
          }
    
        } while (run);
    
        in.close();
      }

      // Method to convert from metric to imperial
      static void metricToImperial() {
        double meters;
        double centimeters;
        double feet = 0;
        double inches;

       // System.out.println("Enter amount of meters: ");
        meters = getInt(in, "Enter amount of meters: ");
        System.out.println("Enter amount of centimeters: ");
        centimeters = in.nextDouble();

        inches = (meters * 39.3701) + (centimeters/2.54);

        // When inches go above 12, add another foot
        while (inches >= 12) {
          feet += 1;
          inches -= 12;
        }

        // Output the imperial length with inches rounding to two decimal places
        System.out.println("The imperial length is " + feet + 
        " feet, " + df.format(inches) + " inches");
        
      }

      // Method to convert from imperial to metric
      static void imperialToMetric() {
        double meters = 0;
        double centimeters;
        double feet;
        double inches;

        feet = getInt(in, "Enter amount of feet: ");
        System.out.println("Enter amount of inches: ");
        inches = in.nextDouble();

        centimeters = (feet * 30.48) + (inches * 2.54);

        //When centimeters go above 100, add another meter
        while (centimeters >= 100) {
          meters += 1;
          centimeters-= 100;
        }

        // Output metric length with centimeters rounded to two decimal places
        System.out.println("The metric length is " + meters +
        " meters, " + df.format(centimeters) + " centimeters");

      }

//Generates a string menu allowing user to choose from metric to imperial
// or from imperial to metric.
  public static String getMenu(String[] convMethod) {
    String menu = "";
    for (int x = 0; x < convMethod.length; x++)
      menu += Integer.toString(x + 1) + ". " + convMethod[x] + '\n';

    return 
      "Choose a conversion method\n" +
      menu +
      "0. Exit";
  }
    
  // Prompts user to enter number and ensures that the user enters an integer
  public static int getInt(Scanner in, String msg) {
    System.out.println(msg);

    while (!in.hasNextInt()) {
       in.nextLine();
       System.err.println("Invalid input. Please enter an integer");
    }

    int number = in.nextInt();
    in.nextLine();
    return number;
 }
}
