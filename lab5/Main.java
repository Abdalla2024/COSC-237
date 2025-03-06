// Abdalla Abdelmagid

import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    
    public static void main(String args[]) {

        int num;
        System.out.println("Enter a postive integer");
        num = in.nextInt();

        while (num > 0) {
            Recursion.factorial(num);
            System.out.println(Recursion.factorial(num));

            System.out.println("Enter another positive integer. Or a negative integer to quit");
            num = in.nextInt();
        } 

        System.out.println("Starting towers");
        Recursion.towers(36, "A", "C", "B");
        System.out.println("Finished towers");
    }
}

