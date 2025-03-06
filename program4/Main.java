// Abdalla Abdelmagid

import java.text.DecimalFormat;
import java.util.*;

class Main {

	static Scanner in = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("0.00");
	static Vehicle veh;
	static Account acct;
	public static void main(String[] args) {

		// Declare and populate vehicles collection
		Vehicles vehs = new Vehicles();
		Accounts accts = new Accounts();
		Transactions trans = new Transactions();
		populate(vehs);

		// Init
		boolean quit = false;
        int option;
    
		// Command loop
		while(!quit){
			try {
        
				displayMenu();

				if(in.hasNextInt()) {
				option = in.nextInt();

				switch(option) {
					case 1: createAccount(accts); break;
					case 2: accountInfo(accts); break;
					case 3: displayAllVehicles(vehs); break;
					case 4: displayAvailVehicles(vehs); break;
					case 5: reserveVehicle(vehs, accts, trans); break;
					case 6: displayReservation(vehs); break;
					case 7: cancelReservation(vehs); break;
					case 8: addVehicle(vehs); break;
					case 9: displayPrices(); break;
					case 10: returnRental(vehs, accts); break;
					case 11: quit = true;
				}
				} else {
					System.err.println("Invalid option. Try again");
           			in.nextLine();
				}
			}
		  catch (ReservedVehicleException e) {
			  System.out.println("* Vehicle Already Reserved *");
		  }
		  catch (VINNotFoundException e) {
			  System.out.println("* Vin not found *");
		  }
		  catch (UnreservedVehicleException e) {
			  System.out.println("* No Reservation for Vehicle Found *");
		  }
		  catch (AccountNotFoundException e) {
			  System.out.println("* Account not found *");
		  }
		  catch (InvalidCreditCardException e) {
			  System.out.println("* Invalid credit card number, must be 16 digits. *");
		  }
	  }
  }
  

	private static void displayPrices() {
		CarRates cr = new CarRates();
		System.out.println(cr.toString());

		SUVRates sr = new SUVRates();
		System.out.println(sr.toString());

		TruckRates tr = new TruckRates();
		System.out.println(tr.toString());
	}


	private static void accountInfo(Accounts accts) throws AccountNotFoundException{
		System.out.println("Please enter credit card number to verify identity");
		String ccn = in.next();
		in.nextLine();
		acct = accts.getAccount(ccn);
		System.out.println(acct);

	}


	private static void createAccount(Accounts accts) throws InvalidCreditCardException {
		boolean prime;
		String ccn;

		System.out.println("Enter your first name");
		String name = in.next();
		System.out.println("Enter your credit card number");
		String output = in.next();
		if (output.length() != 16) {
			throw new InvalidCreditCardException();
		} else {
			ccn = output;
		}
		
		System.out.println("Would you like to pay a yearly fee to become a prime customer"); 
		System.out.println("and get a free 100 miles on every rental?");
		String input = in.next();
		if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
			prime = true;
		} else {
			prime = false;
		}

