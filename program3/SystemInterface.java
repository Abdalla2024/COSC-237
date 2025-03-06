// Abdalla Abdelmagid

public class SystemInterface {
  
    // Four major aggregation objects
    private static CurrentRates veh_rates;
    private static Vehicles vehs;
    private static Accounts accts;
    private static Transactions trans;
    private static Vehicle v;
  
    // Takes the place of a constructor (for static variables)
    public static void initSystem(CurrentRates rates,
                                  Vehicles v,
                                  Accounts a,
                                  Transactions t) {
      veh_rates = rates;
      vehs = v;
      accts = a;
      trans = t;
    }
  
    // Use Case Methods
    public static void getCurrentRates(){
        CarRates cr = new CarRates();
		System.out.println(cr.toString());

		SUVRates sr = new SUVRates();
		System.out.println(sr.toString());

		TruckRates tr = new TruckRates();
		System.out.println(tr.toString());
    }
    
    public static String updateCarRates(CarRates new_rates) {
        veh_rates.setCarRates(new_rates);
        return "Car rates updated";
    }
    
    public static String updateSUVRates(SUVRates new_rates) {
        veh_rates.setSUVRates(new_rates);
        return "SUV rates updated";
    }
    
    public static String updateTruckRates(TruckRates new_rates) {
        veh_rates.setTruckRates(new_rates);
        return "Truck rates updated";
    }
    
    public static String[] getAvailCars() { 
      int num_vehicles = 0;
      
      // Count how many unreserved cars
      vehs.reset();
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(v instanceof Car && !v.isReserved())
          num_vehicles = num_vehicles + 1;
      }
      // Add each unreserved vehicle in the array
      String[] results = new String[num_vehicles];
      int i = 0;
      
