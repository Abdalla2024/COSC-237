import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        boolean run = true;
        do {
        int choice = 0;
        int temp;
        final String[] type = {
            "Fahrenheit",
            "Celsius"
        };

        System.out.println(getMenu(type));
        System.out.print("> ");

        if (in.hasNextInt()) {
            choice = in.nextInt();
            switch (choice) {
              case 1:
                System.out.println("Enter a temperature in Fahrenheit: ");
                temp = in.nextInt();
                Fahrenheit f = new Fahrenheit(temp);
                System.out.println("toString: " + f.toString());
                System.out.println("Below freezing? " + f.belowFreezing());
                System.out.println("Swimming weather? " + f.swimmingWeather());
                break;
              case 2:
                System.out.println("Enter a temperature in Celsius: ");
                temp = in.nextInt();
                Celsius c = new Celsius(temp);
                System.out.println("toString: " + c.toString());
                System.out.println("Below freezing? " + c.belowFreezing());
                System.out.println("Swimming weather? " + c.swimmingWeather());
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


    public static String getMenu(String[] type) {
        String menu = "";
        for (int x = 0; x < type.length; x++)
          menu += Integer.toString(x + 1) + ". " + type[x] + '\n';
    
        return 
          "Enter 1 for Fahrenheit, 2 for Celsius\n" +
          menu +
          "0. Exit";
      }
    
}
