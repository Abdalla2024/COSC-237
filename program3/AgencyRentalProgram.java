// Abdalla Abdelmagid

import java.util.*;
import java.text.DecimalFormat;

public class AgencyRentalProgram {
    static Scanner input = new Scanner(System.in);
    static Vehicle veh;
    static Account acct;
    static Transaction tran;
    static Vehicles vehs = new Vehicles();
    static Accounts accts = new Accounts();
    static Transactions trans = new Transactions();
    static DecimalFormat df = new DecimalFormat("0.00");
    static String vin;
  public static void main(String[] args) {
    
    
    // Create and init needed aggregation objects
    CurrentRates current_rates = new CurrentRates(new CarRates(),
                                                  new SUVRates(),
                                                  new TruckRates());

    Vehicles vehicles = new Vehicles();
    populateVehicles(vehs);

    Accounts accounts = new Accounts();
    populateAccounts(accts);

    Transactions transactions = new Transactions();
    populateTransactions(trans);

    // Init System Interface
    SystemInterface.initSystem(current_rates, vehicles, accounts, transactions);
    
    // Declare/Init variables
    int response;
    boolean quit = false;

    // Command execute loop
    while(!quit) {
      displayMenu();
      response = getResponse(input);
       execute(response, input);
       quit = exit(input, quit);
    }
    
    System.out.println("Exiting system ...");

  } // end of main method

  public static int getResponse(Scanner input) {
    int response;
    response = input.nextInt();
    return response;
  }

public static void execute(int response, Scanner input) { 
  try {  
      switch(response) {
        case 1: displayCarRates(); break;
        case 2: displaySUVRates(); break;
        case 3: displayTruckRates(); break;
        case 4: updateCarRates(input); break;
        case 5: updateSUVRates(input); break;
        case 6: updateTruckRates(input); break;
        case 7: displayAllAvailCars(vehs); break;
        case 8: displayAllAvailSUVs(vehs); break;
        case 9: displayAllAvailTrucks(vehs); break;
        case 10: displayAllVehicles(vehs); break;
        case 11: makeReservation(); break;
        case 12: displayReservation(input); break;
        case 13: cancelReservation(); break;
        case 14: processReturnedRental(); break;
        case 15: displayAllReservations(); break;
        case 16: viewAccount(); break;
        case 17: viewAllAccounts(accts); break;
        case 18: addAccount(input); break;
        case 19: viewAllTransactions(trans); break;
        default: System.out.println("Invalid input. Please try again");
      }
    }
    catch(VehicleNotFoundException e) {
    // thrown when vin not found in Vehicles collection
    // caught and handled here 
      System.out.println("No such vehicle with vin " + vin);
    }
    catch(ReservedVehicleException e) {
    // thrown when trying to reserve a vehicle already reserved
    // caught and handled here
      System.out.println("This vehicle is already reserved");  
    }
    catch(UnreservedVehicleException e) {
    // thrown when trying to retrieve a reservation that doesn't exist
    // thrown when trying to cancel a reservation that doesn't exist
    // caught and handled here
      System.out.println("This vehicle is unreserved");   
    }
    catch(AccountNotFoundException e) {
    // thrown when trying to retrieve a reservation that doesn't exist
    // thrown when trying to cancel a reservation that doesn't exist
    // caught and handled here  
      System.out.println("Account not found");
    }
    catch(NoReservationsException e) {
    // thrown when trying retrieve all reservations
    // caught and handled here 
      System.out.println("No reservations found");  
    }
    catch(NoAccountsException e) {
    // thrown when trying to retrieve all accounts
    // caught and handled here 
      System.out.println("No accounts found");  
    }
    catch(NoTransactionsException e) {
    // thrown when trying to retrieve all transactions
    // caught and handled here 
      System.out.println("No transactions found");  
    }
    catch(VINNotFoundException e) {

    }
  } // end of execute method