		acct = new Account(ccn, name, prime);
		accts.add(acct);
		System.out.println("Account created successfully!");
	}


	private static void populate(Vehicles vehs) {
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


	private static void addVehicle(Vehicles vehs) {
		int type, mpg, seats, cargoCapacity, loadCapacity;
		String make, vin;
		System.out.println("What type of Vehicle would you like to add?" +
						   "Type '1' for car, '2' for SUV, '3' for truck");
		type = in.nextInt();
		in.nextLine();
		switch(type){
			case 1:
				System.out.println("What is the make/model and year of this car? ");
				make = in.nextLine();
				System.out.println("What is this car MPG? ");
				mpg = in.nextInt();
				System.out.println("How many seats does this car have? ");
				seats = in.nextInt();
				System.out.println("What is this car's VIN? ");
				vin = in.next();
				Vehicle c = new Car(make, mpg, seats, vin);
				vehs.add(c);
				break;
			case 2:
				System.out.println("What is the make/model and year of this SUV? ");
				make = in.nextLine();
				System.out.println("What is this SUV's MPG? ");
				mpg = in.nextInt();
				System.out.println("How many seats does this SUV have? ");
				seats = in.nextInt();
				System.out.println("What is this SUV's cargo capacity? ");
				cargoCapacity = in.nextInt();
				System.out.println("What is this SUV's VIN? ");
				vin = in.next();
				Vehicle s = new SUV(make, mpg, seats, cargoCapacity, vin);
				vehs.add(s);
				break;
			case 3:
				System.out.println("What is the length of this truck? ");
				make = in.nextLine();
				System.out.println("What is this truck's MPG? ");
				mpg = in.nextInt();
				System.out.println("What is the load capacity of this truck? ");
				loadCapacity = in.nextInt();
				System.out.println("What is this car's VIN? ");
				vin = in.next();
				Vehicle t = new Truck(make, mpg, loadCapacity, vin);
				vehs.add(t);
				break;
			default:
				System.out.println("Invalid input");
		}
	}


	private static void cancelReservation(Vehicles vehs) throws UnreservedVehicleException {
		Reservation r;

		System.out.println("Enter vehicle VIN: ");
		String vin = in.next();
		veh = vehs.getVehicle(vin);
		r = veh.cancelReservation();
		veh.reserve(r);
		System.out.println("Reservation cancelled.");
	}


	private static void displayReservation(Vehicles vehs) throws UnreservedVehicleException{
		Reservation r;

		System.out.println("Enter vehicle VIN: ");
		String vin = in.next();
		veh = vehs.getVehicle(vin);
		r = veh.getReservation();
		System.out.println(r.toString());
	}


	public static void displayAvailVehicles(Vehicles v) {
		System.out.println("Available vehicles: ");
		v.reset();
		
		while(v.hasNext()) {
			veh = v.getNext();       
	
			if(!veh.isReserved())
				 System.out.println(veh.toString());
		}
	  }


	public static void displayAllVehicles(Vehicles vehs){
		System.out.println("ALL AGENCY VEHICLES: ");
		vehs.reset();
		while(vehs.hasNext()){
			System.out.println(vehs.getNext());  // relies on implemented toString()
		}
	}

	public static void reserveVehicle(Vehicles vehs, Accounts accts, Transactions trans) throws ReservedVehicleException, AccountNotFoundException {
		boolean insur_selected;
		char timeUnit = 'D';
		int numUnits = 0;
		
		System.out.println("Do you have an account with us?");
		String yn = in.next();
		if(yn.charAt(0) == 'Y' || yn.charAt(0) == 'y') {
			System.out.println("Please enter your credit card number to verify");
			String ccn = in.next();
			acct = accts.getAccount(ccn);
			System.out.println("Welcome back " + acct.getCompanyName() + "!");
		}  else {
			createAccount(accts);
		}

		
		// prompt user for vin
		System.out.println("Enter vehicle vin number: ");
		String vin = in.next();
		in.nextLine();
		veh = vehs.getVehicle(vin);
		
		// prompt for how many days, weeks or months (and create TimeSpan object)
		System.out.println("About how long will you be renting this vehicle for?\n Enter '1' for days, '2' for weeks or '3' for months: ");
		int input = in.nextInt();
		switch(input){
			case 1:
				timeUnit = 'D';
				System.out.println("How many days? ");
				numUnits = in.nextInt();
				break;
			case 2:
				timeUnit = 'W';
				System.out.println("How many weeks? ");
				numUnits = in.nextInt();
				break;
			case 3:
				timeUnit = 'M';
				System.out.println("How many months? ");
				numUnits =in.nextInt();
				break;
			default:
				System.out.println("Invalid input");
		}

		TimeSpan rental_period = new TimeSpan(timeUnit, numUnits);

		// prompt for daily insurance option
		System.out.println("Would you like to pay for insurance? Enter 'y' for yes, 'n' for no ");
		char answer = in.next().charAt(0);
		if (answer == 'Y' || answer == 'y'){
			insur_selected = true;
		} else {
			insur_selected = false;
		}

		// Prompt user estimated miles that will be driven
		System.out.println("How many miles do you plan on driving in this vehicle in this timespan");
		int miles = in.nextInt();

		// Prompt user for vehicle type
		CarRates cr = new CarRates();
		SUVRates sr = new SUVRates();
		TruckRates tr = new TruckRates();
		CurrentRates estCost = new CurrentRates(cr, sr, tr);
		System.out.println("Enter vehicle type 1. Car 2. SUV 3. Truck");
		int vehType = in.nextInt();

		Reservation resv = 
       	new Reservation(acct.getCompanyName(), acct.getCreditCardNum(), rental_period, insur_selected);
    	veh.reserve(resv);

		Transaction t = new Transaction(acct.getCreditCardNum(), acct.getCompanyName(), vehType, rental_period.toString(), miles, estCost.toString());
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

	public static void returnRental(Vehicles vehs, Accounts accts) throws UnreservedVehicleException, InvalidCreditCardException{
		boolean insur_selected;
		String ccn;
		
		System.out.println("Enter vehicle VIN: ");
		String vin = in.next();
		if(vehs.getVehicle(vin).isReserved()) {
			veh = vehs.getVehicle(vin);
		} else {
			throw new UnreservedVehicleException();
		}

		System.out.println("For exactly how many days did you have this rental?");
		int daysUsed = in.nextInt();

		System.out.println("How many miles did you drive during this rental period?");
		int miles = in.nextInt();

		System.out.println("Did you choose the daily insurance option?");
		String answer = in.next();
		if(answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
			insur_selected = true;
		} else {
			insur_selected = false;
		}

		System.out.println("Please enter credit card num: ");
		String input = in.next();
		if (input.length() != 16) {
			throw new InvalidCreditCardException();
		} else {
			ccn = input;
		}
		acct = accts.getAccount(ccn);
		boolean prime = acct.primeCustomer();

		CarRates cr = new CarRates();
		SUVRates sr = new SUVRates();
		TruckRates tr = new TruckRates();
		CurrentRates actCost = new CurrentRates(cr, sr, tr);

		System.out.println("Enter vehicle type 1. Car 2. SUV 3. Truck");
		int vehType = in.nextInt();


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

    public static void displayMenu() {
        System.out.println("1. Create an account\n2. View account info\n3. Display all vehicles");
		System.out.println("4. Display all available vehicles\n5. Reserve vehicle\n6. Display reservation");
		System.out.println("7. Cancel reservation\n8. Add vehicle\n9. Display prices\n10. Return rental\n11. Quit");
    }
}