      vehs.reset();
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(v instanceof Car && !v.isReserved())
          results[i] = v.toString();  
      }
        return results;
      } 
      
      
    public static String[] getAvailSuvs() {
      int num_vehicles = 0;
      String[] results = new String[num_vehicles];
  
      // Count how many unreserved SUVs
      vehs.reset();
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(v instanceof SUV && !v.isReserved())
          num_vehicles = num_vehicles + 1;
      }
      // Add each unreserved vehicle in the array
      vehs.reset();
      int i = 0;
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(v instanceof SUV && !v.isReserved())
          results[i] = v.toString();  
      }
        
      return results;
      }
      
      
    public static String[] getAvailTrucks() {
      int num_vehicles = 0;
      String[] results = new String[num_vehicles];
  
      // Count how many unreserved trucks
      vehs.reset();
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(v instanceof Truck && !v.isReserved())
          num_vehicles = num_vehicles + 1;
      }
  
      // Add each unreserved vehicle in the array
      vehs.reset();
      int i = 0;
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(v instanceof Truck && !v.isReserved())
          results[i] = v.toString();  
      }
        
      return results;  
      }
      
      
    public static String[] getAllVehicles() {
      Vehicle v;
      int num_vehicles = 0;
      String[] results = new String[num_vehicles];
  
      // Count how many unreserved cars
      vehs.reset();
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(!v.isReserved())
          num_vehicles = num_vehicles + 1;
  
      // Add each unreserved vehicle in the array
      vehs.reset();
      int i = 0;
      while(vehs.hasNext()) {
        v = vehs.getNext();
        if(!v.isReserved())
          results[i] = v.toString();  
      }
        
      
      }
      return results;
    }
  
    public static String getEstimatedRentalCost(String vin, int days, int miles) {
        double estCost = 0;
        int vehType;
        Vehicle veh;
        Reservation r;
        Account acct;

        veh = vehs.getVehicle(vin);
        r = veh.getReservation();
        acct = accts.getAccount(r.getCreditCardNum());

        if (veh instanceof Car) {
            vehType = 1;
            estCost = veh_rates.calcEstimatedCost(vehType, r.getRentalPeriod(), miles, r.insuranceSelected(), acct.primeCustomer());
        } else if(veh instanceof SUV) {
            vehType = 2;
            estCost = veh_rates.calcEstimatedCost(vehType, r.getRentalPeriod(), miles, r.insuranceSelected(), acct.primeCustomer());
        } else if(veh instanceof Truck) {
            vehType = 3;
            estCost = veh_rates.calcEstimatedCost(vehType, r.getRentalPeriod(), miles, r.insuranceSelected(), acct.primeCustomer());
        }

        return "The estimated cost comes out to $" + estCost;
    }
    
    public static void processReturnedVehicle(String vin, int num_days_had, int num_miles_driven) throws 
                                            VehicleNotFoundException, ReservationNotFoundException {
        
        Vehicle veh;
        Reservation r;
        Account acct;
        double cost;
                                    
        if(vehs.getVehicle(vin).isReserved()) {
            veh = vehs.getVehicle(vin);
        } else {
            throw new UnreservedVehicleException();
        }

        r = veh.getReservation();
        acct = accts.getAccount(r.getCreditCardNum());

        if (veh instanceof Car) {
            cost = veh_rates.calcActualCost(new CarRates(), num_days_had, num_miles_driven, r.insuranceSelected(), acct.primeCustomer());
            System.out.println(cost);
        } else if (veh instanceof SUV) {
            cost = veh_rates.calcActualCost(new SUVRates(), num_days_had, num_miles_driven, r.insuranceSelected(), acct.primeCustomer());
            System.out.println(cost);
        } else if (veh instanceof Truck) {
            cost = veh_rates.calcActualCost(new TruckRates(), num_days_had, num_miles_driven, r.insuranceSelected(), acct.primeCustomer());
            System.out.println(cost);
        }

        
    }
    
    public static String makeReservation(ReservationDetails details) throws
                                           VehicleNotFoundException, ReservedVehicleException { 
      String vin = details.getVin();
      Vehicle veh = vehs.getVehicle(vin);  // this may throw a VehicleNotFoundException
  
      if(veh.isReserved())
        throw new ReservedVehicleException();
  
      Reservation resv = new Reservation(details.getName(), details.getCreditCard(), details.getRentalPeriod(),
                                           details.getInsuranceSelected());
      
      veh.reserve(resv);
  
      return "Reservation successfully made";
    }
    
    public static String cancelReservation(String vin) throws
                                  VehicleNotFoundException, UnreservedVehicleException {
      Vehicle veh;
      Reservation r;
      veh = vehs.getVehicle(vin);
      r = veh.cancelReservation();
      veh.reserve(r);
      return "Reservation cancelled";  
    }
    
    public static String getReservation(String vin) throws
                                  VehicleNotFoundException, UnreservedVehicleException {
        
        Reservation r;
        Vehicle veh;
        veh = vehs.getVehicle(vin);
        r = veh.getReservation();
        return r.toString();
    }
    
    public static String[] getAllReservations() throws NoReservationsException {
      Reservation r;
      int num_reservations = 0;
      String[] results = new String[num_reservations];
  
      // Count how many unreserved cars
      vehs.reset();
      while(vehs.hasNext()) {
        if(v.isReserved()) {
          num_reservations = num_reservations + 1;
        }
      }
  
      // Add each unreserved vehicle in the array
      vehs.reset();
      int i = 0;
      while(vehs.hasNext()) {
        v = vehs.getNext();
        r = v.getReservation();
        if(v.isReserved())
          results[i] = v.toString(); 
          i++; 
      }
        
      
      return results;
    }
  
    public static String addAccount(String credit_card, String company_name, boolean prime_cust) {
        Account acct = new Account(credit_card, company_name, prime_cust);
		accts.add(acct);
		return "Account created successfully!";
    }
    
    public static String getAccount(String credit_card) throws AccountNotFoundException {
        Account acct = accts.getAccount(credit_card);
        return acct.toString();
    }
  
    public static String[] getAllAccounts() throws NoAccountsException {
        int num_accounts = 0;
        Account acct;
        
        accts.reset();
        while(accts.hasNext()) {
            num_accounts++;
        }

        String[] results = new String[num_accounts];
        int i = 0;
        accts.reset();
        while(accts.hasNext()) {
            acct = accts.getNext();
            results[i] = acct.toString();
        }

        return results;
    }
    
    public static String[] getAllTransactions() throws NoTransactionsException {
        int num_transactions = 0;
        Transaction t;

        trans.reset();
        while(trans.hasNext()) {
            num_transactions++;
        }

        String[] results = new String[num_transactions];
        int i = 0;
        trans.reset();
        while(trans.hasNext()) {
            t = trans.getNext();
            results[i] = t.toString();
            i++;
        }

        return results;
    }

    public static String getCarRates() {
        return veh_rates.getCarRates() + "";
    }

    public static String getSUVRates() {
        return veh_rates.getSUVRates() + "";
    }

    public static String getTruckRates() {
        return veh_rates.getTruckRates() + "";
    }
          
  }