  public static String displayReservation(Scanner input) throws VINNotFoundException{
    Reservation r;
    // prompts user for vin
    System.out.println("Enter vehicle vin number");
    vin = input.next();

    
    veh = vehs.getVehicle(vin);
		r = veh.getReservation();
		return r.toString();
  }  

  private static void populateVehicles(Vehicles vehs) {
    veh = new Car("Ford Fusion - 2018", 34, 4, "AB4EG5689GM");
    vehs.add(veh);
    veh = new SUV("Dodge Caravan - 2019", 25, 5, 4, "QK3FT4273ME");
    vehs.add(veh);
    veh = new Truck("Eighteen-Foot (Truck)", 10, 5930, "KG4DM5472RK");
    vehs.add(veh);
    veh = new Car("Chevrolet Camaro - 2019", 30, 2, "KH4GM4564GQ");
    vehs.add(veh);
    veh = new SUV("Honda Odyssey - 2020", 28, 7, 6, "VM9RE2635TD");
    vehs.add(veh);
    veh = new Truck("Ten-Foot (Truck)", 12, 2810, "EJ5KU2437BD");
    vehs.add(veh);
    veh = new Car("Ford Fusion Hybrid", 32, 4, "KV4EG3245RV");
    vehs.add(veh);
    veh = new SUV("Ford Expidition - 2019", 21, 5, 3, "JK2HL8364HY");
    vehs.add(veh);
    veh = new Truck("Twenty-Four-Foot (Truck)", 8, 6500, "EB2WR3082OB");
    vehs.add(veh);
    veh = new Car("Chevrolet Impala - 2018", 32, 4, "RK3MB3266YH");
    vehs.add(veh);
    veh = new Truck("Twenty-Four-Foot (Truck)", 8, 6510, "TV3GH4390EK");
    vehs.add(veh);
}

    public static void populateAccounts(Accounts accts) {
      acct = new Account("9034712671991567", "Marshall Southgate", true);
      accts.add(acct);
      acct = new Account("2954224512902513", "Mani Hall", false);
      accts.add(acct);
      acct = new Account("4429092929691077", "Leona Devi", false);
      accts.add(acct);
      acct = new Account("8820458251970700", "Lakshmi Irving", false);
      accts.add(acct);
      acct = new Account("8091658612580570", "Emil Travers", true);
      accts.add(acct);
      acct = new Account("2769556715980826", "Rita Lemieux", true);
      accts.add(acct);
      acct = new Account("8878763809308093", "Liselotte Anderson", false);
      accts.add(acct);
    }

    public static void populateTransactions(Transactions trans) {
      CarRates cr = new CarRates();
      SUVRates sr = new SUVRates();
      TruckRates tr = new TruckRates();
      CurrentRates rate = new CurrentRates(cr, sr, tr);

      tran = new Transaction("8820458251970700", "Lakshmi Irving", 2, "14", 486, rate.calcActualCost(sr, 14, 486, true, false));
      trans.add(tran);
      tran = new Transaction("9034712671991567", "Marshall Southgate", 3, "45", 1382, rate.calcActualCost(tr, 45, 1382, true, true));
      trans.add(tran);
      tran = new Transaction("2769556715980826", "Rita Lemieux", 1, "5", 213, rate.calcActualCost(cr, 5, 213, false, false));
      trans.add(tran);
      tran = new Transaction("2954224512902513", "Mani Hall", 1, "21", 689, rate.calcActualCost(cr, 21, 689, true, true));
      trans.add(tran);
    }
  
