// Abdalla Abdelmagid

import java.util.Scanner;
import java.util.InputMismatchException;

class Main {

public static void main(String[] args) {
    int numer, denom;
    Fraction f1;
    Scanner input = new Scanner(System.in);
    boolean valid_input = false;

    while (!valid_input)
        try{
            System.out.print("Enter numerator <space> denominator: ");
            numer = input.nextInt();
            denom = input.nextInt();
            f1 = new Fraction(numer, denom);
            valid_input = true;
        
        Fraction f2 = new Fraction(f1);
        System.out.println("toString method " + f2.toString());
        System.out.println( "equal? " + f1.equals(f2));
        System.out.println("less than? " + f1.lessThan(f2));
        System.out.println("greater than? " + f1.greaterThan(f2));
        System.out.println("sum " + f1.add(f2));
        System.out.println("difference " + f1.subtract(f2));
        System.out.println("product " + f1.multiply(f2));
        System.out.println("quotient " + f1.divide(f2));
        System.out.println("absolute value " + f1.abs());
        System.out.println("decimal " + f1.convertToDecimal());
        System.out.println("reduced form? " + f2.isReducedForm());
        System.out.println("unit frac? " + f2.isUnitFrac());
        System.out.println("proper frac? " + f1.isProperFrac());

    }
        catch (InputMismatchException e){
            System.out.println("Non-digit character found. Please re-enter");
        }
        catch (DivideByZeroException e){
            System.out.println("Denominator of Zero found. Please re-enter");
        }
    }
    

  }



    

