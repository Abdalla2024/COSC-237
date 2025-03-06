// Abdalla Abdelmagid

public class Vehicles {

    private Vehicle[] agencyVehicles = new Vehicle[25]; // array of Vehicle objects
    private int current; // used by iterator methods only

    public Vehicles() {
        current = 0;
    }

    public void add(Vehicle v) {
        agencyVehicles[current] = v;
        current++; 
    } 

    public Vehicle getVehicle(String VIN) throws VINNotFoundException{
        Vehicle v = null;
        for(int i = 0; i < agencyVehicles.length; i++) {
            if(VIN.equals(agencyVehicles[i].getVin())) {
                v = agencyVehicles[i];
                break;
            } else if (agencyVehicles[i + 1] == null) {
                System.out.println("Vin not found");
                throw new VINNotFoundException();
            }
        }
        return v;
    }

    public void reset() {   // resets to first vehicle in list
        current = 0;
    }

    public boolean hasNext() {  // returns true if more vehicles in list to retrieve
        return agencyVehicles[current]!= null;
    }

    public Vehicle getNext() {   // returns next vehicle in list
        Vehicle v;
        if (current == 0) {
            v = agencyVehicles[0];
            current++;
            return v;
        } else {
            v = agencyVehicles[current];
            current++;
            return v;
        }
    }
}