    public static void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Display car rates\n2. Display SUV rates\n3. Display truck rates");
        System.out.println("4. Update car rates\n5. Update SUV rates\n6. Update truck rates");
        System.out.println("7. Display all available cars\n8. Display all available SUVs\n9. Display all available trucks ");
        System.out.println("10. Display all vehicles \n11. Make reservation\n12. Display reservation ");
        System.out.println("13. Cancel reservation\n14. Process returned rental\n15. View all reservations");
        System.out.println("16. View account\n17. View all accounts\n18. Add account\n19. View all transactions");
    }

    public static void displayAllVehicles(Vehicles vehs) {
      System.out.println("---All Agency Vehicles---");
      vehs.reset();
      while(vehs.hasNext())
      System.out.println(vehs.getNext());
    }

    public static void displayAllAvailCars(Vehicles vehs) {
      System.out.println("---All Available Cars---");
      vehs.reset();
      while(vehs.hasNext()) {
        veh = vehs.getNext();
        if(veh instanceof Car) {
          System.out.println(veh);
        }
      }
    }

    public static void displayAllAvailSUVs(Vehicles vehs) {
      System.out.println("---All Available SUVs---");
      vehs.reset();
      while(vehs.hasNext()) {
        veh = vehs.getNext();
        if(veh instanceof SUV) {
          System.out.println(veh);
        }
      }
    }

    public static void displayAllAvailTrucks(Vehicles vehs) {
      System.out.println("---All Available Cars---");
      vehs.reset();
      while(vehs.hasNext()) {
        veh = vehs.getNext();
        if(veh instanceof Truck) {
          System.out.println(veh);
        }
      }
    }

    public static void viewAccount() {
      System.out.println("Enter 16-digit credit card number");
      String ccn = input.next();
      acct = accts.getAccount(ccn);
      System.out.println(acct);
    }

    public static void viewAllAccounts(Accounts accts) {
      System.out.println("---All Accounts---");
      accts.reset();
      while(accts.hasNext()) {
        System.out.println(accts.getNext());
        System.out.println("");
      }
    }

    public static void addAccount(Scanner input) {
      boolean prime_cust;
      System.out.println("Enter 16-digit credit card number: ");
      String credit_card = input.next();
      System.out.println("Enter your first name: ");
      String company_name = input.next();
      System.out.println("Would you like to become a prime customer?");
      String answer = input.next();
      if(answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
        prime_cust = true;
      } else {
        prime_cust = false;
      }
      acct = new Account(credit_card, company_name, prime_cust);
      accts.add(acct);;
    }

    public static void viewAllTransactions(Transactions trans) {
      trans.reset();
      while(trans.hasNext()) {
        System.out.println(trans.getNext());
        System.out.println("");
      }
    }

    private static void createAccount(Accounts accts) throws InvalidCreditCardException {
      boolean prime;
      String ccn;
  
      System.out.println("Enter your first name");
      String name = input.next();
      System.out.println("Enter your credit card number");
      String output = input.next();
      if (output.length() != 16) {
        throw new InvalidCreditCardException();
      } else {
        ccn = output;
      }
      
      System.out.println("Would you like to pay a yearly fee to become a prime customer"); 
      System.out.println("and get a free 100 miles on every rental?");
      String answer = input.next();
      if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
        prime = true;
      } else {
        prime = false;
      }
  
      acct = new Account(ccn, name, prime);
      accts.add(acct);
      System.out.println("Account created successfully!");
    }

    public static void makeReservation() {
      boolean insur_selected;
		char timeUnit = 'D';
		int numUnits = 0;
		
		System.out.println("Do you have an account with us?");
		String yn = input.next();
		if(yn.charAt(0) == 'Y' || yn.charAt(0) == 'y') {
			System.out.println("Please enter your credit card number to verify");
			String ccn = input.next();
			acct = accts.getAccount(ccn);
			System.out.println("Welcome back " + acct.getCompanyName() + "!");
		}  else {
			createAccount(accts);
		}

		
		// prompt user for vin
		System.out.println("Enter vehicle vin number: ");
		String vin = input.next();
		input.nextLine();
		veh = vehs.getVehicle(vin);
		
		// prompt for how many days, weeks or months (and create TimeSpan object)
		System.out.println("About how long will you be renting this vehicle for?\n Enter '1' for days, '2' for weeks or '3' for months: ");
		int value = input.nextInt();
		switch(value){
			case 1:
				timeUnit = 'D';
				System.out.println("How many days? ");
				numUnits = input.nextInt();
				break;
			case 2:
				timeUnit = 'W';
				System.out.println("How many weeks? ");
				numUnits = input.nextInt();
				break;
			case 3:
				timeUnit = 'M';
				System.out.println("How many months? ");
				numUnits =input.nextInt();
				break;
			default:
				System.out.println("Invalid input");
		}

		TimeSpan rental_period = new TimeSpan(timeUnit, numUnits);

		// prompt for daily insurance option
		System.out.println("Would you like to pay for insurance? Enter 'y' for yes, 'n' for no ");
		char answer = input.next().charAt(0);
		if (answer == 'Y' || answer == 'y'){
			insur_selected = true;
		} else {
			insur_selected = false;
		}

		// Prompt user estimated miles that will be driven
		System.out.println("How many miles do you plan on driving in this vehicle in this timespan");
		int miles = input.nextInt();

		// Prompt user for vehicle type
		CarRates cr = new CarRates();
		SUVRates sr = new SUVRates();
		TruckRates tr = new TruckRates();
		CurrentRates estCost = new CurrentRates(cr, sr, tr);
		System.out.println("Enter vehicle type 1. Car 2. SUV 3. Truck");
		int vehType = input.nextInt();

		Reservation resv = 
       	new Reservation(acct.getCompanyName(), acct.getCreditCardNum(), rental_period, insur_selected);
    	veh.reserve(resv);

		Transaction t = new Transaction(acct.getCreditCardNum(), acct.getCompanyName(), vehType, rental_period.toString(), miles, estCost.calcEstimatedCost(vehType, rental_period, miles, insur_selected, acct.primeCustomer()));
		trans.add(t);
		System.out.println(t.toString());

		System.out.println("Reservation complete!");
		
		if (vehType == 1) {
			System.out.println("The estimated cost will be $" + df.format(estCost.calcEstimatedCost(vehType, rental_period, miles, insur_selected, acct.primeCustomer())));
		} else if (vehType == 2) {
			System.out.println("The estimated cost will be $" + df.format(estCost.calcEstimatedCost(vehType, rental_period, miles, insur_selected, acct.primeCustomer())));
		} else if (vehType == 3) {
			System.out.println("The estimated cost will be $" + df.format(estCost.calcEstimatedCost(vehType, rental_period, miles, insur_selected, acct.primeCustomer())));
		} else {
			System.out.println("Invalid input");
		}
    }

    public static void cancelReservation() {
      Reservation r;

		System.out.println("Enter vehicle VIN: ");
		String vin = input.next();
		veh = vehs.getVehicle(vin);
		r = veh.cancelReservation();
		veh.reserve(r);
		System.out.println("Reservation cancelled.");
    }

    public static void processReturnedRental() {
      boolean insur_selected;
		String ccn;
		
		System.out.println("Enter vehicle VIN: ");
		String vin = input.next();
		if(vehs.getVehicle(vin).isReserved()) {
			veh = vehs.getVehicle(vin);
		} else {
			throw new UnreservedVehicleException();
		}

		System.out.println("For exactly how many days did you have this rental?");
		int daysUsed = input.nextInt();

		System.out.println("How many miles did you drive during this rental period?");
		int miles = input.nextInt();

		System.out.println("Did you choose the daily insurance option?");
		String answer = input.next();
		if(answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
			insur_selected = true;
		} else {
			insur_selected = false;
		}

		System.out.println("Please enter credit card num: ");
		String value = input.next();
		if (value.length() != 16) {
			throw new InvalidCreditCardException();
		} else {
			ccn = value;
		}
		acct = accts.getAccount(ccn);
		boolean prime = acct.primeCustomer();

		CarRates cr = new CarRates();
		SUVRates sr = new SUVRates();
		TruckRates tr = new TruckRates();
		CurrentRates actCost = new CurrentRates(cr, sr, tr);

		System.out.println("Enter vehicle type 1. Car 2. SUV 3. Truck");
		int vehType = input.nextInt();


		System.out.println("Thank you for returning our vehicle");
		veh.cancelReservation();

		if (vehType == 1) {
			System.out.println("The total cost comes out to $" + df.format(actCost.calcActualCost(cr, daysUsed, miles, insur_selected, prime)));
		} else if (vehType == 2) {
			System.out.println("The total cost comes out to $" + df.format(actCost.calcActualCost(sr, daysUsed, miles, insur_selected, prime)));
		} else if (vehType == 3) {
			System.out.println("The total cost comes out to $" + df.format(actCost.calcActualCost(tr, daysUsed, miles, insur_selected, prime)));
		} else {
			System.out.println("Invalid input");
		}

		
    }

    public static void displayAllReservations() {
      for(int i = 0; i < SystemInterface.getAllReservations().length; i++) {
        System.out.println(SystemInterface.getAllReservations()[i]);
      }
    }

    public static void displayCarRates() {
        System.out.println(SystemInterface.getCarRates());
    }

    public static void displaySUVRates() {
        System.out.println(SystemInterface.getSUVRates());
    }

    public static void displayTruckRates() {
        System.out.println(SystemInterface.getTruckRates());
    }

    public static void updateCarRates(Scanner input) {
        CarRates cr = new CarRates();

        System.out.println("Enter new daily rate: ");
        double dailyRate = input.nextDouble();
        cr.dr = dailyRate;

        System.out.println("Enter new weekly rate: ");
        double weeklyRate = input.nextDouble();
        cr.wr = weeklyRate;

        System.out.println("Enter new monthly rate: ");
        double monthlyRate = input.nextDouble();
        cr.mr = monthlyRate;

        System.out.println("Enter new mileage charge: ");
        double mileageCharge = input.nextDouble();
        cr.mc = mileageCharge;

        System.out.println("Enter new insurance rate: ");
        double insuranceRate = input.nextDouble();
        cr.ir = insuranceRate;

        System.out.println(SystemInterface.updateCarRates(cr));
    }

    public static void updateSUVRates(Scanner input) {
      SUVRates sr = new SUVRates();

      System.out.println("Enter new daily rate: ");
      double dailyRate = input.nextDouble();
      sr.dr = dailyRate;

      System.out.println("Enter new weekly rate: ");
      double weeklyRate = input.nextDouble();
      sr.wr = weeklyRate;

      System.out.println("Enter new monthly rate: ");
      double monthlyRate = input.nextDouble();
      sr.mr = monthlyRate;

      System.out.println("Enter new mileage charge: ");
      double mileageCharge = input.nextDouble();
      sr.mc = mileageCharge;

      System.out.println("Enter new insurance rate: ");
      double insuranceRate = input.nextDouble();
      sr.ir = insuranceRate;

      System.out.println(SystemInterface.updateSUVRates(sr));
  }

  public static void updateTruckRates(Scanner input) {
    TruckRates tr = new TruckRates();

    System.out.println("Enter new daily rate: ");
    double dailyRate = input.nextDouble();
    tr.dr = dailyRate;

    System.out.println("Enter new weekly rate: ");
    double weeklyRate = input.nextDouble();
    tr.wr = weeklyRate;

    System.out.println("Enter new monthly rate: ");
    double monthlyRate = input.nextDouble();
    tr.mr = monthlyRate;

    System.out.println("Enter new mileage charge: ");
    double mileageCharge = input.nextDouble();
    tr.mc = mileageCharge;

    System.out.println("Enter new insurance rate: ");
    double insuranceRate = input.nextDouble();
    tr.ir = insuranceRate;

    System.out.println(SystemInterface.updateTruckRates(tr));
}

    private static boolean exit(Scanner input, boolean quit) {
      String answer;

      System.out.println("Would you like to exit program?"); 
      answer = input.next();
      if(answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
        return true;
      } else {
        return false;
      }
    }
} // end of Main class